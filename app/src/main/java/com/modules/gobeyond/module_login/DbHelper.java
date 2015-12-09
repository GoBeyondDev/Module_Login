package com.modules.gobeyond.module_login;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by rramirez on 12/2/15.
 */
public class DbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = Integer.parseInt(Global.getContext().getString(R.string.db_version));
    public static final String DATABASE_NAME =  Global.getContext().getString(R.string.db_name);

    public static String SQL_CREATE_TABLES = "";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Global.getContext().getString(R.string.tb_users);


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLES);
        Log.d(Global.APP_NAME, "Database \"" + DATABASE_NAME + "\" was just created.");
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
