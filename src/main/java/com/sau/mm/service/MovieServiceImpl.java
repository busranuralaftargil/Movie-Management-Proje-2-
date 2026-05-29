package com.sau.mm.service;

import com.sau.mm.dto.MovieDTO;
import com.sau.mm.exception.ErrorMessages;
import com.sau.mm.exception.ResourceAlreadyExistsException;
import com.sau.mm.exception.ResourceNotFoundException;
import com.sau.mm.model.Movie;
import com.sau.mm.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MovieDTO getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.ERROR_MOVIE_NOT_FOUND + ": " + id)).viewAsMovieDTO();
    }

    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll().stream().map(Movie::viewAsMovieDTO).toList();
    }

    public MovieDTO createMovie(Movie movie) {
        if (movieRepository.findById(movie.getId()).isPresent()) {
            throw new ResourceAlreadyExistsException(ErrorMessages.ERROR_MOVIE_ALREADY_EXIST + ": " + movie.getId());
        }
        return movieRepository.save(movie).viewAsMovieDTO();
    }

    public MovieDTO updateMovie(Long id, Movie movie) {
        movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.ERROR_MOVIE_NOT_FOUND + ": " + id));
        movie.setId(id);
        return movieRepository.save(movie).viewAsMovieDTO();
    }

    public void deleteMovie(Long id) {
        movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.ERROR_MOVIE_NOT_FOUND + ": " + id));
        movieRepository.deleteById(id);
    }
}