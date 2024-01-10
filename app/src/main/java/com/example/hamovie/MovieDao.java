package com.example.hamovie;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface MovieDao {

    @Query("SELECT * FROM movie")
    List<MovieEntry> getAllMovies();

    @Insert
    void insertAllMovies(List<MovieEntry> movieList);

    @Query("SELECT * FROM movie WHERE genre != 'serial' and genre != 'animation'")
    List<MovieEntry> getFilms();

    @Query("SELECT * FROM movie WHERE genre = 'serial'")
    List<MovieEntry> getSerials();

    @Query("SELECT * FROM movie WHERE genre = 'animation'")
    List<MovieEntry> getAnimations();
}
