package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Movie;

public class MovieDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("supriya");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void insert(Movie movie)
	{
		entityTransaction.begin();
		entityManager.persist(movie);
		entityTransaction.commit();
	}
	public Movie fetch(int id)
	{
		Movie movie=entityManager.find(Movie.class, id);
		return movie;
	}

}
