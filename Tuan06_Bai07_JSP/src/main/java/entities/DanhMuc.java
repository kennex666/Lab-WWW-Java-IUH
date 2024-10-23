package entities;

import java.util.List;

public class DanhMuc {
	private String maDM;
	private String tenDanhMuc, nguoiQuanLy, ghiChu;
	
	private List<TinTuc> tinTucs;
	
	public DanhMuc(String maDM, String tenDanhMuc, String nguoiQuanLy, String ghiChu, List<TinTuc> tinTucs) {
		super();
		this.maDM = maDM;
		this.tenDanhMuc = tenDanhMuc;
		this.nguoiQuanLy = nguoiQuanLy;
		this.ghiChu = ghiChu;
		this.tinTucs = tinTucs;
	}
	public List<TinTuc> getTinTucs() {
		return tinTucs;
	}
	public void setTinTucs(List<TinTuc> tinTucs) {
		this.tinTucs = tinTucs;
	}
	public String getMaDM() {
		return maDM;
	}
	public void setMaDM(String maDM) {
		this.maDM = maDM;
	}
	public String getTenDanhMuc() {
		return tenDanhMuc;
	}
	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}
	public String getNguoiQuanLy() {
		return nguoiQuanLy;
	}
	public void setNguoiQuanLy(String nguoiQuanLy) {
		this.nguoiQuanLy = nguoiQuanLy;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public DanhMuc(String maDM, String tenDanhMuc, String nguoiQuanLy, String ghiChu) {
		super();
		this.maDM = maDM;
		this.tenDanhMuc = tenDanhMuc;
		this.nguoiQuanLy = nguoiQuanLy;
		this.ghiChu = ghiChu;
	}
	public DanhMuc() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DanhMuc [maDM=" + maDM + ", tenDanhMuc=" + tenDanhMuc + ", nguoiQuanLy=" + nguoiQuanLy + ", ghiChu="
				+ ghiChu + "]";
	}
	
	
}
