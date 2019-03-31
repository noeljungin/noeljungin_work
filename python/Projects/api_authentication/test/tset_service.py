import bcrypt
import pytest
import config
import jwt
from model.user_dao import UserDao
from model.tweet_dao import TweetDao
from services.tweet_service import TweetService
from services.user_service import UserService
from sqlalchemy import create_engine, text

database = create_engine(config.test_config['DB_URL'], encoding='utf-8', max_overflow=0)

@pytest.fixture
def user_service():
    return UserService(UserDao(database), config.test_config)

@pytest.fixture
def tweet_service():
    return TweetService(TweetDao(database))

def setup_function():
    hashed_password = bcrypt.hashpw(
        b"1q2w3e4r",
        bcrypt.gensalt()
    )
    new_users = [
        {
            'id': 11,
            'name': 'yulim11',
            'email': 'test11@gmail.com',
            'profile': 'test_profile11',
            'hashed_password': hashed_password
        },
        {
            'id': 12,
            'name': 'yulim12',
            'email': 'test12@gmail.com',
            'profile': 'test_profile12',
            'hashed_password': hashed_password
        }
    ]
    database.execute(text("""
        INSERT INTO users (
            id,
            name,
            email,
            profile,
            hashed_password
        ) VALUES (
            :id,
            :email,
            :profile,
            :hashed_password
        )
    """), new_users)

    database.execute(text("""
        INSERT INTO tweets (
            user_id,
            tweet
        ) VALUES (
            12,
            "hi there"
        )
    """))

def teardown_function():
    database.execute(text("SET FOREIGN_KEY_CHECKS=0"))
    database.execute(text("TRUNCATE users"))
    database.execute(text("TRUNCATE tweets"))
    database.execute(text("TRUNCATE user_follow_list"))
    database.execute(text("SET FOREIGN_KEY_CHECKS=1"))

def get_user(user_id):
    row = database.execute(text("""
        SELECT
            id,
            name,
            email,
            profile
        FROM users
        WHERE id = :user_id
    """),{
        'user_id': user_id
    }).fetchone()

    return {
        'id': row['id'],
        'name': row['name'],
        'email': row['email'],
        'profile': row['profile']
    } if row else None

def get_follow_list(user_id):
    rows = database.execute(text("""
        SELECT follow_user_id as id
        FROM user_follow_list
        WHERE user_id = :user_id    
    """),{
        'user_id': user_id
    }).fetchall()

def test_create_new_user(user_service):
    new_user = {
        'name': 'testasdfasdf',
        'email': 'asjdkfhasldkf@gmail.com',
        'profile': 'aszxcv',
        'password': '1q2w3e4r'
    }
    new_user_id = user_service.create_new_user(new_user)
    created_user = get_user(new_user_id)

    assert created_user == {
        'id': new_user_id,
        'name': new_user['name'],
        'profile': new_user['profile'],
        'email': new_user['email']
    }

def test_login(user_service):
    assert user_service.login({
        'email': 'test1@gmail.com',
        'password': '1q2w3e4r'
    })

    assert not user_service.login({
        'email': 'test1@gmail.com',
        'password': '1234'
    })

def test_generate_access_token(user_service):
    token = user_service.generate_access_token(11)
    payload = jwt.decode(token, config.JWT_SECRET_KEY, 'HS256')

    assert payload['user_id'] == 11

def test_follow(user_service):
    user_service.follow(11, 12)
    follow_list = get_follow_list(11)
    assert follow_list == [12]

def test_unfollow(user_service):
    user_service.follow(11, 12)
    user_service.unfollow(11, 12)
    follow_list = get_follow_list(11)

    assert follow_list == []

def test_tweet(tweet_service):
    tweet_service.tweet(11, "tweet test 11")
    timeline = tweet_service.get_timeline(11)

    assert timeline == [
        {
            'user_id': 11,
            'tweet': 'tweet test'
        }
    ]

def test_timeline(user_service, tweet_service):
    tweet_service.tweet(11, "test11")
    tweet_service.tweet(12, "test12")
    user_service.follow(11, 12)

    timeline = tweet_service.get_timeline(11)

    assert timeline == [
        {
            'user_id': 12,
            'tweet': 'test12asdfkjasdhfjlashlkdf'
        },
        {
            'user_id': 11,
            'tweet': 'ahjsdfhklasdfhkjlasdfhkjl'
        },
        {
            'user_id': 12,
            'tweet': 'asdkjfashkldfjasdhkjlfasdfhkjl'
        }
    ]

