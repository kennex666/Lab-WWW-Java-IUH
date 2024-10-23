package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;

import dao.BillDAO;
import dao.ProductDAO;
import daoimpl.BillDAO_Impl;
import daoimpl.ProductDAO_Impl;
import entities.Bill;
import entities.Cart;
import entities.CartItem;
import entities.Product;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ProductController
 */
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/sqlserver")
	private DataSource datasource;

	private ProductDAO prdDAOImpl;
	
	private BillDAO billDaoImp;

	/**
	 * Default constructor.
	 */

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();

		try {
			System.out.println(datasource.getConnection());
			prdDAOImpl = new ProductDAO_Impl(datasource);
			billDaoImp = new BillDAO_Impl(datasource);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public CartController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") == null ? "" : request.getParameter("action");
		switch (action) {
		case "add": {
			doGetBuy(request, response);
			break;
		}
		case "remove": {
			doGetRemove(request, response);
			break;
		}
		case "next":{
			doGetThanhToan(request, response);
			break;
		}
		default:
			request.getRequestDispatcher("/views/GioHang.jsp").forward(request, response);
		}
	}
	
	public void doGetThanhToan(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		
		
		Cart list = (Cart) session.getAttribute("cart");
		
		if (list == null || list.getTotalItems() == 0) {
			request.setAttribute("payStatus", "Error: Không có gì trong giỏ hàng để thanh toán!!");
			request.getRequestDispatcher("/views/GioHang.jsp").forward(request, response);
			return;
		}
		
		session.setAttribute("cart", list);

		request.getRequestDispatcher("/views/ThanhToan.jsp").forward(request, response);
	}
	
	public void doGetBuy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		String idProduct = (String) request.getParameter("id");
		
		Product prd = prdDAOImpl.getProductById(idProduct);
		
		if (prd == null) {
			response.sendError(404, "Sản phẩm " + idProduct + " không tồn tại!");
			return;
		}
		
		Cart list = (Cart) session.getAttribute("cart");
		
		if (list == null) {
			list = new Cart();
			list.addItem(prd);
		} else {
			list.addItem(prd);
		}
		
		session.setAttribute("cart", list);
		
		response.sendRedirect("cart");
	}
	
	public void doGetRemove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		String idProduct = (String) request.getParameter("id");
		
		Product prd = prdDAOImpl.getProductById(idProduct);
		
		if (prd == null) {
			response.sendError(404, "Sản phẩm " + idProduct + " không tồn tại!");
			return;
		}
		
		Cart list = (Cart) session.getAttribute("cart");
		
		if (list != null) {
			list.removeItem(idProduct);
		}
		
		session.setAttribute("cart", list);
		
		response.sendRedirect("cart");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") == null ? "" : request.getParameter("action");
		HttpSession session = request.getSession();
		
		if (!action.equalsIgnoreCase("pay")) {
			doGet(request, response);
			return;
		}
		
		Cart list = (Cart) session.getAttribute("cart");
		if (list == null || list.getTotalItems() == 0) {
			request.setAttribute("payStatus", "Error: Không có gì trong giỏ hàng để thanh toán!!");
			request.getRequestDispatcher("/views/GioHang.jsp").forward(request, response);
			return;
		}
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		double price = 0;
		try {
			String temp = request.getParameter("price");
			price = Double.parseDouble(temp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String payment = request.getParameter("payment");
		
		
		
		boolean result = billDaoImp.addNewBill(new Bill(name, address, price, payment));
		
		if (result) {
			request.setAttribute("success", "OK");
			request.setAttribute("payStatus", "Thanh toán thành công!");
		} else {
			request.setAttribute("payStatus", "Thất bại: Lỗi cơ sở dữ liệu!");
		}
		
		list = new Cart();
		
		session.setAttribute("cart", list);

		request.getRequestDispatcher("/views/GioHang.jsp").forward(request, response);
	}

}
