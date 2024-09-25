package enitities;

public class DeTai {
	private String maDT, tenDT, moTaDeTai;
	private int namDangKy;
	private GiangVien gv;
	public DeTai() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaDT() {
		return maDT;
	}
	public void setMaDT(String maDT) {
		this.maDT = maDT;
	}
	public String getTenDT() {
		return tenDT;
	}
	public void setTenDT(String tenDT) {
		this.tenDT = tenDT;
	}
	public String getMoTaDeTai() {
		return moTaDeTai;
	}
	public void setMoTaDeTai(String moTaDeTai) {
		this.moTaDeTai = moTaDeTai;
	}
	public int getNamDangKy() {
		return namDangKy;
	}
	public void setNamDangKy(int namDangKy) {
		this.namDangKy = namDangKy;
	}
	public GiangVien getGv() {
		return gv;
	}
	public void setGv(GiangVien gv) {
		this.gv = gv;
	}
	public DeTai(String maDT, String tenDT, String moTaDeTai, int namDangKy, GiangVien gv) {
		super();
		this.maDT = maDT;
		this.tenDT = tenDT;
		this.moTaDeTai = moTaDeTai;
		this.namDangKy = namDangKy;
		this.gv = gv;
	}
	@Override
	public String toString() {
		return "DeTai [maDT=" + maDT + ", tenDT=" + tenDT + ", moTaDeTai=" + moTaDeTai + ", namDangKy=" + namDangKy
				+ ", gv=" + gv + "]";
	}
	
	
}
