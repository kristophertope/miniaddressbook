package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Car;
import model.House;
import model.Person;

/**
 * @author Snipe - iwertz
 * CIS175 - Spring 2021
 * Mar 9, 2021
 */
public class CarHelper {
	static EntityManagerFactory emfactory = 
			Persistence.createEntityManagerFactory("MiniAddressBook");
	
	public void insertCar(Car c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	public List<Car> showAllCars(String personID) {
		int PersonID = Integer.parseInt(personID);
		EntityManager em = emfactory.createEntityManager();
		Query query = em.createQuery("SELECT c FROM Car c WHERE c.person.PersonID = :person");
	    query.setParameter("person", PersonID);
	    List<Car> allCars = query.getResultList();
		return allCars;
	}
	
	public void deleteCar(Car carToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select c from Car c where c.person.PersonID = :personID and c.Make = :make and c.Model = :model", Car.class);
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("personID", carToDelete.person.getPersonID());
		typedQuery.setParameter("make", carToDelete.getMake());
		typedQuery.setParameter("model", carToDelete.getModel());

		//we only want one result
		typedQuery.setMaxResults(1);

		//get the result and save it into a new list item
		Car result = typedQuery.getSingleResult();

		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateCar(Car toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public Car searchForCarById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Car found = em.find(Car.class, idToEdit);
		em.close();
		return found;
	}
	
	public void cleanUp(){
		emfactory.close();
	}
}
