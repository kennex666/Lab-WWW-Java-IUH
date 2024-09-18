package fit.iuh.daoimpl;

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
		return null;
	}

}
