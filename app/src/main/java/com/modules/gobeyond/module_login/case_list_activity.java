package com.modules.gobeyond.module_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class case_list_activity extends AppCompatActivity {

    ListView caseDetails_lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_list_activity);

        caseDetails_lv = (ListView)findViewById(R.id.caseDetails_lv);

        String[] cases = new String[] { "Case 1", "Case 2", "Case 3", "Case 4", "Case 5", "Case 6", "Case 7" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, cases);

        caseDetails_lv.setAdapter(adapter);

        // ListView Item Click Listener
        caseDetails_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ListView Clicked item index
                int itemPosition = position;
                // ListView Clicked item value
                String itemValue = (String) caseDetails_lv.getItemAtPosition(position);
                // Show Alert
                Toast.makeText(getApplicationContext(), "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), case_detail_activity.class));
            }
        });
    }

}
