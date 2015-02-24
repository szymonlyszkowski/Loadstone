sqlite3 loadStoneDataBase <<EOS
.headers on
CREATE TABLE cala_polska (
    "name" TEXT,
    "latitude" REAL,
    "longitude" REAL,
    "accuracy" REAL,
    "sattelites" INTEGER,
    "priority" INTEGER,
    "userid" INTEGER,
    "id" INTEGER
);
.separator ,
.import $1 cala_polska 
.tables
.schema cala_polska
EOS
