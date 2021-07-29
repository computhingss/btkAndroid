package com.example.btkandroid.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Person {
    @Id(autoincrement=true)
    private long id;
    private String name;
    private String surname;
    private String identityNumber;
    private String fatherName;
    private String motherName;
    @Generated(hash = 1026487958)
    public Person(long id, String name, String surname, String identityNumber,
            String fatherName, String motherName) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.identityNumber = identityNumber;
        this.fatherName = fatherName;
        this.motherName = motherName;
    }
    @Generated(hash = 1024547259)
    public Person() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return this.surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getIdentityNumber() {
        return this.identityNumber;
    }
    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }
    public String getFatherName() {
        return this.fatherName;
    }
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
    public String getMotherName() {
        return this.motherName;
    }
    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getIdentityNumber() {
        return this.identityNumber;
    }
    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

}
