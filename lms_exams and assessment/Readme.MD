./mongod --dbpath ~/Mongodata/

./mongo

use lms_db;

db.createUser({user : "root", pwd : "12345", roles : [{role : "readWrite", db : "lms_db"}]});

Exit

./mongod --auth --dbpath ~/Mongodata/

./mongo localhost/lms_db -u 'root' -p '12345';

db.createCollection("user")

db.user.insert({"email" : "ckthambugala@gmail.com", "password": "1234", "name": "Chathuri", "role": "TEACHER", "regdate" : "2024-08-05"});

db.user.insert({"email" : "kthambugala@gmail.com", "password": "admin", "name": "Kaushalya", "role": "TEACHER", "regdate" : "2024-08-05"});
