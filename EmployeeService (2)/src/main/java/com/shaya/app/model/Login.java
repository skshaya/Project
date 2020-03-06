package com.shaya.app.model;

import javax.persistence.*;

@Entity
@Table(name = "Login")
public class Login {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    int id;

    String email;
    String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
