package dao;

import java.util.List;

import entities.DanhMuc;
import entities.TinTuc;

public interface DanhSachTinTucQuanLy {
	public List<TinTuc> getAllTinTuc();
	public boolean addTinTuc(TinTuc tinTuc);
	public boolean removeTinTuc(String maTinTuc);
	public List<DanhMuc> getAllDanhMuc();
	public List<TinTuc> getTinTucTheoDM(String maDM);
}
