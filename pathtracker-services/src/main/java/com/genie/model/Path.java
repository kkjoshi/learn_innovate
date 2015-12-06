package com.genie.model;

import java.time.Duration;

/**
 * Created by joshika on 12/6/2015.
 */
public class Path {
    private Duration timeTaken = Duration.ofSeconds(0);
    private String name = "";
    private Step from;
    private Step to;
    public Path(Step from, Step to, Duration duration, String name){
        this.setFrom(from);
        this.setTo(to);
        this.setTimeTaken(duration);
        this.name = name;//rom.getStepId()+"to"+to.getStepId();
    }

    public Duration getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(Duration timeTaken) {
        this.timeTaken = timeTaken;
    }

    public Step getFrom() {
        return from;
    }

    public void setFrom(Step from) {
        this.from = from;
    }

    public Step getTo() {
        return to;
    }

    public void setTo(Step to) {
        this.to = to;
    }
}

