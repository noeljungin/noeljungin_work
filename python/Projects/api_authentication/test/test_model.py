import bcrypt
import pytest
import config
from services.user_service import UserService
from services.tweet_service import TweetService
from model.user_dao import UserDao
from model.tweet_dao import TweetDao
from sqlalchemy import create_engine, text

database = create_engine(config.test_config['DB_URL'], encoding='utf-8', max_overflow=0)

@pytest.fixture
def user_service():
    return UserService(UserDao(database), config.test_config)

@pytest.fixture
def tweet_service():
    return UserService(UserDao(database), config.test_config)

@pytest.fixture
def tweet_service():
    return TweetService(TweetDao(database))

def setup_function():

    hashed_password =  bcrypt.hashpw(
        b"test password",
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
        INSERT INTO users(
            id,
            name,
            email,
            hashed_password
        ) VALUES(
            :id,
            :name,
            :email,
            :hashed_password
        )
    """), new_users)

    database.execute(text("""
        INSERT INTO tweets(
            user_id,
            tweet
        ) vALUES (
            2,
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
    """), {
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

    return [int(row['id']) for row in rows]

def test_insert_user(user_dao):
    new_user = {
        'name': 'yurim',
        'email': 'yy@gmail.com',
        'profile': 'asdf',
        'password': '1q2w3e4r'
    }

    new_user_id = user_dao.insert_user(new_user)
    user = get_user(new_user_id)

    assert user == {
        'id': new_user_id,
        'name': new_user['name'],
        'email': new_user['email'],
        'profile': new_user['profile']
    }

def test_get_user_id_and_password(user_dao):
    user_credential = user_dao.get_user_id_and_password(email = 'test11@gmail.com')
    assert user_credential['id'] == 11

    assert bcrypt.checkpw('1q2w3e4r'.encode('UTF-8'), user_credential['hashed_password'].encode('UTF-8'))

def test_insert_follow(user_dao):
    user_dao.insert_follow(user_id=11, follow_id=12)
    follow_list = get_follow_list(11)
    assert follow_list == [12]

def test_insert_unfollow(user_dao):
    user_dao.insert_follow(user_id = 11, follow_id = 12)
    user_dao.insert_unfollow(user_id = 11, unfollow_id = 12)
    follow_list = get_follow_list(11)
    assert follow_list == []

def test_insert_tweet(tweet_dao):
    tweet_dao.insert_tweet(11, "tweet test")
    timeline = tweet_dao.get_timeline(11)

    assert timeline == [
        {
            'user_id': 11,
            'tweet': 'tweet test'
        }
    ]

def test_timeline(user_dao, tweet_dao):
    tweet_dao.insert_tweet(11, "tweet test 11")
    tweet_dao.insert_tweet(12, "tseet test 12")
    user_dao.insert_follow(11, 12)

    timeline = tweet_dao.get_timeline(11)

    assert timeline == [
        {
            'user_id': 12,
            'tweet': 'hi there'
        },
        {
            'usre_id': 11,
            'tweet': 'hi!!'
        },
        {
            'user_id': 12,
            'tweet': "asdf"
        }
    ]
