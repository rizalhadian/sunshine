package com.example.are.sunshine.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.are.sunshine.R;
import com.example.are.sunshine.model.DummyForecast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by are on 5/7/2017.
 */

public class ListForecastAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<DummyForecast> listData = new ArrayList<>();

    public ListForecastAdapter(List<DummyForecast> listData) {
        this.listData = listData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_forecast_item, parent, false);
        return new ForecastItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ForecastItemViewHolder forecastItemViewHolder = (ForecastItemViewHolder) holder;
        DummyForecast data = listData.get(position);
        forecastItemViewHolder.bind(data);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}
