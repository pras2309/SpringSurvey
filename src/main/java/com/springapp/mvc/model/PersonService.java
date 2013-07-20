package com.springapp.mvc.model;

/**
 * Created with IntelliJ IDEA.
 * User: prashantagarwal
 * Date: 20/07/13
 * Time: 12:51 AM
 * To change this template use File | Settings | File Templates.
 */

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.springapp.mvc.model.Person;

@Repository
public class PersonService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public static final String COLLECTION_NAME = "person";

    public void addPerson(Person person) {
        if (!mongoTemplate.collectionExists(Person.class)) {
            mongoTemplate.createCollection(Person.class);
        }
        person.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(person, COLLECTION_NAME);
    }

    public List<Person> listPerson() {
        return mongoTemplate.findAll(Person.class, COLLECTION_NAME);
    }

    public void deletePerson(Person person) {
        mongoTemplate.remove(person, COLLECTION_NAME);
    }

    public void updatePerson(Person person) {
        mongoTemplate.insert(person, COLLECTION_NAME);
    }
}