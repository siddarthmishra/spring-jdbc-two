package com.pojo;

import java.time.LocalDate;

public class Passenger {

	private int id;

	private String name;

	private String source;

	private String destination;

	private LocalDate dob;

	private LocalDate doj;

	private String time;

	private String status;

	private float cost;

	public Passenger() {

	}

	public Passenger(String name, String source, String destination, LocalDate dob, LocalDate doj, String time,
			String status, float cost) {
		this.name = name;
		this.source = source;
		this.destination = destination;
		this.dob = dob;
		this.doj = doj;
		this.time = time;
		this.status = status;
		this.cost = cost;
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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		String s = "Passenger Id : " + id + "\nPassenger name : " + name + "\nSource : " + source + "\nDestination : "
				+ destination + "\nDate of booking : " + dob + "\nDate of Journey : " + doj + "\nDeparture time : "
				+ time + "\nBooking status : " + status + "\nCost : " + cost;
		return s;
	}

}
