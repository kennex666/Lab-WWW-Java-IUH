package fit.iuh.upload;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024,
		location = "T://Upload",
		maxFileSize = 1024 * 1024 * 5,
		maxRequestSize = 1024 * 1024 * 10
)

public class UploadServlet extends HttpServlet {
	private static String uploadPath = null;
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UploadServlet() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	this.uploadPath = getServletContext().getInitParameter("upload.path");
    	
    	File test = new File(uploadPath);
    	
    	if (!test.exists()) {
    		System.out.println("No folder found, created: " + test.mkdir());
    	}
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
		doGet(request, response);
		try {
			DriverManager.registerDriver(new SQLServerDriver());
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=UploadFileServletDB;encrypt=false", "sa", "sapassword");

			String sql = "INSERT INTO contacts(first_name, last_name, photo) VALUES (?, ?, ?)";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			

			String first = request.getParameter("first");
			String last = request.getParameter("last");
			Part photoPart = request.getPart("file");
			
			if (photoPart == null || photoPart.getSubmittedFileName() == null) {
				System.err.println("Not found file!");
			}
			
			pstm.setString(1, first);
			pstm.setString(2, last);
			pstm.setBlob(3, photoPart.getInputStream());
			
			if (pstm.executeUpdate() > 0) {
				response.getWriter().append("Uploaded successfully");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception

			response.getWriter().append(e.getMessage());
		}
		
	}

}
