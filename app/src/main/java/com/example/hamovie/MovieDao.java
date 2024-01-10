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

    @Query("SELECT * FROM movie ORDER BY year DESC")
    List<MovieEntry> getAllMoviesOrderByYear();

    @Query("SELECT * FROM movie WHERE genre = 'action'")
    List<MovieEntry> getActions();

    @Query("SELECT * FROM movie WHERE genre = 'comedy'")
    List<MovieEntry> getComedies();

    @Query("SELECT * FROM movie WHERE genre = 'crime'")
    List<MovieEntry> getCrimes();

    @Query("SELECT * FROM movie WHERE genre = 'horror'")
    List<MovieEntry> getHorrors();

    @Query("SELECT * FROM movie WHERE genre = 'romance'")
    List<MovieEntry> getRomances();

    @Query("SELECT * FROM movie WHERE genre = 'sci-fi'")
    List<MovieEntry> getSciFis();

    @Query("SELECT * FROM movie WHERE genre = 'war'")
    List<MovieEntry> getWars();
}
