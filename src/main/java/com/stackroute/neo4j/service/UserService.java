package com.stackroute.neo4j.service;

import com.stackroute.neo4j.domain.Movie;
import com.stackroute.neo4j.domain.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
public interface UserService
{
    User saveUser(User user);


    Collection<User> getAllUsers();


    User getUserById(User user);


    User deleteUserById(User user);


    User updateUser(User user);

    Movie getMovieById(Movie movie);

    Movie saveMovie(Movie movie);

    Iterable<Movie> getAllMovies();

    Movie deleteMovieById(Movie movie);

    Movie updateMovieById(Movie movie);
    User setRelation(long userId, long movieId, int rating);
}
