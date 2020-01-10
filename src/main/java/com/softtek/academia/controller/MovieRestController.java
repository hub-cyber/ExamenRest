package com.softtek.academia.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.academia.entity.Movie;
import com.softtek.academia.service.MovieService;



@RestController
@RequestMapping("/Movies")
public class MovieRestController {
	@Autowired
	MovieService movieService;
	
	@GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<Movie> getListMovie(){
		return movieService.getAllMovies();
	}
	
	@GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Movie getMovieById(@PathVariable("id") Integer id) {
		return movieService.getMovieById(id);
	}
	
	@PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public boolean addMovie(@RequestBody Movie reqBodyMovie) {
		return movieService.saveMovie(reqBodyMovie);
	}
	
	@PutMapping(value=("/{id}"),consumes =  MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Movie updateMovie(@PathVariable("id")Integer id,@RequestBody Movie reqBodyMovie ) {
		return movieService.updateMovie(reqBodyMovie);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteMovie(@PathVariable ("id") Integer movie) {
		movieService.deleteMovierById(movie);
	}
	
	//extras 
	@GetMapping(value="/Title/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<Movie> findByName(@PathVariable ("name") String name){
		return movieService.getMovieByName(name);
	}
}
