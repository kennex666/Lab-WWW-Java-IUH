package entities;

public class NhaCungCap {
	private String maNCC, tenNhaCC, diaChi, soDienThoai;

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	public String getTenNhaCC() {
		return tenNhaCC;
	}

	public void setTenNhaCC(String tenNhaCC) {
		this.tenNhaCC = tenNhaCC;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	
	
	public NhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhaCungCap(String maNCC, String tenNhaCC, String diaChi, String soDienThoai) {
		super();
		this.maNCC = maNCC;
		this.tenNhaCC = tenNhaCC;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	@Override
	public String toString() {
		return "NhaCungCap [maNCC=" + maNCC + ", tenNhaCC=" + tenNhaCC + ", diaChi=" + diaChi + ", soDienThoai="
				+ soDienThoai + "]";
	}
	
	
}
