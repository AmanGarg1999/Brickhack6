package com.example.brickhack6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class home extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    Button btn;

    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn = findViewById(R.id.addToList);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(home.this, getInfo.class);
                startActivity(intent);
            }
        });
    }

    private void initImageBitmaps(){
        Log.d(TAG, "Preparing Bitmaps");

        mImageUrls.add("");
        mName.add("");

    }

    private void initRecyclerView(){
        Log.d(TAG, "Recycler View");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,mName,mImageUrls);
        recyclerView.setAdapter(adapter);
    }
}
