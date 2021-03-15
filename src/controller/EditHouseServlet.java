package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.House;
import model.Person;

/**
 * Servlet implementation class EditHouseServlet
 */
@WebServlet("/EditHouseServlet")
public class EditHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditHouseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HouseHelper hh = new HouseHelper();
		
		int houseID = Integer.parseInt(request.getParameter("HouseID"));
		double price = Double.parseDouble(request.getParameter("Price")); 
		int year = Integer.parseInt(request.getParameter("YearOfCreation"));
		String address = request.getParameter("Address");	
		
		House houseToUpdate = hh.searchForHouseById(houseID);
		houseToUpdate.setPrice(price);
		houseToUpdate.setYearOfCreation(year);
		houseToUpdate.setAddress(address);
		
		hh.updateHouse(houseToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllPersonsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
