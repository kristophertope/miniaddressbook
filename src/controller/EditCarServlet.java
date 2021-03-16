package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;
import model.House;

/**
 * Servlet implementation class EditCarServlet
 */
@WebServlet("/editCarServlet")
public class EditCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CarHelper ch = new CarHelper();
		
		int carID = Integer.parseInt(request.getParameter("id"));
		String make = request.getParameter("Make");	
		String model = request.getParameter("Model");	
		double price = Double.parseDouble(request.getParameter("Price")); 
		int year = Integer.parseInt(request.getParameter("YearOfCreation"));	
		
		Car carToUpdate = ch.searchForCarById(carID);
		carToUpdate.setMake(make);
		carToUpdate.setModel(model);
		carToUpdate.setPrice(price);
		carToUpdate.setYearOfCreation(year);
		
		ch.updateCar(carToUpdate);
		
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
