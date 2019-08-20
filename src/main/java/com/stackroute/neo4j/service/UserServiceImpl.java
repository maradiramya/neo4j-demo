package com.stackroute.neo4j.service;

import com.stackroute.neo4j.domain.Movie;
import com.stackroute.neo4j.domain.User;
import com.stackroute.neo4j.repository.MovieRepository;
import com.stackroute.neo4j.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private MovieRepository movieRepository;

    public UserServiceImpl() {
    }
@Autowired
    public UserServiceImpl(UserRepository userRepository, MovieRepository movieRepository) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Collection<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUserById(User user) {

            return userRepository.findById(user.getUserId()).get();
    }

    @Override
    public User deleteUserById(User user) {
       Optional <User> deleteUser = userRepository.findById(user.getUserId());
        userRepository.deleteById(user.getUserId());
        return deleteUser.get();
    }

    @Override
    public User updateUser(User user) {
        userRepository.findById(user.getUserId());
        return userRepository.save(user);
    }

    @Override
    public Movie getMovieById(Movie movie) {
        return movieRepository.findById(movie.getMovieId()).get();
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie deleteMovieById(Movie movie) {
        Optional<Movie> deletedMovie = movieRepository.findById(movie.getMovieId());
        movieRepository.deleteById(movie.getMovieId());
        return deletedMovie.get();
    }

    @Override
    public Movie updateMovieById(Movie movie) {
        movieRepository.findById(movie.getMovieId());
       return movieRepository.save(movie);

    }

    @Override
    public User setRelation(long userId, long movieId, int rating) {
        return userRepository.setRelation(rating);
    }
}
