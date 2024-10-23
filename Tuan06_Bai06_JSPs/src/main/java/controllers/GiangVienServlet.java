package controllers;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import dao.DetailsDAO;
import daoimpl.DetailsDAO_Impl;
import enitities.DeTai;
import enitities.GiangVien;

/**
 * Servlet implementation class GiangVienServlet
 */
public class GiangVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="sqlserver")
	private DataSource dsrc;
	
	private DetailsDAO dtDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiangVienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	dtDAO = new DetailsDAO_Impl(dsrc);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String pathName = request.getContextPath();
		String action = (request.getParameter("action") == null) || request.getParameter("action").isBlank() ? "" : request.getParameter("action"); 
		
		
		switch (action) {
		case "addGV":
			doGetAddGiangVien(request, response);
			break;

		case "addDT":
			doGetAddDeTai(request, response);
			break;
		default:
			doGetListGiangVien(request, response);
			break;
		}
	}
	
	public void doGetListGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<GiangVien> giangViens = dtDAO.getAllGiangVien();
		
		request.setAttribute("listGiangVien", giangViens);
		request.getRequestDispatcher("views/listGiangVien.jsp").forward(request, response);
	}
	
	public void doGetAddGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/themGiangVien.jsp").forward(request, response);
	}
	public void doGetAddDeTai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/themDeTai.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getParameter("action");
	    System.out.println("DO POST Action: " + action); // Xem action có nhận được không

	    switch (action) {
	        case "addGV":
	            doPostAddGiangVien(request, response);
	            break;

	        case "addDT":
	            doPostAddDeTai(request, response);
	            break;
	        default:
	            System.out.println("No valid action, redirecting to doGet.");
	            doGet(request, response); // Redirect nếu không có action phù hợp
	            break;
	    }
	}


	public void doPostAddGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maGV = request.getParameter("facultyID");
		String tenGV = request.getParameter("fullName");
		String linhVucNghienCuu = request.getParameter("researchArea");
		String soDT = request.getParameter("phoneNumber");
		GiangVien gv = new GiangVien(maGV, tenGV, linhVucNghienCuu, soDT);
		boolean result = dtDAO.addGiangVien(gv);
		if (result) {
			request.setAttribute("success", "ok");
			request.getRequestDispatcher("views/themGiangVien.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "ok");
			request.getRequestDispatcher("views/themGiangVien.jsp").forward(request, response);
		}
		System.out.println("Do POST");
	}
	
	public void doPostAddDeTai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maDT = request.getParameter("MaDT");
		String tenDT = request.getParameter("TenDT");
		int namDangKy = Integer.parseInt(request.getParameter("NamDangKy"));
		String moTa = request.getParameter("MoTa");
		String maGV = request.getParameter("MaGV");
		GiangVien gv = new GiangVien();
		gv.setMaGV(maGV);
		
		DeTai dt = new DeTai(maDT, tenDT, moTa, namDangKy, gv);
		
		boolean result = dtDAO.addDeTai(dt);
		if (result) {
			request.setAttribute("success", "ok");
			request.getRequestDispatcher("views/themDeTai.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "ok");
			request.getRequestDispatcher("views/themDeTai.jsp").forward(request, response);
		}
		System.out.println("Do POST");
	}
}
