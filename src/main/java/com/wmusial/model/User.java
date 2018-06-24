package com.wmusial.model;

import javax.persistence.*;

@Entity // -> mówimy hibernateowi, że to jest klasa, która mapuje rekordy z bazy danych
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name") //zmieniamy nazwę z CamelCase Javy na notację sql
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false) // nie ma name bo chcemy taka samą nazwę w bazie jak tutaj
    private String email;

    @Column(name = "avatar_url", length = 500) //lenght warunkuje długość varchara
    private String avatarUrl;

    public User() {
    }

    public User(String firstName, String lastName, String email, String avatarUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.avatarUrl = avatarUrl;
    }

    public User(Long id, String firstName, String lastName, String email, String avatarUrl) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
