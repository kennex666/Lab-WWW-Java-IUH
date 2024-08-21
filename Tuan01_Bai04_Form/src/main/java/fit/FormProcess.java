package fit;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormProcess
 */
@WebServlet("/FormProcess")
public class FormProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FormProcess() {
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
		
		PrintWriter pw = response.getWriter();
		
		String str = "<p>Name: " + request.getParameter("first") + " " + request.getParameter("last") + "</p>"
				+ "<p>Username: " + request.getParameter("username") + "</p>"
				+ "<p>Email: " + request.getParameter("email") + "</p>"
				+ "<p>Facebook: " + request.getParameter("facebook") + "</p>"
				+ "<p>Short bio: " + request.getParameter("bio") + "</p>";
		
		pw.write(str);
	}

}
