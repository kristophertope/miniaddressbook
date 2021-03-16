package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAllHousesServlet
 */
@WebServlet("/viewAllHousesServlet")
public class ViewAllHousesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllHousesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response, String personID) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HouseHelper hh = new HouseHelper();
		request.setAttribute("allHouses", hh.showAllHouses(personID));
		String path = "/update-houses.jsp";
		
		if(hh.showAllHouses(personID).isEmpty()) {
			path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, String personID) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response, personID);
	}

}
