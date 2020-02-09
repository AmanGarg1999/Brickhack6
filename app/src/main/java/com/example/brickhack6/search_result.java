package com.example.brickhack6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class search_result extends AppCompatActivity {
    private static final String TAG = "MainActivity";


    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
    }
    private void initImageBitmaps(){
        Log.d(TAG, "Preparing Bitmaps");

        mImageUrls.add("");
        mName.add("");

    }

    private void initRecyclerView(){
        Log.d(TAG, "Recycler View");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = findViewById(R.id.recycleViewforSearch);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,mName,mImageUrls);
        recyclerView.setAdapter(adapter);
    }
}
