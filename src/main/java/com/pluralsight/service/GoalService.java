package com.pluralsight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;
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

	public List<Goal> findAllGoals() {
		
		return goalRepository.findAll();
			
	}

	public List<GoalReport> findAllGoalReports() {
		// TODO Auto-generated method stub
		return goalRepository.loadGoalReports();
	}

}
