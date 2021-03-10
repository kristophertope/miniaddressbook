package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Car;
import model.Person;

/**
 * @author Snipe - iwertz
 * CIS175 - Spring 2021
 * Mar 9, 2021
 */
public class CarHelper {
	static EntityManagerFactory emfactory = 
			Persistence.createEntityManagerFactory("MiniAddressBook2");
	
	public void insertCar(Car c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	public List<Car> showAllCars() {
		EntityManager em = emfactory.createEntityManager();
		List<Car> allCars = em.createQuery("SELECT c FROM Car c").getResultList();
		return allCars;
	}
}
