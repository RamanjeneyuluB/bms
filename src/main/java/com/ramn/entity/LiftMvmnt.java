package com.ramn.entity;

import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "lift_mvmnt")
public class LiftMvmnt {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "moment_number")
    private int momentNumber;
    
    @Column(name = "lift_number")
    private Long liftNumber;


    @Column(name = "from_floor")
    private String fromFloor;

    @Column(name = "to_floor")
    private String toFloor;
    
    @Column(nullable = false, columnDefinition = "TIME DEFAULT '00:00:00'")
    private LocalTime fromTime;

    @Column(nullable = false, columnDefinition = "TIME DEFAULT '00:00:00'")
    private LocalTime toTime;
    
    // Constructors, getters, and setters

    public LiftMvmnt() {
    }

    // Getters and Setters

   
    public LiftMvmnt(Long liftNumber, int momentNumber, String fromFloor, String toFloor, LocalTime fromTime,
			LocalTime toTime) {
		super();
		this.liftNumber = liftNumber;
		this.momentNumber = momentNumber;
		this.fromFloor = fromFloor;
		this.toFloor = toFloor;
		this.fromTime = fromTime;
		this.toTime = toTime;
	}

	public Long getLiftNumber() {
        return liftNumber;
    }

    public void setLiftNumber(Long liftNumber) {
        this.liftNumber = liftNumber;
    }

    public int getMomentNumber() {
        return momentNumber;
    }

    public void setMomentNumber(int momentNumber) {
        this.momentNumber = momentNumber;
    }

    public String getFromFloor() {
        return fromFloor;
    }

    public void setFromFloor(String fromFloor) {
        this.fromFloor = fromFloor;
    }

    public String getToFloor() {
        return toFloor;
    }

    public void setToFloor(String toFloor) {
        this.toFloor = toFloor;
    }
    
    public LocalTime getFromTime() {
        return fromTime;
    }
    
    public void setFromTime(LocalTime fromTime) {
        this.fromTime = fromTime;
    }

    public LocalTime getToTime() {
        return toTime;
    }

    public void setToTime(LocalTime toTime) {
        this.toTime = toTime;
    }
}