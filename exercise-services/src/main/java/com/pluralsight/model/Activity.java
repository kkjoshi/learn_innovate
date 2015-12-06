package com.pluralsight.model;

import javax.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlElement;

@XmlRootElement
public class Activity {
	private String description;
	private int duration;
	@XmlElement(name="desc")
	public String getDescription() {
		return description;
	}
	public int getDuration() {
		return duration;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
	
}
