package fit.iuh.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fit.iuh.entities.Student;

/**
 * Servlet implementation class FormServlet
 */
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
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
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String day = req.getParameter("day");
		String month = req.getParameter("month");
		String year = req.getParameter("year");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-mm-dd");
		
		LocalDate dob = LocalDate.parse(year + "-" + month + "-" + day, dtf);
		
		String email = req.getParameter("email");
		
		String pnumber = req.getParameter("pnumber");
		
		boolean gender = (req.getParameter("gender").equalsIgnoreCase("Male"));
		
		String address = req.getParameter("address");
		
		String city = req.getParameter("city");
		
		String pinCode = req.getParameter("pin");
		
		String state = req.getParameter("state");
		
		String country = req.getParameter("country");
		
		String[] hobbies = req.getParameterValues("hobbies");
		
//		String qlfn =
		
		String course = req.getParameter("course");
		
		Student std = new Student(fname, lname, dob, email, pnumber, address, city, pinCode, state, country, course, gender, hobbies, null);
		
		
	}

}
