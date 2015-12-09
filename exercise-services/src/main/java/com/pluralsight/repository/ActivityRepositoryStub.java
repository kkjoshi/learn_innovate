package com.pluralsight.repository;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joshika on 7/31/2015.
 */
public class ActivityRepositoryStub implements ActivityRepository {
    @Override
    public List<Activity> findAllActivities() {
        List<Activity> activities = new ArrayList<Activity>();

        Activity activity1 = new Activity();
        activity1.setActivityId("1");
        activity1.setDescription("running");
        activity1.setDuration(45);
        User user = new User();
        user.setId("kkj");
        user.setName("Kashyap");

        activity1.setUser(user);
        activities.add(activity1);

        Activity activity2 = new Activity();
        activity2.setActivityId("2");
        activity2.setDuration(35);
        activity2.setDescription("swimming");
        activities.add(activity2);
        Activity activity3 = new Activity();
        activity3.setActivityId("3");
        activity3.setDuration(55);
        activity3.setDescription("walking");
        activities.add(activity3);

        return activities;
    }

    @Override
    public Activity findActivity(String activityId) {
        for (Activity act : findAllActivities()) {
            if (act.getActivityId().equals(activityId))
                return act;
        }
        return null;
    }

}
