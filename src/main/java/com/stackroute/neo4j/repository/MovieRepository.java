package com.stackroute.neo4j.repository;

import com.stackroute.neo4j.domain.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MovieRepository extends Neo4jRepository<Movie,Long> {

}
