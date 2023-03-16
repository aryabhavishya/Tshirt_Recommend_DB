package com.naehas.hibernatesample;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TshirtData {
	@Id
	private String Tid;
	private String Name;
	private String Colour;
	private String Gender;
	private String Size;
	private double Price;
	private double Rating;
	private String Availability;

	public String getTid() {
		return Tid;
	}
	public void setTid(String tid) {
		Tid = tid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getColour() {
		return Colour;
	}
	public void setColour(String colour) {
		Colour = colour;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getSize() {
		return Size;
	}
	public void setSize(String size) {
		Size = size;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public double getRating() {
		return Rating;
	}
	public void setRating(double rating) {
		Rating = rating;
	}
	public String getAvailability() {
		return Availability;
	}
	public void setAvailability(String availability) {
		Availability = availability;
	}
	
	@Override
	public String toString() {
		return "[Id=" + Tid + ", Name=" + Name + ", Colour=" + Colour + ", Gender=" + Gender + ", Size="
				+ Size + ", Price=" + Price + ", Rating=" + Rating + ", Availability=" + Availability + "]";
	}
}
