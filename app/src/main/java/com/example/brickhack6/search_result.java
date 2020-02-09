package com.example.brickhack6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;


public class search_result extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    String search_val;
    TextView res;
    String data;
    String line = "";
    Button add_to_cart;

    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        add_to_cart = (Button)findViewById(R.id.ViewCart);

        initImageBitmaps();
        initRecyclerView();

        add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(search_result.this, Cart.class);
                startActivity(intent);
            }
        });
        //call_Api();
    }
    private void call_Api() throws IOException {
        RequestQueue queue = Volley.newRequestQueue(this);

        //String url = "https://api.wegmans.io/products/search?query={corona}&api-version=2018-10-18&subscription-key=c7b17e30cb674473bbc15e5c0b3ec5dd";

        OkHttpClient client = new OkHttpClient();



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
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = findViewById(R.id.recycleViewSearch);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,mName,mImageUrls);
        recyclerView.setAdapter(adapter);
    }

    public void setSearch(String search){
        search_val = search;
    }
}
