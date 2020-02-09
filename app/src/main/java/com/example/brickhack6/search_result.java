package com.example.brickhack6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;


import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class search_result extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    String search_val;
    TextView res;
    String data;
    String line = "";

    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        //call_Api();
    }
    private void call_Api() throws IOException {
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "https://api.wegmans.io/products/search?query={corona}&api-version=2018-10-18&subscription-key=c7b17e30cb674473bbc15e5c0b3ec5dd";

        OkHttpClient client = new OkHttpClient();



    }

    private void initImageBitmaps(){
        Log.d(TAG, "Preparing Bitmaps");
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
