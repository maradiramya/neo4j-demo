package com.stackroute.neo4j.controller;

import com.stackroute.neo4j.domain.Movie;
import com.stackroute.neo4j.domain.User;
import com.stackroute.neo4j.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping(value = "api/v1")
public class UserController {

    private UserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public Collection<User> getAllMovieCritics() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/movies")
    public Iterable<Movie> getAllMovie() {
        return userService.getAllMovies();
    }

    @PostMapping(value = "/user")
    public User saveMovieCritic(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping(value = "/user")
    public User updateMovieCritic(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @PostMapping(value = "/movie")
    public Movie saveMovie(@RequestBody Movie movie) {

        return userService.saveMovie(movie);
    }

    @PutMapping(value = "/movie")
    public Movie updateMovie(@RequestBody Movie movie) {
        return userService.updateMovieById(movie);
    }

    @DeleteMapping(value = "/user")
    public User deleteCritic(@RequestBody User user) {
        return userService.deleteUserById(user);
    }

    @DeleteMapping(value = "/movie")
    public Movie deleteMovie(@RequestBody Movie movie) {
        return userService.deleteMovieById(movie);
    }

    @PostMapping(value = "/user/set")
    public User setRelation(@RequestParam long userId, long movieId, int rating) {
        return userService.setRelation(userId, movieId, rating);
    }


}
