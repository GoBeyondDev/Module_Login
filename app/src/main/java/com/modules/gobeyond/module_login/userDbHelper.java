package com.modules.gobeyond.module_login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rramirez on 12/2/15.
 */
public class userDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "users.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + userContract.userEntry.TABLE_NAME + " (" +
                    userContract.userEntry._ID + " INTEGER PRIMARY KEY," +
                    userContract.userEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    userContract.userEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    userContract.userEntry.COLUMN_NAME_AGE + TEXT_TYPE + COMMA_SEP +
                    userContract.userEntry.COLUMN_NAME_USERNAME + TEXT_TYPE + COMMA_SEP +
                    userContract.userEntry.COLUMN_NAME_PASSWORD + TEXT_TYPE +
            " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + userContract.userEntry.TABLE_NAME;


    public userDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
