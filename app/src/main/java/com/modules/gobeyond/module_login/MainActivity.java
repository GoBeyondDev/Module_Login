package com.modules.gobeyond.module_login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btLogout;
    EditText etName;
    EditText etAge;
    EditText etUsername;

    public userDbHelper mDbHelper = new userDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etUsername = (EditText) findViewById(R.id.etUsername);

        btLogout = (Button) findViewById(R.id.btLogout);

        btLogout.setOnClickListener(this);

        //insertData();

        Cursor c = readData();
        c.moveToFirst();
        do{
            Log.v("APPLOG" , c.getString(1));
        }
        while(c.moveToNext());

    }

    public void insertData(){
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(userContract.userEntry.COLUMN_NAME_ENTRY_ID, "11111");
        values.put(userContract.userEntry.COLUMN_NAME_NAME, "gerardo");

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                userContract.userEntry.TABLE_NAME,
                null,
                values);
        Log.v("APPLOG", "DATA HAS BEEN INSERTED");
    }

    public Cursor readData() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                userContract.userEntry._ID,
                userContract.userEntry.COLUMN_NAME_NAME,
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder = userContract.userEntry.COLUMN_NAME_NAME + " DESC";

        Cursor c = db.query(
                userContract.userEntry.TABLE_NAME,        // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                                    // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return c;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btLogout:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}
