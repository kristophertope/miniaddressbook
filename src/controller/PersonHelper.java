package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Person;

/**
 * @author Snipe - iwertz
 * CIS175 - Spring 2021
 * Mar 9, 2021
 */
public class PersonHelper {
	static EntityManagerFactory emfactory = 
			Persistence.createEntityManagerFactory("MiniAddressBook2");
	
	public void insertPerson(Person p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	public List<Person> showAllPersons() {
		EntityManager em = emfactory.createEntityManager();
		List<Person> allPersons = em.createQuery("SELECT p FROM Person p").getResultList();
		return allPersons;
	}
	
	public void cleanUp(){
		emfactory.close();
	}
}
