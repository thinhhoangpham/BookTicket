package com.example.bookticket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.bookticket.adapters.MovieAdapter;
import com.example.bookticket.models.Movie;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class MovieCatalog extends AppCompatActivity {
    public static final String NOW_PLAYING_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
    public static final String TAG = "MovieCatalog";

    List<Movie> movieList;
    MovieAdapter movieAdapter;
    //private RecyclerView recViewMovieCatalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_catalog);
        RecyclerView recViewMovieCatalog = findViewById(R.id.recViewMovieCatalog);
        movieList = new ArrayList<>();

        // Create adapter
        movieAdapter = new MovieAdapter(this, movieList);
        // set adapter on RV
        recViewMovieCatalog.setAdapter(movieAdapter);
        // set layout manager on RV
        recViewMovieCatalog.setLayoutManager(new LinearLayoutManager(this));

//        AsyncHttpClient client = new AsyncHttpClient();
//        client.get(NOW_PLAYING_URL, new JsonHttpResponseHandler() {
//            @Override
//            public void onSuccess(int statusCode, Headers headers, JSON json) {
//                Log.d(TAG, "onSuccess");
//                JSONObject jsonObject = json.jsonObject;
//                try {
//                    JSONArray results = jsonObject.getJSONArray("results");
//                    Log.i(TAG, "Result: " + results.toString());
//                    movies.addAll(Movie.fromJSONArray(results));
//                    movieAdapter.notifyDataSetChanged();
//                    Log.i(TAG, "Movies: " + movies.size());
//                } catch (JSONException e) {
//                    Log.e(TAG, "Hit json exception", e);
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
//                Log.d(TAG, "onFailure");
//            }
//        });

        queryMovies();
    }

    private void queryMovies() {
        ParseQuery<Movie> query = ParseQuery.getQuery(Movie.class);
        query.findInBackground(new FindCallback<Movie>() {
            @Override
            public void done(List<Movie> movies, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Query problem ", e);
                }
                for (Movie movie : movies) {
                    if (movie.getShow() == true) {
                        movieList.add(movie);
                    }
                }
                movieAdapter.notifyDataSetChanged();

            }
        });
    }
}

