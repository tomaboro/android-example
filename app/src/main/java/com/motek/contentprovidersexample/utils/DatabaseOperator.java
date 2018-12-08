package com.motek.contentprovidersexample.utils;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

public class DatabaseOperator {
    private String table;
    private String database;
    private SQLiteDatabase db;

    public DatabaseOperator(String table, String database) {
        this.table = table;
        this.database = database;
    }

    public void insert(ContentValues values) {
        db.insert(table, "", values);
    }

    public void delete(String key, String selection, String[] selectionArgs) {
        db.delete( table, "key" +  " = " + key +
                        (!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : ""), selectionArgs);
    }

    public Cursor buildQuery(String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(table);
        qb.setProjectionMap(new HashMap<String, String>());

        return qb.query(db,	projection,	selection, selectionArgs,null, null, sortOrder);
    }
    
    public void update(String key, String selection, String[] selectionArgs, ContentValues values) {
        db.update(table, values,
                "key" + " = " + key +
                        (!TextUtils.isEmpty(selection) ? " AND (" +selection + ')' : ""), selectionArgs);
    }
}
