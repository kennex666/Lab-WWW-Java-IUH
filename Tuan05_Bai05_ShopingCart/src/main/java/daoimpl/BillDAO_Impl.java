package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import dao.BillDAO;
import entities.Bill;

public class BillDAO_Impl implements BillDAO {
	private DataSource dsrc; 
	
	
	
	public BillDAO_Impl(DataSource dsrc) {
		super();
		this.dsrc = dsrc;
	}




	@Override
	public boolean addNewBill(Bill bill) {
		try (Connection conn = dsrc.getConnection()){
			String query = "INSERT INTO Bill(FullName, Address, Price, Payment) VALUES(?, ?, ?, ?)";
			PreparedStatement pstm = conn.prepareStatement(query);

			pstm.setNString(1, bill.getFullname());
			pstm.setNString(2, bill.getAddress());
			pstm.setDouble(3, bill.getTotalPrice());
			pstm.setNString(4, bill.getPayment());
			
			pstm.execute();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}

}
