package com.stackroute.neo4j.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User
{
    @Id
    private Long userId;
    private String name;
    private int age;
    @Relationship(type="RATED",direction = Relationship.INCOMING)
    private List<Movie> movies;

}
