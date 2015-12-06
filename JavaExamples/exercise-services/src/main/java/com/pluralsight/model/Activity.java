package com.pluralsight.model;

/**
 * Created by joshika on 10/26/2014.
 */
public class Activity {
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    private String description;
    private int duration;
}
