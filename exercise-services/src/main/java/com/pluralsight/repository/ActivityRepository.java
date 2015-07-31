package com.pluralsight.repository;

import com.pluralsight.model.Activity;

import java.util.List;

/**
 * Created by joshika on 7/31/2015.
 */
public interface ActivityRepository {
    List<Activity> findAllActivities();

    Activity findActivity(String activityId);
}
