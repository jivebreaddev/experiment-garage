package com.sichangpark.performance_test.user;


public class UserDto {

    private String name;
    private String email;
    private String phone;

    public UserDto(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public UserDto() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
