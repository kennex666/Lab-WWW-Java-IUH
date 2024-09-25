package fit.iuh.controllers;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;

import fit.iuh.dao.ProductDAO;
import fit.iuh.daoimpl.ProductDAO_Impl;
import fit.iuh.entities.ItemCart;
import fit.iuh.entities.Product;

/**
 * Servlet implementation class CartController
 */
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/sqlserver")
	private DataSource datasource;
	
	private ProductDAO productDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	try {
			System.out.println(datasource.getConnection());
			productDao = new ProductDAO_Impl(datasource);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getParameter("action") != null ? request.getParameter("action") : "default";
		
		switch (action) {
		case "buy": {
			doGetBuyAction(request, response);
			break;
		}
		case "remove": {
			break;
		}
		default:
			doGetDisplayCart(request, response);
			break;
		}
	}
	
	private void doGetBuyAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		HashMap<Integer, ItemCart> list = null;
		
		int idProduct = -1;
		
		try {
			idProduct = Integer.parseInt((String) request.getAttribute("id"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if (session.getAttribute("cart") == null) {
			list = new LinkedHashMap<Integer, ItemCart>();
		}else {
			list = (LinkedHashMap<Integer, ItemCart>) session.getAttribute("cart");
		}
		
		ItemCart prdTemp = list.get(idProduct);
		
		Product pd = productDao.getByID(idProduct);
		if (prdTemp == null) {
			prdTemp = new ItemCart(pd, 1);
			list.put(idProduct, prdTemp);
		} else {
			prdTemp.setQuantity(prdTemp.getQuantity() + 1);
			list.replace(idProduct, prdTemp);
		}
		
		session.setAttribute("cart", list);
		
		response.sendRedirect("cart");
		// TODO Auto-generated method stub

	}
	
	private void doGetDisplayCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("views/cart.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
