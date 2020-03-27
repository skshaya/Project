package com.sms.vehicle_service.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int vehicleid;
    String vehicleno;
    String phone;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Student.class,mappedBy = "vehicle")
    List<Student> students;

    public int getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(int vehicleid) {
        this.vehicleid = vehicleid;
    }

    public String getVehicleno() {
        return vehicleno;
    }

    public void setVehicleno(String vehicleno) {
        this.vehicleno = vehicleno;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

