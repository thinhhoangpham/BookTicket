package com.example.bookticket;

import android.content.Context;
import android.util.Log;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.Amplify;

public class Backend {
    private String tag = "Backend";

    Backend(Context applicationContext) {
        try {
            Amplify.configure(applicationContext);
            Log.i(tag, "Initialized Amplify through Backend object");
        } catch (AmplifyException e) {
            Log.e(tag, "Could not initialize Amplify", e);
        }
    }
}