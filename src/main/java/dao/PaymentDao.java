package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Payment;

public class PaymentDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("supriya");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void insert(Payment card)
	{
		entityTransaction.begin();
		entityManager.persist(card);
		entityTransaction.commit();
	}
	
}
