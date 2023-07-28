package com.desire323.friends.service;

import com.desire323.friends.entity.Person;
import com.desire323.friends.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findById(String id) {
        Long userId = Long.parseLong(id);
        return personRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("No Person with id " + id));
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    @Transactional
    public void makeFriends(String currentUserId, String friendId) {
        Person currentUser = findById(currentUserId);
        Person friend = findById(friendId);
        currentUser.getFriends().add(friend);
        friend.getFriends().add(currentUser);
        save(currentUser);
        save(friend);
//        return currentUser;
    }

    @Transactional(readOnly = true)
    public List<Person> findFriends(String userId) {
        Person user = findById(userId);
        return user.getFriends();
    }

    @Transactional(readOnly = true)
    public List<Person> findFriendsOfFriends(String userId) {
        return personRepository.findFriendsOfFriends(userId);
    }
}
