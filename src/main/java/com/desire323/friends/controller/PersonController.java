package com.desire323.friends.controller;

import com.desire323.friends.DTO.PersonDTO;
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

    @GetMapping
    public List<PersonDTO> getAllPersons() {
        return personService.findAll().stream().map(PersonDTO::new).toList();
    }

    @GetMapping("/{id}")
    public PersonDTO getPerson(@PathVariable String id) {
        return new PersonDTO(personService.findById(id));
    }

    @GetMapping("/{id}/friends-count")
    public ResponseEntity<Integer> getFriendsCount(@PathVariable String id) {
        return ResponseEntity.ok(personService.findFriends(id).size());
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody PersonDTO personDTO) {
        Person person = new Person(personDTO);
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
    public ResponseEntity<List<PersonDTO>> getFriends(@PathVariable String id) {
        List<PersonDTO> friends = personService.findFriends(id).stream().map(PersonDTO::new).toList();
        return ResponseEntity.ok(friends);
    }
}

