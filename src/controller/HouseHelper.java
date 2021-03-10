package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.House;
import model.Person;

/**
 * @author Snipe - iwertz
 * CIS175 - Spring 2021
 * Mar 9, 2021
 */
public class HouseHelper {
	static EntityManagerFactory emfactory = 
			Persistence.createEntityManagerFactory("MiniAddressBook2");
	
	public void insertHouse(House h) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(h);
		em.getTransaction().commit();
		em.close();
	}
	public List<House> showAllHouses() {
		EntityManager em = emfactory.createEntityManager();
		List<House> allHouses = em.createQuery("SELECT h FROM House h").getResultList();
		return allHouses;
	}
}
