package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;

/**
 * @author Snipe - iwertz
 * CIS175 - Spring 2021
 * Mar 9, 2021
 */
@Entity
@Table(name="Person")
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PersonID")
	int PersonID;
	@Column(name="FirstName")
	String FirstName;
	@Column(name="LastName")
	String LastName;
	@Column(name="DateOfBirth")
	Date DateOfBirth;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(int personID) {
		super();
		PersonID = personID;
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
	public Date getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Person [PersonID=" + PersonID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", DateOfBirth="
				+ DateOfBirth + "]";
	}
	
}