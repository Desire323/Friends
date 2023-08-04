package com.desire323.friends.repository;

import com.desire323.friends.entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

    Optional<Person> findById(Long id);

    List<Person> findByFirstname(String firstname);

    List<Person> findByLastname(String lastname);

    @Query("MATCH (p:Person)-[:FRIEND_OF]->()-[:FRIEND_OF]->(fof:Person) WHERE p.id = $personId AND NOT (p)-[:FRIEND_OF]->(fof) AND p <> fof RETURN DISTINCT fof")
    List<Person> findFriendsOfFriends(String personId);
}

