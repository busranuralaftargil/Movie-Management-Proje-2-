package com.sau.mm.service;

import com.sau.mm.dto.MovieDTO;
import com.sau.mm.model.Movie;

import java.util.List;

public interface MovieService {
    public List<MovieDTO> getAllMovies();
    public MovieDTO getMovieById(Long id);
    public MovieDTO createMovie(Movie movie);
    public MovieDTO updateMovie(Long id, Movie movie);
    public void deleteMovie(Long id);
}