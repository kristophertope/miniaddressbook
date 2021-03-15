import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import controller.CarHelper;
import controller.HouseHelper;
import controller.PersonHelper;
import model.Car;
import model.House;
import model.Person;

/**
 * Kristopher Tope - kmtope@dmacc.edu
 * 202102 CIS175 22624
 * Mar 12, 2021
 */

public class StartProgram {

	static EntityManagerFactory emfactory = 
			Persistence.createEntityManagerFactory("MiniAddressBook");
	
	static Scanner in = new Scanner(System.in);
	static PersonHelper ph = new PersonHelper();
	static HouseHelper hh = new HouseHelper();
	static CarHelper ch = new CarHelper();
	
	private static void addHouse(Person person) {
		System.out.println("Enter price: ");
		double price = in.nextDouble();
		System.out.println("Enter year of creation: ");
		int year = in.nextInt();
		System.out.println("Enter address: ");
		String address = in.next();

		House toAdd = new House(price, year, address, person);
		hh.insertHouse(toAdd);
	}
	
	private static void deleteHouse(Person person) {
		EntityManager em = emfactory.createEntityManager();
		Query query = em.createQuery("SELECT h FROM House h WHERE h.person.PersonID = :personID");
	    query.setParameter("personID", person.PersonID);
	    List<House> allHouses = query.getResultList();
		
	    for (House house : allHouses) {
	    	System.out.println(house.getHouseID() + " : " + house.toString());
	    }
	    
		System.out.print("Enter the house id to delete: ");
		int id = in.nextInt();
		House toDelete = hh.searchForHouseById(id);
		hh.deleteHouse(toDelete);
	}
	
	private static void editHouse(Person person) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		Query query = em.createQuery("SELECT h FROM House h WHERE h.person.PersonID = :personID");
	    query.setParameter("personID", person.PersonID);
	    List<House> allHouses = query.getResultList();
		
	    for (House house : allHouses) {
	    	System.out.println(house.getHouseID() + " : " + house.toString());
	    }
	    
		House foundHouse;
		System.out.print("Enter the house ID: ");
		int id = in.nextInt();
		foundHouse = hh.searchForHouseById(id);

		if (foundHouse != null) {
			System.out.println("Found Results.");
			System.out.println(foundHouse.getHouseID() + " : " + foundHouse.toString());

			System.out.println("1 : Update price");
			System.out.println("2 : Update year of creation");
			System.out.println("3 : Update address");
			System.out.print("*  Your selection: ");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Price: ");
				double newPrice = in.nextDouble();
				foundHouse.setPrice(newPrice);
			} else if (update == 2) {
				System.out.print("New Year of Creation: ");
				int newYear = in.nextInt();
				foundHouse.setYearOfCreation(newYear);
			} else if (update == 3) {
				System.out.print("New Address: ");
				String newAddress = in.nextLine();
				foundHouse.setAddress(newAddress);
			}
		}
	}
	
	private static void addCar(Person person) {
		System.out.println("Enter make: ");
		String make = in.next();
		System.out.println("Enter model: ");
		String model = in.next();
		System.out.println("Enter price: ");
		double price = in.nextDouble();
		System.out.println("Enter year of creation: ");
		int year = in.nextInt();

		Car toAdd = new Car(make, model, price, year, person);
		ch.insertCar(toAdd);
	}
	
	private static void deleteCar(Person person) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		Query query = em.createQuery("SELECT c FROM Car c WHERE c.person.PersonID = :personID");
	    query.setParameter("personID", person.PersonID);
	    List<Car> allCars = query.getResultList();
		
	    for (Car car : allCars) {
	    	System.out.println(car.getCarID() + " : " + car.toString());
	    }
		
		System.out.print("Enter the car id to delete: ");
		int id = in.nextInt();
		Car toDelete = ch.searchForCarById(id);
		ch.deleteCar(toDelete);
	}
	
	private static void editCar(Person person) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		Query query = em.createQuery("SELECT c FROM Car c WHERE c.person.PersonID = :personID");
	    query.setParameter("personID", person.PersonID);
	    List<Car> allCars = query.getResultList();
		
	    for (Car car : allCars) {
	    	System.out.println(car.getCarID() + " : " + car.toString());
	    }
		
		Car foundCar;
		System.out.print("Enter the car ID: ");
		int id = in.nextInt();
		foundCar = ch.searchForCarById(id);

		if (foundCar != null) {
			System.out.println("Found Results.");
			System.out.println(foundCar.getCarID() + " : " + foundCar.toString());

			System.out.println("1 : Update make");
			System.out.println("2 : Update model");
			System.out.println("3 : Update price");
			System.out.println("4 : Update year of creation");
			System.out.print("*  Your selection: ");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Make: ");
				String newMake = in.nextLine();
				foundCar.setMake(newMake);
			} else if (update == 2) {
				System.out.print("New Model: ");
				String newModel = in.nextLine();
				foundCar.setModel(newModel);
			} else if (update == 3) {
				System.out.print("New Price: ");
				double newPrice = in.nextDouble();
				foundCar.setPrice(newPrice);
			} else if (update == 4) {
				System.out.print("New Year of Creation: ");
				int newYear = in.nextInt();
				foundCar.setYearOfCreation(newYear);
			}
		}
	}
	
	private static void addPerson() throws ParseException {
		System.out.println("Enter first name: ");
		String fname = in.nextLine();
		System.out.println("Enter last name: ");
		String lname = in.nextLine();
		System.out.println("Enter date of birth: ");
		String dobIn = in.next();
		DateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
		Date utilDob = formatter.parse(dobIn);
		java.sql.Date dob = new java.sql.Date(utilDob.getTime());
		Person toAdd = new Person(fname, lname, dob);
		ph.insertPerson(toAdd);
	}
	
	private static void deletePerson() {
		// TODO Auto-generated method stub
		System.out.print("Enter the person's first name to delete: ");
		String firstName = in.nextLine();
		System.out.print("Enter the person's last name to delete: ");
		String lastName = in.nextLine();
		Person toDelete = new Person(firstName, lastName);
		ph.deletePerson(toDelete);
	}
	
	private static void editPerson() throws ParseException {
		// TODO Auto-generated method stub
		Person foundPerson;
		System.out.print("Enter the person ID: ");
		int id = in.nextInt();
		foundPerson = ph.searchForPersonById(id);

		if (foundPerson != null) {
			System.out.println("Found Results.");
			System.out.println(foundPerson.getPersonID() + " : " + foundPerson.toString());

			System.out.println("1 : Update First Name");
			System.out.println("2 : Update Last Name");
			System.out.println("3 : Update Date of Birth");
			System.out.println("4 : Update Houses");
			System.out.println("5 : Update Cars");
			System.out.print("*  Your selection: ");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Frist Name: ");
				String newFirstName = in.nextLine();
				foundPerson.setFirstName(newFirstName);
			} else if (update == 2) {
				System.out.print("New Last Name: ");
				String newLastName = in.nextLine();
				foundPerson.setLastName(newLastName);
			} else if (update == 3) {
				System.out.print("New Date of Birth ('MM/DD/YYYY): ");
				String dobIn = in.next();
				DateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
				Date utilDob = formatter.parse(dobIn);
				java.sql.Date dob = new java.sql.Date(utilDob.getTime());
				foundPerson.setDateOfBirth(dob);
			} else if (update == 4) {
				System.out.println("1 : Add a house");
				System.out.println("2 : Update a house");
				System.out.println("3 : Delete a house");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();
				if (selection == 1) {
					addHouse(foundPerson);
				} else if (selection == 2) {
					editHouse(foundPerson);
				} else if (selection == 3) {
					deleteHouse(foundPerson);
				}
			} else if (update == 5) {
				System.out.println("1 : Add a car");
				System.out.println("2 : Update a car");
				System.out.println("3 : Delete a car");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();
				if (selection == 1) {
					addCar(foundPerson);
				} else if (selection == 2) {
					editCar(foundPerson);
				} else if (selection == 3) {
					deleteCar(foundPerson);
				}
			}

			ph.updatePerson(foundPerson);

		} else {
			System.out.println("---- No results found");
		}
	}
	
	private static void viewPeople() {
		List<Person> allPeople = ph.showAllPersons();
		for(Person p : allPeople) {
			System.out.println(p.toString());
		}
	}
	
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		runMenu();

	}


	private static void runMenu() throws ParseException {
		
		boolean goAgain = true;
		System.out.println("Address Book");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add an person");
			System.out.println("*  2 -- Edit a person");
			System.out.println("*  3 -- Delete a person");
			System.out.println("*  4 -- View all people");
			System.out.println("*  5 -- Exit");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addPerson();
			} else if (selection == 2) {
				editPerson();
			} else if (selection == 3) {
				deletePerson();
			} else if (selection == 4) {
				viewPeople();
			} else {
				ph.cleanUp();
				hh.cleanUp();
				ch.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}
		
	}
			
}

