package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;
import model.House;
import model.Person;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PersonHelper ph = new PersonHelper();
		CarHelper ch = new CarHelper();
		HouseHelper hh = new HouseHelper();
		String act = request.getParameter("doThisToPerson");
		String actCar = request.getParameter("doThisToCar");
		String actHouse = request.getParameter("doThisToHouse");
		String path = "/viewAllPersonsServlet";
		
		if (act != null) {
			if (act.equals("delete")) {
				try {
					Integer tempId = Integer.parseInt(request.getParameter("id")); 
					Person personToDelete = ph.searchForPersonById(tempId); 
					ph.deletePerson(personToDelete);
				} catch (NumberFormatException e) { 
					System.out.println("Forgot to select an item");
				}
			} else if (act.equals("edit")) {
				
				try {
					Integer tempId = Integer.parseInt(request.getParameter("id"));
					Person personToEdit = ph.searchForPersonById(tempId);
					request.setAttribute("personToEdit", personToEdit);
					path = "/edit-person.jsp";
				} catch (NumberFormatException e) {
					System.out.println("forgot to select a person");
				}
			} else if (act.equals("add")) {
				path = "/index.html";
			} else if (act.equals("view houses")) {
				try {
					Integer tempId = Integer.parseInt(request.getParameter("id"));
					Person personToEdit = ph.searchForPersonById(tempId);
					request.setAttribute("personToEdit", personToEdit);
					path = "/house-list.jsp";
				} catch (NumberFormatException e) {
					System.out.println("forgot to select a person");
				}
			} else if (act.equals("view cars")) {
				try {
					Integer tempId = Integer.parseInt(request.getParameter("id"));
					Person personToEdit = ph.searchForPersonById(tempId);
					request.setAttribute("personToEdit", personToEdit);
					path = "/car-list.jsp";
				} catch (NumberFormatException e) {
					System.out.println("forgot to select a person");
				}
			}
		}
		
		
		
		if (actCar != null) {
			if (actCar.equals("delete")) {
				try {
					path = "/ViewAllCarsServlet";
					Integer tempId = Integer.parseInt(request.getParameter("id")); 
					Car carToDelete = ch.searchForCarById(tempId); 
					ch.deleteCar(carToDelete);
				} catch (NumberFormatException e) { 
					System.out.println("Forgot to select an item");
				}
			} else if (actCar.equals("edit")) {
				
				try {
					Integer tempId = Integer.parseInt(request.getParameter("id"));
					Car carToEdit = ch.searchForCarById(tempId);
					request.setAttribute("carToEdit", carToEdit);
					path = "/edit-car.jsp";
				} catch (NumberFormatException e) {
					System.out.println("forgot to select a car");
				}
			} else if (actCar.equals("add")) {
				path = "/add-car.jsp";
			}
		}
		
		if (actHouse != null) {
			if (actHouse.equals("delete")) {
				try {
					path = "/ViewAllHousesServlet";
					Integer tempId = Integer.parseInt(request.getParameter("id")); 
					House houseToDelete = hh.searchForHouseById(tempId); 
					hh.deleteHouse(houseToDelete);
				} catch (NumberFormatException e) { 
					System.out.println("Forgot to select an item");
				}
			} else if (actHouse.equals("edit")) {
				
				try {
					Integer tempId = Integer.parseInt(request.getParameter("id"));
					House houseToEdit = hh.searchForHouseById(tempId);
					request.setAttribute("houseToEdit", houseToEdit);
					path = "/edit-house.jsp";
				} catch (NumberFormatException e) {
					System.out.println("forgot to select a car");
				}
			} else if (actHouse.equals("add")) {
				path = "/add-house.jsp";
			}
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
