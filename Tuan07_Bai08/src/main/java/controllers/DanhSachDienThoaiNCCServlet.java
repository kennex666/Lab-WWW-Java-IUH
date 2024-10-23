package controllers;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.sql.DataSource;

import dao.DanhSachDienThoaiQuanLy;
import dao.impl.DanhSachDienThoaiQuanLy_Impl;

/**
 * Servlet implementation class DanhSachDienThoaiNCCServlet
 */
public class DanhSachDienThoaiNCCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "sqlserver")
	private DataSource dsrc;
	
	private DanhSachDienThoaiQuanLy ds_dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachDienThoaiNCCServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	
    	ds_dao = new DanhSachDienThoaiQuanLy_Impl(dsrc);
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		request.setAttribute("list", ds_dao.laySanPhamTheoMaNCC("NCC1"));
		
		System.out.println(ds_dao.laySanPhamTheoMaNCC("NCC1"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
