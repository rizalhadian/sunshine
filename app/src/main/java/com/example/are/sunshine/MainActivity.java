package com.example.are.sunshine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.are.sunshine.adapter.ListForecastAdapter;
import com.example.are.sunshine.model.ApiResponse;
import com.example.are.sunshine.model.DummyForecast;
import com.example.are.sunshine.model.ListForecast;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    private static  final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.recyclerview) RecyclerView recyclerView;
    ListForecastAdapter adapter;
    private List<DummyForecast> listData = new ArrayList<>();
    private List<ListForecast> listWeather = new ArrayList<>();
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setupRecyclerView();

    }

    private void setDummyData(){
        for(int i = 0; i < 25; i++){
            DummyForecast dummyForecast = new DummyForecast("Sunday", "Rain", 19, 23);
            listData.add(dummyForecast);
        }

        adapter.notifyDataSetChanged();
    }

    private void setupRecyclerView(){
        adapter = new ListForecastAdapter(listWeather);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
//        setDummyData();
        getDataForecastDailyDenpasar();
    }



    Response.Listener<String> resListener = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Log.d(TAG, "onResponse: "+response);

            ApiResponse apiResponse = gson.fromJson(response, ApiResponse.class);

            for(ListForecast listItem : apiResponse.getList()){
                listWeather.add(listItem);
            }

            adapter.notifyDataSetChanged();
        }
    };

    Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.d(TAG, "onErrorResponse: "+error.getMessage());
        }
    };

    public void getDataForecastDailyDenpasar(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final String url = "http://api.openweathermap.org/data/2.5/forecast/daily?lat=-8.650000&lon=115.216667&cnt=16&appid=de5b16bdefde95b11c1dfad9f24f7414&units=metric";
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                resListener,
                errorListener
        );

        requestQueue.add(request);
    }
}
