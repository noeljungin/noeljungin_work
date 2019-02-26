from flask      import Flask, request, jsonify, current_app
from flask.json import JSONEncoder
from sqlalchemy import create_engine, text



## Default JSON encoder는 set를 JSON으로 변환할 수 없다.
## 그럼으로 커스텀 엔코더를 작성해서 set을 list로 변환하여
## JSON으로 변환 가능하게 해주어야 한다.
class CustomJSONEncoder(JSONEncoder):
    def default(self, obj):
        if isinstance(obj, set):
            return list(obj)

        return JSONEncoder.default(self, obj)
#app = Flask(__name__)

#app.id_count     = 1
#app.users        = {}
#app.tweets       = []
#app.json_encoder = CustomJSONEncoder



def create_app(test_config = None):
    app = Flask(__name__)

    if test_config is None:
        app.config.from_pyfile("config.py")
    else:
        app.config.update(test_config)

    database = create_engine(app.config['DB_URL'], encoding = 'utf-8', max_overflow = 0)
    app.database = database

    @app.route("/ping", methods=['GET'])
    def ping():
        return "pong"

    @app.route("/sign-up", methods=['POST'])
    def sign_up():
        new_user        = request.json
        new_user_id     = app.database.execute(text("""
            INSERT INTO users (
                name,
                email,
                profile,
                hashed_password
            ) VALUES (
                :name,
                :email,
                :profile,
                :password
            )
        """), new_user).lastrowid

        row = current_app.database.execute(text("""
            SELECT
                id,
                name,
                email,
                profile
            FROM users
            WHERE id = :user_id
        """), {
            'user_id' : new_user_id
         }).fetchone()

        create_user = {
                'id'        : row['id'],
                'name'      : row['name'],
                'email'     : row['email'],
                'profile'   : row['profile']
         } if row else None

        return jsonify(create_user)



    @app.route('/tweet', methods=['POST'])
    def tweet():
        user_tweet   = request.json
        tweet        = user_tweet['tweet']

        if len(tweet) > 300:
            return 'over 300 word', 400
        
        app.database.execute(text("""
            INSERT INTO tweets (
                user_id,
                tweet
                ) VALUES (
                :id,
                :tweet
                )
            """), user_tweet)

        return jsonify(tweet), 200


        
    @app.route('/follow', methods=['POST'])
    def follow():
        user_follow         = request.json
        user_id             = user_follow['id']
        follow              = user_follow['follow']

        app.database.execute(text("""
            INSERT INTO user_follow_list (
                user_id,
                follow_user_id
            ) VALUES (
                :id,
                :follow
                )
            """), user_follow).rowcount

        return jsonify({'user_id': user_id, 'follow':follow})



    @app.route('/unfollow', methods=['POST'])
    def unfollow():
        user_unfollow       = request.json
        user_id             = user_unfollow['id']
        unfollow            = user_unfollow['unfollow']

        app.database.execute(text("""
            DELETE FROM user_follow_list
            WHERE user_id = :id
            AND follow_user_id = :unfollow
        """), user_unfollow).rowcount

        return jsonify({'user_id': user_id, 'unfollow': unfollow})



    @app.route('/timeline/<int:user_id>', methods=['GET'])
    def timeline(user_id):
        rows = app.database.execute(text("""
            SELECT
                t.user_id,
                t.tweet
            FROM tweets t
            LEFT JOIN user_follow_list ufl ON ufl.user_id = :user_id
            WHERE t.user_id = :user_id
            OR t.user_id = ufl.follow_user_id
        """), {
            'user_id' : user_id
        }).fetchall()

        timeline = [{
            'user_id'   : row['user_id'],
            'tweet'     : row['tweet']

        } for row in rows]

        return jsonify({
            'user_id'   : user_id,
            'timeline'  : timeline
            })

    return app

print("test")
