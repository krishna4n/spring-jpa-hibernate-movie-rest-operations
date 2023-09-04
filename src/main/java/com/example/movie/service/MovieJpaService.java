/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.movie.service;

import java.util.ArrayList;
import java.util.List;

import com.example.movie.model.Movie;
import com.example.movie.repository.MovieJpaRepository;
import com.example.movie.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MovieJpaService implements MovieRepository{

    @Autowired
    private MovieJpaRepository movieJpaRepository;

	@Override
	public ArrayList<Movie> getAllMovies() {
		List<Movie>  movieList = movieJpaRepository.findAll();
		ArrayList<Movie> movies = new ArrayList<>(movieList);
		return movies;
	}

	@Override
	public Movie addMovie(Movie movie) {
		movieJpaRepository.save(movie);
		return movie;
	}

	@Override
	public Movie getMovieById(int movieId) {
		try{
			Movie movie = movieJpaRepository.findById(movieId).get();
			return movie;
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Movie updateMovie(Movie movie, int movieId) {
		try{
			Movie updatedMovie = movieJpaRepository.findById(movieId).get();
			if(movie.getMovieName() != null){
				updatedMovie.setMovieName(movie.getMovieName());
			}
			if(movie.getLeadActor() != null){
				updatedMovie.setLeadActor(movie.getLeadActor());
			}
			movieJpaRepository.save(updatedMovie);
			return updatedMovie;
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ArrayList<Movie> deleteMovie(int movieId) {
		
		try{
			movieJpaRepository.deleteById(movieId);
			return getAllMovies();
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

}
