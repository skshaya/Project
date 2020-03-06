package com.sms.teacher_service.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Teacher")
public class Teacher {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        int teacherid;
        String firstname;
        String lastname;
        String qualification;

        @OneToOne(cascade = CascadeType.ALL)
        Address address;

        @OneToMany(cascade = CascadeType.ALL,targetEntity = Telephone.class,mappedBy = "teacher")
        List<Telephone> telephones;

        @OneToOne(cascade = CascadeType.ALL)
        Login login;

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
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

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}


