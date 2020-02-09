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
    Button view_hist;
    Button view_est;

    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initImageBitmaps();
        initRecyclerView();
        btn = findViewById(R.id.addToList);
        view_est = findViewById(R.id.exp_btn);
        view_hist = findViewById(R.id.hist_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(home.this, search_result.class);
                startActivity(intent);
            }
        });

        view_est.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(home.this, expense.class);
                startActivity(intent);
            }
        });

        view_hist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(home.this, View_history.class);
                startActivity(intent);
            }
        });
    }

    private void initImageBitmaps(){
        Log.d(TAG, "Preparing Bitmaps");

        mName.add("Rolling Rock 6p/12z btls");
        mImageUrls.add("https://dpsassetsstorageprod.blob.core.windows.net/images-500/00071439348063.jpg?sv=2018-03-28&si=images-500-AssetSubcriber&sr=c&sig=zv%2BjKOyBk2%2Blc%2BpOhEUoGN5N12le72HSPRxbMsISrcs%3D");

        mName.add("Busch");
        mImageUrls.add("https://dpsassetsstorageprod.blob.core.windows.net/images-500/018200610479.jpg?sv=2018-03-28&si=images-500-AssetSubcriber&sr=c&sig=zv%2BjKOyBk2%2Blc%2BpOhEUoGN5N12le72HSPRxbMsISrcs%3D");

        mName.add("Corona Light 12pk cans");
        mImageUrls.add("https://dpsassetsstorageprod.blob.core.windows.net/images-500/080660956213.jpg?sv=2018-03-28&si=images-500-AssetSubcriber&sr=c&sig=zv%2BjKOyBk2%2Blc%2BpOhEUoGN5N12le72HSPRxbMsISrcs%3D");

        mName.add("Premium Vodka");
        mImageUrls.add("https://dpsassetsstorageprod.blob.core.windows.net/images-500/077890292563.jpg?sv=2018-03-28&si=images-500-AssetSubcriber&sr=c&sig=zv%2BjKOyBk2%2Blc%2BpOhEUoGN5N12le72HSPRxbMsISrcs%3D");

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
