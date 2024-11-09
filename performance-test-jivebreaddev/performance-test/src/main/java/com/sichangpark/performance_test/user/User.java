package com.sichangpark.performance_test.user;

import java.util.UUID;


public class User {

    public UUID id;
    public String email;


    public User(UUID id, String email) {
        this.id = id;
        this.email = email;

    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
