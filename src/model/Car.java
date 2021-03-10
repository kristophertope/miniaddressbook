package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Snipe - iwertz
 * CIS175 - Spring 2021
 * Mar 9, 2021
 */

@Entity
@Table(name="Car")
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CarID")
	int CarID;
	@Column(name="Make")
	String Make;
	@Column(name="Model")
	String Model;
	@Column(name="Price")
	double Price;
	@Column(name="YearOfCreation")
	int YearOfCreation;
	@ManyToOne
	@JoinColumn(name="PersonID")
	private Person person;
	
	
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Car(int carID) {
		super();
		CarID = carID;
	}

	public int getCarID() {
		return CarID;
	}
	public void setCarID(int carID) {
		CarID = carID;
	}
	public String getMake() {
		return Make;
	}
	public void setMake(String make) {
		Make = make;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public int getYearOfCreation() {
		return YearOfCreation;
	}
	public void setYearOfCreation(int yearOfCreation) {
		YearOfCreation = yearOfCreation;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "Car [CarID=" + CarID + ", Make=" + Make + ", Model=" + Model + ", Price=" + Price + ", YearOfCreation="
				+ YearOfCreation + ", person=" + person + "]";
	}
}
