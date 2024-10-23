package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dao.DanhSachDienThoaiQuanLy;
import entities.DienThoai;
import entities.NhaCungCap;

public class DanhSachDienThoaiQuanLy_Impl implements DanhSachDienThoaiQuanLy {
	
	
	
	public DanhSachDienThoaiQuanLy_Impl(DataSource ds) {
		super();
		this.ds = ds;
	}

	private DataSource ds;

	@Override
	public List<DienThoai> laySanPhamTheoMaNCC(String ma) {
		List<DienThoai> list = new ArrayList<DienThoai>();
		try {
			Connection conn = ds.getConnection();
			String query = "SELECT * FROM DienThoai WHERE maNCC = ?";

			PreparedStatement pstm = conn.prepareStatement(query);
			
			pstm.setString(1, ma);
			
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				String maDT = rs.getString("maDT");
				String tenDT = rs.getString("tenDT");
				int namSanXuat = rs.getInt("namSanXuat");
				String cauHinh = rs.getString("cauHinh");
				NhaCungCap ncc = new NhaCungCap();
				
				ncc.setMaNCC(rs.getString("maNCC"));
				
				DienThoai dt = new DienThoai(maDT, tenDT, namSanXuat, cauHinh, ncc);
				
				list.add(dt);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public boolean themMoiDienThoai(DienThoai dt) {
		// TODO Auto-generated method stub
		try {
			Connection conn = ds.getConnection();
			String query = "INSERT INTO DienThoai(maDT, tenDT, namSanXuat, cauHinh, maNCC) VALUES (?, ?, ?, ?, ?)";

			PreparedStatement pstm = conn.prepareStatement(query);
			
			pstm.setString(1, dt.getMaDT());
			pstm.setString(2, dt.getTenDT());
			pstm.setInt(3, dt.getNamSanXuat());
			pstm.setString(4, dt.getCauHinh());
			pstm.setString(5, dt.getNhaCungCap().getMaNCC());
			
			pstm.execute();
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean xoaDienThoai(String maDT) {
		// TODO Auto-generated method stub
		try {
			Connection conn = ds.getConnection();
			String query = "DELETE FROM DienThoai WHERE maDT = ?";

			PreparedStatement pstm = conn.prepareStatement(query);
			
			pstm.setString(1, maDT);
			
			pstm.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
