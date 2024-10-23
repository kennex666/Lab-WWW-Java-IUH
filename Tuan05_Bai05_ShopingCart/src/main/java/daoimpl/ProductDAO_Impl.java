package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dao.ProductDAO;
import entities.Product;

public class ProductDAO_Impl implements ProductDAO {
	private DataSource datasrc;

	public ProductDAO_Impl(DataSource datasrc) {
		super();
		this.datasrc = datasrc;
	}

	public ProductDAO_Impl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		List<Product> list = new ArrayList<Product>();
		String query = "SELECT * FROM Products";
		try (Connection conn = datasrc.getConnection()) {
			Statement stm = conn.createStatement();

			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				String maSP = rs.getNString("maSP");
				String tenSP = rs.getNString("tenSP");
				String image = rs.getNString("imgPath");
				int quantity = rs.getInt("soLuong");
				double price = rs.getDouble("gia");

				Product prd = new Product(maSP, tenSP, image, quantity, price);

				list.add(prd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Product getProductById(String id) {
		// TODO Auto-generated method stub
		Product prd = null;

		String query = "SELECT * FROM Products WHERE maSP = ?";
		try (Connection conn = datasrc.getConnection()) {
			PreparedStatement pstm = conn.prepareStatement(query);

			pstm.setString(1, id);
			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {
				String maSP = rs.getNString("maSP");
				String tenSP = rs.getNString("tenSP");
				String image = rs.getNString("imgPath");
				double price = rs.getDouble("gia");
				int quantity = rs.getInt("soLuong");

				prd = new Product(maSP, tenSP, image, quantity, price);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prd;
	}

	@Override
	public List<Product> getProductByName(String name) {// TODO Auto-generated method stub
		List<Product> list = new ArrayList<Product>();
		String query = "SELECT * FROM Products WHERE tenSP LIKE CONCAT('%', ?, '%')";
		try (Connection conn = datasrc.getConnection()) {
			PreparedStatement pstm = conn.prepareStatement(query);

			pstm.setString(1, name);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				String maSP = rs.getNString("maSP");
				String tenSP = rs.getNString("tenSP");
				String image = rs.getNString("imgPath");
				int quantity = rs.getInt("soLuong");
				double price = rs.getDouble("gia");

				Product prd = new Product(maSP, tenSP, image, quantity, price);

				list.add(prd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
