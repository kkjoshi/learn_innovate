package com.pluralsight.repository;

import com.pluralsight.model.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joshika on 11/12/2014.
 */
public class ActivityRespositoryStub implements IActivityRespository {

    @Override
    public List<Activity> findAllActivities() {
        List<Activity> activities = new ArrayList<Activity>();

        Activity activity1 = new Activity();
        activity1.setDescription("Swimming");
        activity1.setDuration(35);

        activities.add(activity1);
        return activities;
    }
}
