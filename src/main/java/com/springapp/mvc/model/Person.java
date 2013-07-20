package com.springapp.mvc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created with IntelliJ IDEA.
 * User: prashantagarwal
 * Date: 20/07/13
 * Time: 12:44 AM
 * To change this template use File | Settings | File Templates.
 */



@Document
public class Person {

    @Id
    private String id;
    private String name;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
