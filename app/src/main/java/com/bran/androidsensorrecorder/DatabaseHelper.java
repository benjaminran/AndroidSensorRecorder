package com.bran.androidsensorrecorder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by beni on 11/6/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "RestroomDetection.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_TABLE_FOO = "CREATE TABLE foo ( bar text );";
    private static final String SQL_DELETE_TABLE_FOO = "DROP TABLE foo;";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("DR", "DatabaseHelper: constructor called");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DR", "DatabaseHelper: onCreate called");
        db.execSQL(SQL_CREATE_TABLE_FOO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABLE_FOO); // just delete the old data for now
        onCreate(db);
    }
}
