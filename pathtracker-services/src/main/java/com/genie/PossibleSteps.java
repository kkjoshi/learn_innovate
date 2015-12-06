package com.genie;

import com.genie.model.Step;
import com.genie.repository.StepResource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by joshika on 12/6/2015.
 */
@Path("steps")
public class PossibleSteps {
    private StepResource res = new StepResource();

    @GET
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Step> createDefault() {
        res.createDefaultSteps();
        List<Step> result = res.findAllSteps();
        return result;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("clean")
    public void clean() {
        res.cleanDefaultGraph();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public List<Step> getAllSteps() {
        List<Step> result = res.findNextPossibleSteps();
        return result;
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("allastext")
    public String getItAsString() {
        List<Step> result = res.findNextPossibleSteps();
        StringBuilder sb = new StringBuilder();

        for(Step stp: result){
            sb.append("Step Id: "+ stp.getStepId())
                    .append("\tName: "+stp.getName())
                    .append("\tIs Start?: "+stp.getDescription() + "\n ->");
        }
        return sb.toString();
    }

}
