package com.desire323.friends.repository;

import com.desire323.friends.entity.Post;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PostRepository extends Neo4jRepository<Post, Long> {
}

