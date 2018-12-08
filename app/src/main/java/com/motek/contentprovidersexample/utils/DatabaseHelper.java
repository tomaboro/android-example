package com.motek.contentprovidersexample.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private final int DATABASE_VERSION = 1;
    private final String databaseName;
    private final String tableName;
    private String getCreateTableQuery() {
        return " CREATE TABLE " + tableName +
                " (key TEXT PRIMARY KEY, " +
                " value TEXT NOT NULL);";
    }

    DatabaseHelper(Context context, String databaseName, String tableName){
        super(context, databaseName, null, 1);
        this.databaseName = databaseName;
        this.tableName = tableName;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(getCreateTableQuery());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +  tableName);
        onCreate(db);
    }
}
