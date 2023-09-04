// Write your code here
package com.example.movie.repository;

import java.util.ArrayList;

import com.example.movie.model.Movie;

public interface MovieRepository{
    ArrayList<Movie> getAllMovies();
    Movie addMovie(Movie movie);
    Movie getMovieById(int movieId);
    Movie updateMovie(Movie movie, int movieId);
    ArrayList<Movie> deleteMovie(int movieId);
}