import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import controller.PersonHelper;
import model.Person;

/**
 * Kristopher Tope - kmtope@dmacc.edu
 * 202102 CIS175 22624
 * Mar 12, 2021
 */

public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static PersonHelper ph = new PersonHelper();
	
	private static void addPerson() throws ParseException {
		System.out.println("Enter first name: ");
		String fname = in.nextLine();
		System.out.println("Enter last name: ");
		String lname = in.nextLine();
		System.out.println("Enter date of birth: ");
		String dobIn = in.next();
		DateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
		Date dob = formatter.parse(dobIn);
		Person toAdd = new Person(fname, lname, dob);
		ph.insertPerson(toAdd);
	}
	
	private static void editPerson() {
	}
	
	private static void deletePerson() {
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
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}
		
	}
			
}

