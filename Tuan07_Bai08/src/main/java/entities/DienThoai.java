package entities;

public class DienThoai {
	private String maDT, tenDT, cauHinh;
	
	private int namSanXuat;
	
	private NhaCungCap nhaCungCap;
	
	

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

	public String getCauHinh() {
		return cauHinh;
	}

	public void setCauHinh(String cauHinh) {
		this.cauHinh = cauHinh;
	}

	public int getNamSanXuat() {
		return namSanXuat;
	}

	public void setNamSanXuat(int namSanXuat) {
		this.namSanXuat = namSanXuat;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public DienThoai(String maDT, String tenDT, int namSanXuat, String cauHinh, NhaCungCap nhaCungCap) {
		super();
		this.maDT = maDT;
		this.tenDT = tenDT;
		this.namSanXuat = namSanXuat;
		this.cauHinh = cauHinh;
		this.nhaCungCap = nhaCungCap;
	}

	public DienThoai() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DienThoai(String maDT, String tenDT, int namSanXuat, String cauHinh) {
		super();
		this.maDT = maDT;
		this.tenDT = tenDT;
		this.namSanXuat = namSanXuat;
		this.cauHinh = cauHinh;
	}

	@Override
	public String toString() {
		return "DienThoai [maDT=" + maDT + ", tenDT=" + tenDT + ", namSanXuat=" + namSanXuat + ", cauHinh=" + cauHinh
				+ ", nhaCungCap=" + nhaCungCap + "]";
	}
	
	
	
}
