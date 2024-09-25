package enitities;

import java.util.List;

public class GiangVien {
	private String maGV, tenGV, linhVucNghienCuu, soDT;
	private List<DeTai> detais; 

	public String getMaGV() {
		return maGV;
	}

	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}

	public String getTenGV() {
		return tenGV;
	}

	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
	}

	public String getLinhVucNghienCuu() {
		return linhVucNghienCuu;
	}

	public void setLinhVucNghienCuu(String linhVucNghienCuu) {
		this.linhVucNghienCuu = linhVucNghienCuu;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	

	public GiangVien(String maGV, String tenGV, String linhVucNghienCuu, String soDT, List<DeTai> detais) {
		super();
		this.maGV = maGV;
		this.tenGV = tenGV;
		this.linhVucNghienCuu = linhVucNghienCuu;
		this.soDT = soDT;
		this.detais = detais;
	}

	public List<DeTai> getDetais() {
		return detais;
	}

	public void setDetais(List<DeTai> detais) {
		this.detais = detais;
	}

	public GiangVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiangVien(String maGV, String tenGV, String linhVucNghienCuu, String soDT) {
		super();
		this.maGV = maGV;
		this.tenGV = tenGV;
		this.linhVucNghienCuu = linhVucNghienCuu;
		this.soDT = soDT;
	}

	@Override
	public String toString() {
		return "GiangVien [maGV=" + maGV + ", tenGV=" + tenGV + ", linhVucNghienCuu=" + linhVucNghienCuu + ", soDT="
				+ soDT + "]";
	}
	
	
}
