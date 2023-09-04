/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.movie.controller;

import java.util.ArrayList;

import com.example.movie.model.Movie;
import com.example.movie.service.MovieJpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController{

    @Autowired
    private MovieJpaService movieJpaService;

    @GetMapping("/movies")
    public ArrayList<Movie> getAllMovies(){
        return movieJpaService.getAllMovies();
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie){
        return movieJpaService.addMovie(movie);
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable("movieId") int movieId){
        return movieJpaService.getMovieById(movieId);
    }

    @PutMapping("/movies/{movieId}")
    public Movie updateMovie(@RequestBody Movie movie, @PathVariable("movieId") int movieId){
        return movieJpaService.updateMovie(movie, movieId);
    }

    @DeleteMapping("/movies/{movieId}")
    public ArrayList<Movie> deleteMovie(@PathVariable("movieId") int movieId){
        return movieJpaService.deleteMovie(movieId);

    }

}