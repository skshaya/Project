package com.shaya.app.model;

import javax.persistence.*;
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

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

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
}
