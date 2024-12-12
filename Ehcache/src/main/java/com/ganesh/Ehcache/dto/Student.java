package com.ganesh.Ehcache.dto;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {
    private int id;
    private String name;
    private String emailId;
    private String school;
    private String address;
    private String country;

//Override hashcode and equals methods as Key and value pair we are using


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Student student = (Student) object;
        return id == student.id && Objects.equals(name, student.name) && Objects.equals(emailId, student.emailId) && Objects.equals(school, student.school) && Objects.equals(address, student.address) && Objects.equals(country, student.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, emailId, school, address, country);
    }

    public Student() {
    }

    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAddress(String pune) {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
