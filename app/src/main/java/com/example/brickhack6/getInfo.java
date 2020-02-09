package com.example.brickhack6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class getInfo extends AppCompatActivity {

    public String search_res;
    EditText search;
    Button search_bttn;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_info);

        search = (EditText)findViewById(R.id.search_edit);
        search_bttn = (Button) findViewById(R.id.search);
        back = (Button) findViewById(R.id.back_btn);

        search_bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_res = search.getText().toString();

                search_result res = new search_result();
                res.setSearch(search_res);
                Intent intent = new Intent(getInfo.this, search_result.class);
                startActivity(intent);
                //setContentView(R.layout.activity_search_result);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getInfo.this, home.class);
                startActivity(intent);
            }
        });
    }


}
