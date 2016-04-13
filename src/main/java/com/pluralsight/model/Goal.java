package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="Goals")
@NamedQueries(value={
	@NamedQuery(
			name=Goal.FIND_GOAL_REPORTS,
			query="SELECT new com.pluralsight.model.GoalReport(g.minutes, e.minutes, e.activity)"
					+ "FROM Goal g, Exercise e "
					+ "WHERE g.id = e.goal.id"
				),
	@NamedQuery(name=Goal.FIND_GOALS,
				query="SELECT g FROM Goal g"
				)
})
public class Goal {
	
	public static final String FIND_GOAL_REPORTS = "findGoalReports";
	public static final String FIND_GOALS = "findGoals";

	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;

	@Range(min = 1, max = 120)
	@Column(name="Minutes")
	private int minutes;

	
	@OneToMany(mappedBy="goal", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Exercise> exercises = new ArrayList<Exercise>();
	
	
	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}

}
