package com.edstud.eddie.weatherapp.Common;

import android.media.Image;
import android.support.annotation.NonNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
    public static String API_KEY = "3533eaf3bcf6b6ac0870d33eb7c1addd";                                                      //get API key from OpenWeatherAPI
    public static String API_LINK = "http://api.openweathermap.org/data/2.5/weather";       //API link of OpenWeathermap

    @NonNull
    public static String apiRequest(String lat, String lng){
        StringBuilder stringBuilder = new StringBuilder(API_LINK);
        //create a functional link to the API path
        stringBuilder.append(String.format("?lat=%s&lon=%s&APPID=%s&units=metric", lat, lng, API_KEY));
        return stringBuilder.toString();
    }

    public static String unixTimeStampToDateTime(double unixTimeStamp){
        //convert unix time stamp to date type with format(HH:mm)
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        date.setTime((long) unixTimeStamp);
        return dateFormat.format(date);
    }

    public static String getImage(String icon){
        //get a link image from OpenWeathermap
        return String.format("http://openweathermap.org/img/w/%s.png", icon);
    }

    public static String getDateNow(){
        //get date with format(dd MMMM yyyy HH:mm)
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
