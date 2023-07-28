package com.desire323.friends.controller;

import com.desire323.friends.entity.Person;
import com.desire323.friends.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable String id) {
        return personService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        personService.save(person);
        return ResponseEntity.ok(person);
    }

    @PutMapping("/{friendId}")
    public ResponseEntity<String> makeFriends(@RequestHeader("x-auth-user-id") String currentUserId, @PathVariable String friendId) {
        personService.makeFriends(currentUserId, friendId);
        Person friend = personService.findById(friendId);
        return ResponseEntity.ok("You are now friends with " + friend.getFirstname() + " " + friend.getLastname());
    }

    @GetMapping("/{id}/friends")
    public ResponseEntity<List<Person>> getFriends(@PathVariable String id) {
        List<Person> friends = personService.findFriends(id);
        return ResponseEntity.ok(friends);
    }


}

