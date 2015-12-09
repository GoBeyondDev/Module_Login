package com.modules.gobeyond.module_login;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btLogout;
    EditText etName;
    EditText etAge;
    EditText etUsername;

    public DbHelper mDbHelper = new DbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etUsername = (EditText) findViewById(R.id.etUsername);

        btLogout = (Button) findViewById(R.id.btLogout);

        btLogout.setOnClickListener(this);

        try {
            //Read the commands to create the database from the SQL file
            DbHelper.SQL_CREATE_TABLES = getStringFromFile(R.raw.mb_app_dbstructure);
            Log.d(Global.APP_NAME, "SQL file to create the DB \""
                    + DbHelper.DATABASE_NAME + "\" tables was just fetched.");
        }
        catch (Exception e) {
            Log.e(Global.APP_NAME,
                "getStringFromFile(R.raw.mb_app_dbstructure) - Error: " + e.getMessage());
        }

    }

    public Cursor readData() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                Global.getContext().getString(R.string.col_users_username),
                Global.getContext().getString(R.string.col_users_fullname),
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder = Global.getContext().getString(R.string.col_users_fullname) + " DESC";

        Cursor c = db.query(
                Global.getContext().getString(R.string.tb_users),        // The table to query
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

    public String convertStreamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }

    public String getStringFromFile (int fileId) throws Exception {

        InputStream fileInputStream = getResources().openRawResource(fileId);
        Log.d("APP_LOG", "fileInputStream : " + fileInputStream.available());
        String ret = convertStreamToString(fileInputStream);
        //Make sure you close all streams.
        fileInputStream.close();
        return ret;
    }
}
