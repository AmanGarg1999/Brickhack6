package com.example.brickhack6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class getInfo extends AppCompatActivity {

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
    }

}
