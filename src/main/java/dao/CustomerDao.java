package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Customer;

public class CustomerDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("supriya");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void Insert(Customer customer)
	{
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
	}
	public String Fetch(int id)
	{
		Query query=entityManager.createQuery("SELECT c.customerPassword FROM Customer c WHERE c.customerId = ?1");
		query.setParameter(1, id);
		String customer=(String) query.getSingleResult();
		return customer;
	}
	

	public Customer findByEmail(String email) {
	    Query query = entityManager.createQuery("SELECT c FROM Customer c WHERE c.customerEmail = ?1");
	    query.setParameter(1, email);
	    try {
	        return (Customer) query.getSingleResult();
	    } catch (NoResultException ex) {
	        return null; 
	    }
	}

	public boolean validateCredentials(String email, String password) {
	    Customer customer = findByEmail(email);
	    if (customer != null && customer.getCustomerPassword().equals(password)) {
	        return true; 
	    }
	    return false; 
	}
	
	
	
	public Customer findByPhone(long phno) {
	    Query query = entityManager.createQuery("SELECT c FROM Customer c WHERE c.customerPhoneNumber = ?1");
	    query.setParameter(1, phno);
	    try {
	        return (Customer) query.getSingleResult();
	    } catch (NoResultException ex) {
	        return null; 
	    }
	}

	public boolean validateCredentialsusingphno(long phno, String password) {
	    Customer customer = findByPhone(phno);
	    if (customer != null && customer.getCustomerPassword().equals(password)) {
	        return true; 
	    }
	    return false; 
	}


}
