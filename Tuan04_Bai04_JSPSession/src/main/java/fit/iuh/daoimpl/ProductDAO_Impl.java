package fit.iuh.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;

import fit.iuh.dao.ProductDAO;
import fit.iuh.entities.Product;

public class ProductDAO_Impl implements ProductDAO {

	private DataSource dataSrc;
	
	public ProductDAO_Impl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDAO_Impl(DataSource dataSrc) {
		super();
		this.dataSrc = dataSrc;
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM Products";
		List<Product> list = new ArrayList<Product>();
		try {
			Connection conn = dataSrc.getConnection();

			Statement stm = conn.createStatement();
			
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				Product pdTemp = new Product(rs.getInt("id"), rs.getString("name"), rs.getString("price") , rs.getDouble("image"));
				list.add(pdTemp);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Product getByID(int id) {String query = "SELECT * FROM Products";
		try {
			Connection conn = dataSrc.getConnection();
	
			Statement stm = conn.createStatement();
			
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				Product pdTemp = new Product(rs.getInt("id"), rs.getString("name"), rs.getString("price") , rs.getDouble("image"));
				return pdTemp;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
