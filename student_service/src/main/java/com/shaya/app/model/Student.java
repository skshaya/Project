package com.shaya.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int studentid;
    String firstname;
    String lastname;
    String studentclass;

    @OneToOne(cascade = CascadeType.ALL)
    Address address;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Telephone.class,mappedBy = "student")
    List<Telephone> telephones;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Teacher teacher;

    @OneToOne(cascade = CascadeType.ALL)
    Vehicle vehicle;

    @OneToOne(cascade = CascadeType.ALL)
    Login login;

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStudentclass() {
        return studentclass;
    }

    public void setStudentclass(String studentclass) {
        this.studentclass = studentclass;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
