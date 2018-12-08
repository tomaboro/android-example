package com.motek.contentprovidersexample.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.motek.contentprovidersexample.utils.DatabaseHelper;
import com.motek.contentprovidersexample.utils.DatabaseOperator;

import java.util.HashMap;

public class MyContentProvider extends ContentProvider {
    private SQLiteDatabase db;
    private DatabaseOperator operator;
    private String database = "myDB";
    private String table = "someTable";

    public static final String PROVIDER_NAME = "com.motek.contentprovidersexample.providers.MyContentProvider";
    public static final String URL = "content://" + PROVIDER_NAME + "/values";
    public static final Uri URI = Uri.parse(URL);



    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        operator.delete(uri.getPathSegments().get(1),selection,selectionArgs);
        return 1;
    }

    @Override
    public String getType(Uri uri) {
        return "vnd.android.cursor.item";
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        operator.insert(values);
        return uri;
    }

    @Override
    public boolean onCreate() {
        Context context = getContext();
        DatabaseHelper dbHelper = new DatabaseHelper(context,database,table);
        db = dbHelper.getWritableDatabase();
        operator = new DatabaseOperator(table,database,db);
        return db != null;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        return operator.buildQuery(projection,selection,selectionArgs,sortOrder);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        operator.update(uri.getPathSegments().get(1),selection,selectionArgs,values);
        return 1;
    }
}
