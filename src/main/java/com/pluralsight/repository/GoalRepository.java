package com.pluralsight.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;

@Repository("goalRepository")
public class GoalRepository implements IGoalRepository {

	@PersistenceContext
	private EntityManager em;	

	public Goal save(Goal goal) {
		em.persist(goal);
		em.flush();
		return goal;
	}

	public List<Goal> loadAll() {
		TypedQuery<Goal> query = em.createNamedQuery(Goal.FIND_GOALS, Goal.class);
		
		return query.getResultList();

	}

	public List<GoalReport> loadGoalReports() {
		
		TypedQuery<GoalReport> query = em.createNamedQuery(Goal.FIND_GOAL_REPORTS, GoalReport.class);
		
		return query.getResultList();
	}

}
