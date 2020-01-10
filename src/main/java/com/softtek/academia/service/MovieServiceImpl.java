package com.softtek.academia.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academia.entity.Movie;
import com.softtek.academia.repository.MovieRespository;
@Service
@Transactional
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieRespository movieRepository;
	
	
	@Override
	public List<Movie> getAllMovies() {
		return (List<Movie>) movieRepository.findAll();
	}

	@Override
	public Movie getMovieById(Integer id) {
			Movie Movie = movieRepository.findById(id).get();
		return Movie;
	}

	@Override
	public boolean saveMovie(Movie Movie) {
		try {
			movieRepository.save(Movie);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public void deleteMovierById(Integer id) {
		movieRepository.deleteById(id);
	}

	@Override
	public Movie updateMovie(Movie movie) {
		
		return movieRepository.save(movie);
	}

	@Override
	public List<Movie> getMovieByName(String Title) {
		List<Movie> pelicula =movieRepository.findByTitle(Title);
		return pelicula;
	}

}
