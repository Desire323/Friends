package com.desire323.friends.entity;

import com.desire323.friends.DTO.PersonDTO;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class Person {

    @Id
    private Long id;
    private String firstname;
    private String lastname;

    @Relationship(type = "FRIEND_OF")
    private List<Person> friends;

    @Relationship(type = "POSTED")
    private List<Post> posts;

    public Person() {
        this.friends = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public Person(PersonDTO personDTO) {
        this.id = personDTO.getId();
        this.firstname = personDTO.getFirstname();
        this.lastname = personDTO.getLastname();
        this.friends = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}

