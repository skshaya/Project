package com.shaya.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

//just telling jpa to make a table 

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String no;
    String street;
    String town;
    String city;
//    @ManyToOne
//            @JoinColumn
//            @JsonIgnore
//    Student student;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
