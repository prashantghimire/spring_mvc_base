package com.pluralsight.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

		// some jpql

		Query query = em.createQuery("SELECT g FROM Goal g");

		List<Goal> goals = query.getResultList();

		return goals;

	}

	public List<GoalReport> loadGoalReports() {
		
		TypedQuery<GoalReport> query = em.createNamedQuery(Goal.FIND_GOAL_REPORTS, GoalReport.class);
		
		return query.getResultList();
	}

}
