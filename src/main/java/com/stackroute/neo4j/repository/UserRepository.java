package com.stackroute.neo4j.repository;

import com.stackroute.neo4j.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface UserRepository extends Neo4jRepository<User,Long> {
    @Query("MATCH (u:user)<-[r:RATED]-(m:Movie) RETURN u,r,m")
    Collection<User> getAllUsers();
    @Query("CREATE(m:Movie)-[:RATED {rating: {rating}]->(u:user)")
    User setRelation(@Param("rating") int rating);
}
