package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Ticket;

public class TicketDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("supriya");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void insert(Ticket ticket)
	{
		entityTransaction.begin();
		entityManager.persist(ticket);
		entityTransaction.commit();
	}
	 public Ticket fetch(int id)
	 {
		 Ticket ticket=entityManager.find(Ticket.class, id);
		 return ticket;
	 }


}
