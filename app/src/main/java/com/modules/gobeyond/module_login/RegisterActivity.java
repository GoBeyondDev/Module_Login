package com.modules.gobeyond.module_login;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button btRegister;
    EditText etName, etAge, etUsername, etPassword, etRepeatPassword;

    //Creates an instance of the DBHelper to be used to insert the data.
    public DbHelper mDbHelper = new DbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etRepeatPassword = (EditText) findViewById(R.id.etRepeatPassword);
        btRegister = (Button) findViewById(R.id.btRegister);

        btRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String tempPass = etPassword.getText().toString();
        String tempRepeatPass = etRepeatPassword.getText().toString();
        String tempName = etName.getText().toString();
        String tempAge = etAge.getText().toString();
        String tempUser = etUsername.getText().toString();

        switch (v.getId()) {
            case R.id.btRegister:
                //If password Matches AND all fields are filled
                if(tempPass.equals(tempRepeatPass) &&
                    !tempName.equals("") &&
                    !tempAge.equals("") &&
                    !tempUser.equals(""))
                {
                    insertData();
                    makeToasts("Your data has been inserted correctly");
                    //TODO launch the main menu?
                } else if (!tempPass.equals(tempRepeatPass))
                //If password doesn't match
                {
                    makeToasts("Your password doesn't match.");
                } else {
                    //One ore more Textfields are empty
                    makeToasts("Please make sure all the fields are properly filled.");
                }
                break;
        }
    }


    public void insertData() {
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        //Create temporal variables to retrieve UI elements values
        String tempName = etName.getText().toString();
        String tempAge = etAge.getText().toString();
        String tempUser = etUsername.getText().toString();
        String tempPass = etPassword.getText().toString();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Global.getContext().getString(R.string.col_users_fullname), tempName);
        values.put(Global.getContext().getString(R.string.col_users_age), tempAge);
        values.put(Global.getContext().getString(R.string.col_users_username), tempUser);
        values.put(Global.getContext().getString(R.string.col_users_password), tempPass);

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(Global.getContext().getString(R.string.tb_users), null, values);

        //Use for debugging purposes
        Log.d(Global.APP_NAME, "DATA HAS BEEN INSERTED - newRowId: " + newRowId);
    }

    //Helper function to create toasts on the fly
    public void makeToasts(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
