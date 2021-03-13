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
@Table(name="Houses")
public class House {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="HouseID")
	int HouseID;
	@Column(name="Price")
	double Price;
	@Column(name="YearOfCreation")
	int YearOfCreation;
	@Column(name="Address")
	String Address;
	@ManyToOne
	@JoinColumn(name="PersonID")
	private Person person;
	
	public House() {
		super();
		// TODO Auto-generated constructor stub
	}
	public House(int houseID) {
		super();
		HouseID = houseID;
	}
	public int getHouseID() {
		return HouseID;
	}
	public void setHouseID(int houseID) {
		HouseID = houseID;
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
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "House [HouseID=" + HouseID + ", Price=" + Price + ", YearOfCreation=" + YearOfCreation + ", Address="
				+ Address + ", person=" + person + "]";
	}
	
}
