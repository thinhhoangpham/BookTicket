package com.example.bookticket.models;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@ParseClassName("Movie")
public class Movie extends ParseObject {
    public static final String KEY_ID = "movieId";
    public static final String KEY_TITLE = "title";
    public static final String KEY_OVERVIEW = "overview";
    public static final String KEY_RATING = "rating";
    public static final String KEY_POSTERPATH = "posterPath";
    public static final String KEY_SHOW = "Show";
    public static final String KEY_PRICE = "Price";


    public String getPosterPath() {
        String posterPath = getString(KEY_POSTERPATH);
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getTitle() {
        return getString(KEY_TITLE);
    }

    public String getOverview() {
        return getString(KEY_OVERVIEW);
    }

    public double getRating() {return  getDouble(KEY_RATING);}

    public int getMovieId() {return getInt(KEY_ID);}

    public void setPrice(double price) {put(KEY_PRICE, price);}
    public double getPrice() {return getDouble(KEY_PRICE);}

    public void setShow(boolean show) {put(KEY_SHOW, show);}
    public boolean getShow() {return getBoolean(KEY_SHOW);}
}
