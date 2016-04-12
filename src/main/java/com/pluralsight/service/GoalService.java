package com.pluralsight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pluralsight.model.Goal;
import com.pluralsight.repository.GoalRepository;

@Service("goalService")
public class GoalService implements IGoalService {

	@Autowired
	private GoalRepository goalRepository;

	public GoalRepository getGoalRepository() {
		return goalRepository;
	}

	public void setGoalRepository(GoalRepository goalRepository) {
		this.goalRepository = goalRepository;
	}

	public Goal save(Goal goal) {
		return goalRepository.save(goal);
	}

}
