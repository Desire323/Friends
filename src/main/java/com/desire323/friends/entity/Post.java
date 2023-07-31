package com.desire323.friends.entity;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Post {

    @Id
    private Long id;
    private String content;
    private String theme;

    @Relationship(type = "POSTED", direction = Relationship.Direction.INCOMING)
    private Person author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTheme() {
        return this.theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }
    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }
}

