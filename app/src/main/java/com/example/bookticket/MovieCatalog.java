package com.example.bookticket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
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

        ArrayList<String> film_names = new ArrayList<String>();

        //TODO: Fetch names of currently showing films from the database and add to film_names
        //These names are just examples
        film_names.add("Movie1");
        film_names.add("Movie2");
        film_names.add("Movie3");

        RecViewMovieCatalogAdapter catalog_adapter = new RecViewMovieCatalogAdapter();
        catalog_adapter.set_film_names(film_names);

        recViewMovieCatalog.setAdapter(catalog_adapter);
        recViewMovieCatalog.setLayoutManager(new LinearLayoutManager(this));
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_catalog_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtViewNameOfFilm.setText(film_names.get(position));
    }

    @Override
    public int getItemCount() {
        return film_names.size();
    }

    public void set_film_names(ArrayList<String> film_names) {
        this.film_names = film_names;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtViewNameOfFilm;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtViewNameOfFilm = itemView.findViewById(R.id.txtViewNameOfFilm);
        }
    }
}