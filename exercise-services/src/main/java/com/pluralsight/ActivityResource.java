package com.pluralsight;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ActivityRepositoryStub;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by joshika on 7/31/2015.
 */
@Path("activities")
public class ActivityResource {
    private ActivityRepository activityRepository = new ActivityRepositoryStub();

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Activity> getAllActivities(){
        return activityRepository.findAllActivities();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("{activityId}")
    public Activity getActivity(@PathParam("activityId") String activityId){
        return activityRepository.findActivity(activityId);
    }

    /**
     * get the user associated with activity, This is how to traverse trough nested objects.
     * @param activityId
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("{activityId}/user")
    public User getUser(@PathParam("activityId") String activityId){
        return activityRepository.findActivity(activityId).getUser();
    }
}
