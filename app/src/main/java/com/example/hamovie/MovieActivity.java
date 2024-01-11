package com.example.hamovie;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        MovieEntry movie = getIntent().getParcelableExtra("EXTRA");
        getSupportActionBar().setTitle("مشخصات");

        ImageView poster = findViewById(R.id.imageView_movie_poster);
        TextView name = findViewById(R.id.textView_movie_name);
        TextView genre = findViewById(R.id.textView_movie_genre);
        TextView year = findViewById(R.id.textView_movie_year);
        TextView explain = findViewById(R.id.textView_movie_explain);

        Picasso.get().load(movie.getPoster()).into(poster);
        name.setText(movie.getName());
        genre.setText(movie.getGenre());
        year.setText(String.valueOf(movie.getYear()));
        explain.setText(movie.getExplain());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.back_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item_back)
            finish();
        return super.onOptionsItemSelected(item);
    }
}