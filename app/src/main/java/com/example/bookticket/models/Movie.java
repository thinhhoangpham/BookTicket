package com.example.bookticket.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel

public class Movie {
    String posterPath;
    String title;
    String overview;
    float rating;
    int movieId;
    double price;

    public Movie(JSONObject jsonobject) throws JSONException {
        posterPath = jsonobject.getString("poster_path");
        title = jsonobject.getString("title");
        overview = jsonobject.getString("overview");
        rating = (float) jsonobject.getDouble("vote_average");
        movieId = jsonobject.getInt("id");
    }

    //Empty constructor needed by parcel
    public Movie() {

    }

    public static List<Movie> fromJSONArray(JSONArray movieJSONArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieJSONArray.length(); i++) {
            movies.add(new Movie(movieJSONArray.getJSONObject(i)));
        }
        return movies;
    }

    public static void setPosterPath() {
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public float getRating() {return  rating;}

    public int getMovieId() {return movieId;}

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }
}
