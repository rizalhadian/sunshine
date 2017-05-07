package com.example.are.sunshine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.are.sunshine.adapter.ListForecastAdapter;
import com.example.are.sunshine.model.DummyForecast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclerview) RecyclerView recyclerView;
    ListForecastAdapter adapter;
    List<DummyForecast> listData = new ArrayList<>();

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
        adapter = new ListForecastAdapter(listData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        setDummyData();
    }
}
