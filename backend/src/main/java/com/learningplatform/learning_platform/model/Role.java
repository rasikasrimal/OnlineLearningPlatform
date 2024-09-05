package com.lms.model;

/*
 * Created by Chathuri
 * */

public enum Role {

    STUDENT("STUDENT"), TEACHER("TEACHER");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
