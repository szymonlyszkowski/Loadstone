#!/bin/sh
sqlite3 $2.db <<EOS
.headers on
CREATE TABLE TotalData (
    "name" TEXT,
    "latitude" REAL,
    "longitude" REAL,
    "accuracy" REAL,
    "satellites" INTEGER,
    "priority" INTEGER,
    "userid" INTEGER,
    "id" INTEGER
);
.separator ,
.import $1 TotalData
 CREATE TABLE DatabaseInfo ( version INT, createdDate DATETIME, accessedDate DATETIME);
 INSERT INTO DatabaseInfo(version, createdDate, accessedDate) VALUES (1,datetime('now'),datetime('now'));
.tables
.schema TotalData
.schema DatabaseInfo
EOS
