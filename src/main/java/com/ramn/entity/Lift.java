package com.ramn.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Lift")
public class Lift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "lift_number")
    private String liftNumber;

    @Column(name = "building")
    private String building;

    @Column(name = "wing")
    private String wing;

    @Column(name = "lift_now_at")
    private String liftNowAt;

    @Column(name = "is_good")
    private boolean isGood;

    // Constructors, getters, and setters

    public Lift() {
    }

    public Lift(String liftNumber, String building, String wing, String liftNowAt, boolean isGood) {
        this.liftNumber = liftNumber;
        this.building = building;
        this.wing = wing;
        this.liftNowAt = liftNowAt;
        this.isGood = isGood;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLiftNumber() {
        return liftNumber;
    }

    public void setLiftNumber(String liftNumber) {
        this.liftNumber = liftNumber;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getWing() {
        return wing;
    }

    public void setWing(String wing) {
        this.wing = wing;
    }

    public String getLiftNowAt() {
        return liftNowAt;
    }

    public void setLiftNowAt(String liftNowAt) {
        this.liftNowAt = liftNowAt;
    }

    public boolean isGood() {
        return isGood;
    }

    public void setGood(boolean isGood) {
        this.isGood = isGood;
    }
}