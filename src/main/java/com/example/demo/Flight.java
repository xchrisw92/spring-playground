package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.Date;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Flight {
    @JsonProperty("Flight Number")
    private String id;
    @JsonProperty("Destination")
    private String landsAt;
    @JsonProperty("Flight Departure Date")
    private Date departsOn;
    private String secretInfo;
    @JsonProperty("Pilot")
    private Person pilot;
    @JsonProperty("Passengers")
    private List<Person> passengers = Collections.EMPTY_LIST;

    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Flight.Person> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Flight.Person> passengers) {
        this.passengers = passengers;
    }

    public Flight.Person getPilot() {
        return pilot;
    }

    public void setPilot(Flight.Person pilot) {
        this.pilot = pilot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLandsAt() {
        return landsAt;
    }

    public void setLandsAt(String landsAt) {
        this.landsAt = landsAt;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:MM")
    public Date getDepartsOn() {
        return departsOn;
    }

    public void setDepartsOn(Date departsOn) {
        this.departsOn = departsOn;
    }
    @JsonIgnore
    public String getSecretInfo() {
        return secretInfo;
    }

    public void setSecretInfo(String secretInfo) {
        this.secretInfo = secretInfo;
    }

    static class Person{
        private String firstname;
        private String lastname;

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }
    }
}
