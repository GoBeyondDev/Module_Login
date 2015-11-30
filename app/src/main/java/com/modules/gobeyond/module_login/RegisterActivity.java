package com.modules.gobeyond.module_login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button btRegister;
    EditText etName;
    EditText etAge;
    EditText etUsername;
    EditText etPassword;
    EditText etRepeatPassword;

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
        switch (v.getId()) {
            case R.id.btRegister:

                break;
        }
    }
}
