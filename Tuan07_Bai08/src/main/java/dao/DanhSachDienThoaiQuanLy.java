package dao;

import java.util.List;

import entities.DienThoai;

public interface DanhSachDienThoaiQuanLy {
	public List<DienThoai> laySanPhamTheoMaNCC(String ma);
	
	public boolean themMoiDienThoai(DienThoai dt);
	
	public boolean xoaDienThoai(String maDT);
}
