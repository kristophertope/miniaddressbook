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

import model.Person;

/**
 * Servlet implementation class EditPersonServlet
 */
@WebServlet("/EditPersonServlet")
public class EditPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PersonHelper ph = new PersonHelper();
		
		int personID = Integer.parseInt(request.getParameter("PersonID"));
		String fname = request.getParameter("FirstName"); 
		String lname = request.getParameter("LastName");
		String dobIn = request.getParameter("DateOfBirth");	
		
		DateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
		java.util.Date utilDob = null;
		try {
			utilDob = formatter.parse(dobIn);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date dob = new java.sql.Date(utilDob.getTime());
		
		Person personToUpdate = ph.searchForPersonById(personID);
		personToUpdate.setFirstName(fname);
		personToUpdate.setLastName(lname);
		personToUpdate.setDateOfBirth(dob);
		
		ph.updatePerson(personToUpdate);
		
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
