package com.backendtillspa.backendtillspa.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Reservations")
public class Reservation {
    @Id
    private String id;
    private String name;
    private String packages;
    private String time;
    private String date;


    public Reservation(String id, String name, String packages, String time, String date) {
        this.id = id;
        this.name = name;
        this.packages = packages;
        this.time = time;
        this.date = date;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getReservationName() {
        return name;
    }


    public void setReservationName(String name) {
        this.name = name;
    }


    public String getPackages() {
        return packages;
    }


    public void setPackages(String packages) {
        this.packages = packages;
    }


    public String getTime() {
        return time;
    }


    public void setTime(String time) {
        this.time = time;
    }


    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }

    
    
}
