package com.softtek.academia.service;

import java.util.List;


import com.softtek.academia.entity.Movie;

public interface MovieService {
	
	public List<Movie> getAllMovies();
	public Movie getMovieById(Integer id);
	public boolean saveMovie(Movie Movie);
	public void deleteMovierById(Integer id);
	public Movie updateMovie(Movie movie);
	public List<Movie> getMovieByName(String Title);
	
	
}
