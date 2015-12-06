package com.pluralsight;

import com.pluralsight.model.Activity;
import com.pluralsight.repository.ActivityRespositoryStub;
import com.pluralsight.repository.IActivityRespository;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

/**
 * Created by joshika on 11/12/2014.
 */
public class ActivityResource {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Activity> getActivities(){
        IActivityRespository repos = new ActivityRespositoryStub();
       return  repos.findAllActivities();
    }
}
