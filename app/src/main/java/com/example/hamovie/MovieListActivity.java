package com.example.hamovie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity {
    private MovieListAdapter adapter;
    private RecyclerView recyclerView;

    private ArrayList<MovieEntry> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        recyclerView = findViewById(R.id.recyclerView_movieList);
        getMovieList();
        setActionBarTitle();
        prepareRecyclerView();
    }



    private void setActionBarTitle() {
        String title = getIntent().getStringExtra("EXTRA2");
        getSupportActionBar().setTitle(title);
    }


    private void prepareRecyclerView() {
        adapter = new MovieListAdapter(movieList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }

    private void getMovieList() {
        movieList =  (ArrayList<MovieEntry>)getIntent().getSerializableExtra("EXTRA");
    }

}