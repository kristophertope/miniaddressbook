package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * @author Snipe - iwertz
 * CIS175 - Spring 2021
 * Mar 9, 2021
 */
@Entity
@Table(name="Persons")
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PersonID")
	public int PersonID;
	@Column(name="FirstName")
	String FirstName;
	@Column(name="LastName")
	String LastName;
	@Column(name="DateOfBirth")
    java.sql.Date DateOfBirth;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable
	 (
	 name="Houses",
	 joinColumns={ @JoinColumn(name="PersonID", 
	referencedColumnName="PersonID") },
	 inverseJoinColumns={ @JoinColumn(name="HouseID", 
	referencedColumnName="HouseID", unique=true) }
	 )
	private List<House> ListOfHouses;

	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable
	 (
	 name="Cars",
	 joinColumns={ @JoinColumn(name="PersonID", 
	referencedColumnName="PersonID") },
	 inverseJoinColumns={ @JoinColumn(name="CarID", 
	referencedColumnName="CarID", unique=true) }
	 )
	private List<Car> ListOfCars;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(int personID) {
		super();
		PersonID = personID;
	}
	
	public Person(String firstName, String lastName, java.sql.Date dob) {
		FirstName = firstName;
		LastName = lastName;
		DateOfBirth = dob;
	}
	
	public Person(String firstName, String lastName) {
		FirstName = firstName;
		LastName = lastName;
	}
	
	public int getPersonID() {
		return PersonID;
	}
	public void setPersonID(int personID) {
		PersonID = personID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public java.sql.Date getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(java.sql.Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Person [PersonID=" + PersonID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", DateOfBirth="
				+ DateOfBirth + "]";
	}
	
}
