package com.pluralsight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pluralsight.model.Goal;
import com.pluralsight.repository.IGoalRepository;

@Service("goalService")
public class GoalService implements IGoalService {

	@Autowired
	private IGoalRepository goalRepository;

	public IGoalRepository getGoalRepository() {
		return goalRepository;
	}

	public void setGoalRepository(IGoalRepository goalRepository) {
		this.goalRepository = goalRepository;
	}

	@Transactional
	public Goal save(Goal goal) {
		return goalRepository.save(goal);
	}

}
