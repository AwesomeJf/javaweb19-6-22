package com.wzu.qunawan.pojo;

import java.util.ArrayList;
import java.util.Date;

public class Tripshow {
    private Integer id;
    private String title;
    private String sTitle;
    private Float goodRate;
    private Float price;
    private String data;
    private String startPlace;
    private String traffic;
    private String hotel;
    private Integer time;
    private ArrayList<String> place;
    private ArrayList<String> theme;
    private ArrayList<Date> date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getsTitle() {
        return sTitle;
    }

    public void setsTitle(String sTitle) {
        this.sTitle = sTitle;
    }

    public Float getGoodRate() {
        return goodRate;
    }

    public void setGoodRate(Float goodRate) {
        this.goodRate = goodRate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public ArrayList<String> getPlace() {
        return place;
    }

    public void setPlace(ArrayList<String> place) {
        this.place = place;
    }

    public ArrayList<String> getTheme() {
        return theme;
    }

    public void setTheme(ArrayList<String> theme) {
        this.theme = theme;
    }

    public ArrayList<Date> getDate() {
        return date;
    }

    public void setDate(ArrayList<Date> date) {
        this.date = date;
    }



    public Tripshow(Integer id, String title, String sTitle, Float goodRate, Float price, String data) {
        this.id = id;
        this.title = title;
        this.sTitle = sTitle;
        this.goodRate = goodRate;
        this.price = price;
        this.data = data;
    }

    public Tripshow(Integer id, String title, String sTitle, Float goodRate, Float price, String data, String startPlace, String traffic, String hotel, Integer time, ArrayList<String> place, ArrayList<String> theme, ArrayList<Date> date) {
        this.id = id;
        this.title = title;
        this.sTitle = sTitle;
        this.goodRate = goodRate;
        this.price = price;
        this.data = data;
        this.startPlace = startPlace;
        this.traffic = traffic;
        this.hotel = hotel;
        this.time = time;
        this.place = place;
        this.theme = theme;
        this.date = date;
    }

    public Tripshow(Integer id, String title, String sTitle, Float goodRate, String traffic, String hotel, Integer time) {
        this.id = id;
        this.title = title;
        this.sTitle = sTitle;
        this.goodRate = goodRate;
        this.traffic = traffic;
        this.hotel = hotel;
        this.time = time;
    }

    public Tripshow(Integer id, String title, String sTitle, Float goodRate, String traffic, String hotel, Integer time, ArrayList<String> place) {
        this.id = id;
        this.title = title;
        this.sTitle = sTitle;
        this.goodRate = goodRate;
        this.traffic = traffic;
        this.hotel = hotel;
        this.time = time;
        this.place = place;
    }

    @Override
    public String toString() {
        return "Tripshow{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sTitle='" + sTitle + '\'' +
                ", goodRate=" + goodRate +
                ", price=" + price +
                ", data='" + data + '\'' +
                ", startPlace='" + startPlace + '\'' +
                ", traffic='" + traffic + '\'' +
                ", hotel='" + hotel + '\'' +
                ", time=" + time +
                ", place=" + place +
                ", theme=" + theme +
                ", date=" + date +
                '}';
    }
}
