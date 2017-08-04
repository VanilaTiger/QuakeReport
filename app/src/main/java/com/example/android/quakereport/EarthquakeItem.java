package com.example.android.quakereport;

/**
 * Created by adama on 04.08.2017.
 */

public class EarthquakeItem {
    String magnitude;
    String city;
    String date;


    public EarthquakeItem() {
    }

    public EarthquakeItem(String magnitude, String city, String date){
        this.magnitude=magnitude;
        this.city=city;
        this.date=date;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
