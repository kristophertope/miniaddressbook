package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.House;
import model.Person;

/**
 * @author Snipe - iwertz
 * CIS175 - Spring 2021
 * Mar 9, 2021
 */
public class HouseHelper {
	static EntityManagerFactory emfactory = 
			Persistence.createEntityManagerFactory("MiniAddressBook");
	
	public void insertHouse(House h) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(h);
		em.getTransaction().commit();
		em.close();
	}
	public List<House> showAllHouses(String personID) {
		int PersonID = Integer.parseInt(personID);
		EntityManager em = emfactory.createEntityManager();
		Query query = em.createQuery("SELECT h FROM House h WHERE h.person.PersonID = :person");
	    query.setParameter("person", PersonID);
	    List<House> allHouses = query.getResultList();
		return allHouses;
	}
	
	public void deleteHouse(House houseToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<House> typedQuery = em.createQuery("select h from House h where h.person.PersonID = :personID and h.Address = :address", House.class);
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("personID", houseToDelete.person.getPersonID());
		typedQuery.setParameter("address", houseToDelete.getAddress());

		//we only want one result
		typedQuery.setMaxResults(1);

		//get the result and save it into a new list item
		House result = typedQuery.getSingleResult();

		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateHouse(House toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public House searchForHouseById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		House found = em.find(House.class, idToEdit);
		em.close();
		return found;
	}
	
	public void cleanUp(){
		emfactory.close();
	}
}
