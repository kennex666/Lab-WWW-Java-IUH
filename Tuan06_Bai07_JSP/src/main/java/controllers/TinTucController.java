package controllers;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.sql.DataSource;

import dao.DanhSachTinTucQuanLy;
import daoimpl.DanhSachTinTucQL_Impl;
import entities.DanhMuc;
import entities.TinTuc;

/**
 * Servlet implementation class TinTucController
 */
public class TinTucController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name = "sqlserver")
	private DataSource dsrc;
	
	private DanhSachTinTucQuanLy ds_dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TinTucController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	ds_dao = new DanhSachTinTucQL_Impl(dsrc);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String action = request.getParameter("action") == null ||request.getParameter("action").isBlank() ? "" : request.getParameter("action");


		
		switch (action) {
		case "addTT":
			request.getRequestDispatcher("views/form.jsp").forward(request, response);
			break;

		case "remove":
			String maTT = request.getParameter("maTT");
			ds_dao.removeTinTuc(maTT);
			request.setAttribute("isEditMode", "yes");
			request.setAttribute("listDanhMuc", ds_dao.getAllDanhMuc());
			request.getRequestDispatcher("views/danhsach.jsp").forward(request, response);
			break;
		
		case "editMode":
			request.setAttribute("isEditMode", "yes");
			request.setAttribute("listDanhMuc", ds_dao.getAllDanhMuc());

			request.getRequestDispatcher("views/danhsach.jsp").forward(request, response);
			break;
		default:
			request.setAttribute("listDanhMuc", ds_dao.getAllDanhMuc());
			request.getRequestDispatcher("views/danhsach.jsp").forward(request, response);
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPOST");
	
		String action = request.getParameter("action") == null || request.getParameter("action").isBlank() ? "" : request.getParameter("action");
		
		switch (action) {
		case "addTT":
			doPostAddTT(request, response);
			break;
		default:
			request.setAttribute("listDanhMuc", ds_dao.getAllDanhMuc());
			request.getRequestDispatcher("views/danhsach.jsp").forward(request, response);
			break;
		}
		
	}

	public void doPostAddTT(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DO POST");
		String maTT = request.getParameter("maTT");
		String tieuDe = request.getParameter("tieuDe");
		String noiDungTT = request.getParameter("noiDungTT");
		String lienKet = request.getParameter("lienKet");
		String maDM = request.getParameter("maDM");
		
		DanhMuc dm = new DanhMuc();
		dm.setMaDM(maDM);
		
		boolean result = ds_dao.addTinTuc(new TinTuc(maTT, tieuDe, noiDungTT, lienKet, dm));
		
		if (result){
			request.setAttribute("listDanhMuc", ds_dao.getAllDanhMuc());
			request.getRequestDispatcher("views/danhsach.jsp").forward(request, response);
		}
		else {
			request.setAttribute("error", "ok");
			request.getRequestDispatcher("views/form.jsp").forward(request, response);
		}
	}
}
