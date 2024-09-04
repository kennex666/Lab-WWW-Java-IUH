package com.obxstd;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.activation.FileDataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class EmailSenderServlet
 */
@WebServlet("/EmailSenderServlet")

@MultipartConfig(fileSizeThreshold = 1024 * 1024, location = "T:\\Upload", maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024*1024*15)

public class EmailSenderServlet extends HttpServlet {
	private static String UPLOAD_PATH = "";
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EmailSenderServlet() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	UPLOAD_PATH = getServletContext().getInitParameter("upload");
    	
    	File mkdirIfNoExist = new File(UPLOAD_PATH);
    	
    	if (!mkdirIfNoExist.exists()) {
    		mkdirIfNoExist.mkdirs();
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
		
		String to = request.getParameter("to");
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		
		Part part = request.getPart("file");
		
		Path filePath = Paths.get( UPLOAD_PATH + File.separatorChar + part.getSubmittedFileName());
		
		Files.copy(part.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
		
		
		try {
			EmailUtils.sendMail(to, title, body, filePath.toString());
			response.getWriter().append("OK!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.getWriter().append("Error!");
			e.printStackTrace();
		}
				
		
	}

}
