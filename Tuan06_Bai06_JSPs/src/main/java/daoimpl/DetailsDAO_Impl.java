package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dao.DetailsDAO;
import enitities.DeTai;
import enitities.GiangVien;

public class DetailsDAO_Impl implements DetailsDAO {
	private DataSource dsrc;

	@Override
	public List<DeTai> getDeTaiTheoMGV(String maGV) {
		// TODO Auto-generated method stub
		List<DeTai> list = new ArrayList<DeTai>();
		try {
			Connection conn = dsrc.getConnection();

			String query = "SELECT * FROM DeTai dt WHERE maGV = ?";

			PreparedStatement pstm = conn.prepareStatement(query);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				String maDT = rs.getString("maDT");
				String tenDT = rs.getString("TenDT");
				String moTaDeTai = rs.getString("moTaDeTai");
				int namDangKy = rs.getInt("namDangKy");
				GiangVien gv = new GiangVien();
				gv.setMaGV(maGV);
				DeTai dt = new DeTai(maDT, tenDT, moTaDeTai, namDangKy, gv);
				list.add(dt);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<GiangVien> getAllGiangVien() {
		// TODO Auto-generated method stub
		List<GiangVien> list = new ArrayList();
		try {
			Connection conn = dsrc.getConnection();

			String query = "SELECT * FROM GiangVien gv";

			Statement stm = conn.createStatement();

			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				String maGV = rs.getString("MaGV");
				String tenGV = rs.getString("TenGV");
				String linhVucNghienCuu = rs.getString("LinhVucNghienCuu");
				String soDienThoai = rs.getString("SoDienThoai");
				List<DeTai> listDeTai = getDeTaiTheoMGV(maGV);
				
				GiangVien gv = new GiangVien(maGV, tenGV, linhVucNghienCuu, soDienThoai, listDeTai);
				list.add(gv);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean addGiangVien(GiangVien gv) {
		// TODO Auto-generated method stub
		return false;
	}

}