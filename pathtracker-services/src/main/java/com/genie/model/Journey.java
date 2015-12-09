package com.genie.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joshika on 12/9/2015.
 */
public class Journey {
    private String name;
    private String description;
    private int noOfSteps;
    private int id;
    private List<Step> orderedSteps = new ArrayList<Step>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNoOfSteps() {
        return noOfSteps;
    }

    public void setNoOfSteps(int noOfSteps) {
        this.noOfSteps = noOfSteps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Step> getOrderedSteps() {
        return orderedSteps;
    }

    public void setOrderedSteps(List<Step> orderedSteps) {
        this.orderedSteps = orderedSteps;
    }
}
