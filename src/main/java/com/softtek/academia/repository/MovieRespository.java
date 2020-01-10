package com.softtek.academia.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softtek.academia.entity.Movie;
@Repository
public interface MovieRespository extends CrudRepository<Movie, Integer>{
 List<Movie> findByTitle(String Title);
}
