package com.example.cabinet_Doctor.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
 //   @JsonProperty("birth")
    private String birth;
    private String time;
    //@JsonProperty("name")
    private String name;
   // @JsonProperty("nameDoct")
    private String nameDoct;
   // @JsonProperty("description")
    private String description;

    public Reservation() {
    }

    public Reservation(int id, String birth, String time, String name, String nameDoct, String description) {
        this.id = id;
        this.birth = birth;
        this.time = time;
        this.name = name;
        this.nameDoct = nameDoct;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameDoct() {
        return nameDoct;
    }

    public void setNameDoct(String nameDoct) {
        this.nameDoct = nameDoct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}