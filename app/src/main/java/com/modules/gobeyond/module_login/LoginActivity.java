package com.modules.gobeyond.module_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button btLogin;
    EditText etUsername, etPassword;
    TextView tvRegisterHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvRegisterHere = (TextView) findViewById(R.id.tvRegisterHere);
        btLogin = (Button) findViewById(R.id.btLogin);

        btLogin.setOnClickListener(this);
        tvRegisterHere.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btLogin:
                startActivity(new Intent(this, home_activity.class));
                break;
            case R.id.tvRegisterHere:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }
    }
}
