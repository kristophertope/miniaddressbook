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
 * Servlet implementation class AddHouseServlet
 */
@WebServlet("/AddHouseServlet")
public class AddHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHouseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double price = Double.parseDouble(request.getParameter("Price"));
		int year = Integer.parseInt(request.getParameter("YearOfCreation"));
		String address = request.getParameter("Address");
		int PersonID = Integer.parseInt(request.getParameter("PersonID"));	
		
		PersonHelper ph = new PersonHelper();
		Person person = ph.searchForPersonById(PersonID);
		
		HouseHelper hh = new HouseHelper();
		House h = new House(price, year, address, person);
		hh.insertHouse(h);
		
		getServletContext().getRequestDispatcher("/edit-person.html").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
