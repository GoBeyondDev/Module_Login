package com.modules.gobeyond.module_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home_activity extends AppCompatActivity implements View.OnClickListener {

    Button newCase_btn, selectCase_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);

        newCase_btn = (Button) findViewById(R.id.new_case_btn);
        selectCase_btn = (Button) findViewById(R.id.select_case_btn);

        newCase_btn.setOnClickListener(this);
        selectCase_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.new_case_btn:
                startActivity(new Intent(this, new_case_activity.class));
                break;
            case R.id.select_case_btn:
                startActivity(new Intent(this, case_list_activity.class));
                break;
        }
    }

}
