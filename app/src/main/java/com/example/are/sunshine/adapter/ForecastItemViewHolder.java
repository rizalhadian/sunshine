package com.example.are.sunshine.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.are.sunshine.R;
import com.example.are.sunshine.model.DummyForecast;
import com.example.are.sunshine.model.ListForecast;
import com.example.are.sunshine.model.WeatherItem;


import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by are on 5/7/2017.
 */

public class ForecastItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_weather) ImageView ivWeather;
    @BindView(R.id.tv_day) TextView tvDay;
    @BindView(R.id.tv_forecast) TextView tvForecast;
    @BindView(R.id.tv_min_temp) TextView tvMinTemp;
    @BindView(R.id.tv_max_temp) TextView tvMaxTemp;

    public ForecastItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(final DummyForecast data){
        tvDay.setText(data.getDay());
        tvForecast.setText(data.getForecast());
        tvMinTemp.setText(String.valueOf(data.getMinTemp())+"\u00b0");
        tvMaxTemp.setText(String.valueOf(data.getMaxTemp())+"\u00b0");
    }

    public void bind(final ListForecast data, int position){
        WeatherItem weatherItem = data.getWeather().get(0);

        if(position == 0){
            tvDay.setText(data.getTodayReadableTime());
        }else {
            tvDay.setText(String.valueOf(data.getReadableTime(position)));

        }
        tvForecast.setText(weatherItem.getDescription());
        tvMinTemp.setText(data.getTemp().getDerajatMinTemp());
        tvMaxTemp.setText(data.getTemp().getDerajatMaxTemp());

    }
}
