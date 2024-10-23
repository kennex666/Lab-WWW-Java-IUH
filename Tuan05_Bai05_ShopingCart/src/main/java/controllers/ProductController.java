package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;

import dao.ProductDAO;
import daoimpl.ProductDAO_Impl;
import entities.Product;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/sqlserver")
	private DataSource datasource;

	private ProductDAO prdDAOImpl;

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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ProductController() {
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
		case "search": {
			doGetSearch(request, response);
			break;
		}
		case "details": {
			doGetDetails(request, response);
			break;
		}
		default:
			List<Product> list = prdDAOImpl.getAllProduct();
			request.setAttribute("products", list);
			request.getRequestDispatcher("/views/TrangChu.jsp").forward(request, response);
		}
	}
	
	private void doGetSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String query = (String) request.getParameter("q");
		
		List<Product> list = prdDAOImpl.getProductByName(query);
		
		request.setAttribute("products", list);
		request.setAttribute("searchQuery", query);
		request.getRequestDispatcher("/views/TrangChu.jsp").forward(request, response);
	}
	
	private void doGetDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String query = (String) request.getParameter("id");
		
		List<Product> list = new ArrayList<Product>();

		Product prd = prdDAOImpl.getProductById(query);
		
		if (prd != null)
			list.add(prd);
		
		request.setAttribute("products", list);
		request.setAttribute("backToProductList", true);
		
		request.getRequestDispatcher("/views/TrangChu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
