package com.example.are.sunshine.model;

/**
 * Created by are on 5/7/2017.
 */

public class DummyForecast {

//    private int weatherId;
    private String day;
    private String forecast;
    private int minTemp;
    private int maxTemp;

    public DummyForecast(String day, String forecast, int minTemp, int maxTemp) {
        this.day = day;
        this.forecast = forecast;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }
}
