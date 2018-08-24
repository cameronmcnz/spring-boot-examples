package com.mcnz.rps.spring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ScoreRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Score find(long id) {
		return entityManager.find(Score.class, id);
	}

	public List<Score> findAll() {
		Query query = entityManager.createNamedQuery("query_find_all_scores", Score.class);
		return query.getResultList();
	}

	public long save(Score score) {
		entityManager.persist(score);
		System.out.println("Persisted score: " + score.getId() + " wins " + score.getWins() +"  ties " + score.getTies()); 
		return score.getId();
	}
	
	public Score findScore() {
		System.out.println("Finding the score");
		Score score=null;
		Query query = entityManager.createNamedQuery("query_find_all_scores", Score.class);
		List scores = query.getResultList();
		System.out.println("Number of scores: " + scores.size());
		if (scores.size()>0) {
			//score = (Score)scores.get(0);
			score = entityManager.find(Score.class, new Long(1));
		} else {
			score = new Score();
			score.setId(System.currentTimeMillis());
			entityManager.persist(score);
			System.out.println("New score created with id of: " + score.getId());
		}
		
		return score;
		
	}

}
