package com.example.cabinet_Doctor.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @JsonProperty("birth")
    private String date;
    private String time;
    @JsonProperty("name")
    private String NPatient;
    @JsonProperty("nameDoct")
    private String NDoct;
    @JsonProperty("description")
    private String Description;

    public Reservation() {
    }

    public Reservation(int id, String date, String time, String NPatient, String NDoct, String description) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.NPatient = NPatient;
        this.NDoct = NDoct;
        Description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNPatient() {
        return NPatient;
    }

    public void setNPatient(String NPatient) {
        this.NPatient = NPatient;
    }

    public String getNDoct() {
        return NDoct;
    }

    public void setNDoct(String NDoct) {
        this.NDoct = NDoct;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}