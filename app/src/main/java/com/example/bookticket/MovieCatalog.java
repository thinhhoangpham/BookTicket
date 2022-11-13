package com.example.bookticket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieCatalog extends AppCompatActivity {
    private RecyclerView recViewMovieCatalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_catalog);

        recViewMovieCatalog = findViewById(R.id.recViewMovieCatalog);
    }
}

//Based on code from the YouTube channel freeCodeCamp.org
class RecViewMovieCatalogAdapter extends RecyclerView.Adapter<RecViewMovieCatalogAdapter.ViewHolder> {
    private ArrayList<String> film_names = new ArrayList<String>();

    public RecViewMovieCatalogAdapter() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return film_names.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtViewNameOfFilm;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtViewNameOfFilm = itemView.findViewById(R.id.txtViewNameOfFilm);
        }
    }
}