from sqlalchemy import create_engine, text
db = {
    'user'      : 'root',
    'password'  : '123456',
    'host'      : '127.0.0.1',
    'port'      : 3306,
    'database'  : 'miniter'
        }

DB_URL = f"mysql+mysqlconnector://{db['user']}:{db['password']}@{db['host']}:{db['port']}/{db['database']}?charset=utf8"
