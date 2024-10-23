package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dao.DanhSachTinTucQuanLy;
import entities.DanhMuc;
import entities.TinTuc;

public class DanhSachTinTucQL_Impl implements DanhSachTinTucQuanLy {
	private DataSource src;
	
	
	public DanhSachTinTucQL_Impl(DataSource src) {
		super();
		this.src = src;
	}

	@Override
	public List<TinTuc> getAllTinTuc() {
		// TODO Auto-generated method stub
		List<TinTuc> tinTucs = new ArrayList<TinTuc>();
		try {
			String query = "SELECT * FROM TinTuc";
			Connection conn = src.getConnection();
			
			Statement stm = conn.createStatement();
			
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()){
				String maTT = rs.getString("maTT");
				String tieuDe = rs.getString("tieuDe");
				String noiDungTT = rs.getString("noiDungTT");
				String lienKet = rs.getString("lienKet");
				DanhMuc dm = new DanhMuc();
				dm.setMaDM(rs.getString("maDM"));
				TinTuc temp = new TinTuc(maTT, tieuDe, noiDungTT, lienKet, dm);
				tinTucs.add(temp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tinTucs;
	}
	
	@Override
	public List<TinTuc> getTinTucTheoDM(String maDM) {
		// TODO Auto-generated method stub
		List<TinTuc> tinTucs = new ArrayList<TinTuc>();
		try {
			String query = "SELECT * FROM TinTuc WHERE maDM = ?";
			Connection conn = src.getConnection();
			
			PreparedStatement stm = conn.prepareStatement(query);
			
			stm.setString(1, maDM);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()){
				String maTT = rs.getString("maTT");
				String tieuDe = rs.getString("tieuDe");
				String noiDungTT = rs.getString("noiDungTT");
				String lienKet = rs.getString("lienKet");
				DanhMuc dm = new DanhMuc();
				dm.setMaDM(rs.getString("maDM"));
				TinTuc temp = new TinTuc(maTT, tieuDe, noiDungTT, lienKet, dm);
				tinTucs.add(temp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tinTucs;
	}
	
	
	@Override
	public List<DanhMuc> getAllDanhMuc() {
		// TODO Auto-generated method stub
		List<DanhMuc> danhMucs = new ArrayList<DanhMuc>();
		try {
			String query = "SELECT * FROM DanhMuc";
			Connection conn = src.getConnection();
			
			Statement stm = conn.createStatement();
			
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()){
				String maDM = rs.getString("maDM");
				String tenDM = rs.getString("tenDanhMuc");
				String nguoiQL = rs.getString("nguoiQuanLy");
				String ghiChu = rs.getString("ghiChu");
				DanhMuc dm = new DanhMuc(maDM, tenDM, nguoiQL, ghiChu, getTinTucTheoDM(maDM));
				danhMucs.add(dm);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return danhMucs;
	}

	@Override
	public boolean addTinTuc(TinTuc tinTuc) {
		// TODO Auto-generated method stub
		try {
			String query = "INSERT INTO TinTuc (maTT, tieuDe, noiDungTT, lienKet, maDM) VALUES (?, ?, ?, ?, ?)";
			Connection conn = src.getConnection();
			
			PreparedStatement stm = conn.prepareStatement(query);

			stm.setString(1, tinTuc.getMaTT());
			stm.setString(2, tinTuc.getTieuDe());
			stm.setString(3, tinTuc.getNoiDungTT());
			stm.setString(4, tinTuc.getLienKet());
			stm.setString(5, tinTuc.getDm().getMaDM());

			stm.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeTinTuc(String maTinTuc) {
		// TODO Auto-generated method stub
		try {
			String query = "DELETE FROM TinTuc WHERE maTT = ?";
			Connection conn = src.getConnection();
			
			PreparedStatement stm = conn.prepareStatement(query);

			stm.setString(1, maTinTuc);
			stm.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
