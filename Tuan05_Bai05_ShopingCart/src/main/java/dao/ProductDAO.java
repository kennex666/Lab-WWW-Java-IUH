package dao;

import java.util.List;

import entities.Product;

public interface ProductDAO {
	public List<Product> getAllProduct();

	public Product getProductById(String id);

	public List<Product> getProductByName(String name);
}
