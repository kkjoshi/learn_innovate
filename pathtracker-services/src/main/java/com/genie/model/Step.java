package com.genie.model;

import java.time.LocalDateTime;

/**
 * Created by joshika on 12/6/2015.
 */

public class Step {

    private String name;
    private String description;
    private long stepId;
    private String createdAt;
   // private List<Path> fromPaths = new LinkedList();
   // private List<Path> toPaths = new LinkedList();

    public Step(){}
    public Step(String name, String desc, long stepId, LocalDateTime createAt){
        this.name = name;
        this.stepId = stepId;
        this.description = description;
        this.createdAt = createAt.toString();
    }
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

    public long getStepId() {
        return stepId;
    }

    public void setStepId(long stepId) {
        this.stepId = stepId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

//    public List<Path> getFromPaths() {
//        return fromPaths;
//    }
//
//    public void setFromPaths(List<Path> fromPaths) {
//        this.fromPaths = fromPaths;
//    }
//
//    public List<Path> getToPaths() {
//        return toPaths;
//    }
//
//    public void setToPaths(List<Path> toPaths) {
//        this.toPaths = toPaths;
  //  }
}
