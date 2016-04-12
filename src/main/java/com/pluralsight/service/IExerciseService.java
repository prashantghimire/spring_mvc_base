package com.pluralsight.service;

import java.util.List;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;

public interface IExerciseService {

	List<Activity> findAllActivities();
	
	Exercise save(Exercise goal);
}