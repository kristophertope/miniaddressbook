package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Person;

/**
 * @author Snipe - iwertz
 * CIS175 - Spring 2021
 * Mar 9, 2021
 */
public class PersonHelper {
	static EntityManagerFactory emfactory = 
			Persistence.createEntityManagerFactory("MiniAddressBook");
	
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
	
	public void deletePerson(Person personToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Person> typedQuery = em.createQuery("select p from Person p where p.FirstName = :selectedFirstName and p.LastName = :selectedLastName", Person.class);
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedFirstName", personToDelete.getFirstName());
		typedQuery.setParameter("selectedLastName", personToDelete.getLastName());

		//we only want one result
		typedQuery.setMaxResults(1);

		//get the result and save it into a new list item
		Person result = typedQuery.getSingleResult();

		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updatePerson(Person toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public Person searchForPersonById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Person found = em.find(Person.class, idToEdit);
		em.close();
		return found;
	}
	
	public void cleanUp(){
		emfactory.close();
	}
	
}
