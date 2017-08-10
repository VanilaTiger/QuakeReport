package com.example.android.quakereport;

/**
 * Created by adama on 04.08.2017.
 */

public class EarthquakeItem {
    Double magnitude;
    String city;
    long date;
    String webAdress;


    public EarthquakeItem() {
    }

    public EarthquakeItem(Double magnitude, String city, long date, String webAdress){
        this.magnitude=magnitude;
        this.city=city;
        this.date=date;
        this.webAdress=webAdress;
    }

    public Double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Double magnitude) {
        this.magnitude = magnitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getWebAdress() { return webAdress; }

    public void setWebAdress(String webAdress) { this.webAdress = webAdress; }

}
