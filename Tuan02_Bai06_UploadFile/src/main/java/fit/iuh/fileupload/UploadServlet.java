package fit.iuh.fileupload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collection;

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
		location = "T:\\Upload",
		maxFileSize = 1024 * 1024 * 5,
		maxRequestSize = 1024 * 1024 * 10
)

@WebServlet("/UploadServlet")
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
    	
    	uploadPath = getServletContext().getInitParameter("upload.folder");
    	
    	File test = new File(uploadPath);
    	
    	if (!test.exists()) {
    		test.mkdir();
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
		response.setHeader("Context-Type", "text/html");
		response.getWriter().append("<html>");
		try {
			for (Part part : request.getParts()) {
			
				if (part == null || part.getSubmittedFileName() == null || part.getSubmittedFileName().isBlank()) {
					response.getWriter().append("Error: Failed to upload file - Not found!");
				} else {
					String fileName = part.getSubmittedFileName();
					
					Files.copy(part.getInputStream(), Paths.get(uploadPath + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);
					response.getWriter().append("Uploaded successfully. Current location file: " + uploadPath + File.separator + fileName + "<br>");
				}
			}
		} catch (Exception e) {				
			response.getWriter().append(e.getMessage());
			System.err.println(e);
		}

		response.getWriter().append("</html>");
	}

}
