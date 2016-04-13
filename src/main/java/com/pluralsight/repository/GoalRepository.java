package com.pluralsight.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

		Query query = em.createQuery("SELECT new com.pluralsight.model.GoalReport(g.minutes, e.minutes, e.activity)"
				+ "from Goal g, Exercise e WHERE g.id = e.goal.id");

		List<GoalReport> goalReports = query.getResultList();

		return goalReports;
	}

}
