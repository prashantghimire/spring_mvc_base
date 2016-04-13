package com.pluralsight.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pluralsight.model.Goal;

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

}
