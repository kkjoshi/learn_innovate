package com.pluralsight.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by joshika on 7/31/2015.
 */
@XmlRootElement
public class User {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String id;
}
