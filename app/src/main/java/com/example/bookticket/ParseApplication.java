package com.example.bookticket;

import android.app.Application;

import com.example.bookticket.models.Movie;
import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Movie.class);

        // set applicationId, and server server based on the values in the back4app settings.
        // any network interceptors must be added with the Configuration Builder given this syntax
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("y97Y6tESdh6S8HPh7sH2xhhSbRs9OHMiY6E0bIlV")
                .clientKey("JahNuZQ7hY2RmBHghO6ZilGnrlSSr0sF096P0lhE")
                .server("https://parseapi.back4app.com")
                .build());
    }

}
