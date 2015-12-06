package com.pluralsight.repository;

import com.pluralsight.model.Activity;

import java.util.List;

/**
 * Created by joshika on 11/12/2014.
 */
public interface IActivityRespository {
    List<Activity> findAllActivities();
}
