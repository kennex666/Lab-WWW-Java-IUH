package fit.iuh.dao;

import java.util.List;

import fit.iuh.entities.Product;

public interface ProductDAO {
	public List<Product> getAllProduct();
	
	public Product getByID(int id);
}
