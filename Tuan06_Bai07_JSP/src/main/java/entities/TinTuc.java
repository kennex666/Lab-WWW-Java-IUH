package entities;

public class TinTuc {
	private String maTT;
	
	private String tieuDe, noiDungTT, lienKet;
	
	DanhMuc dm;

	public String getMaTT() {
		return maTT;
	}

	public void setMaTT(String maTT) {
		this.maTT = maTT;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getNoiDungTT() {
		return noiDungTT;
	}

	public void setNoiDungTT(String noiDungTT) {
		this.noiDungTT = noiDungTT;
	}

	public String getLienKet() {
		return lienKet;
	}

	public void setLienKet(String lienKet) {
		this.lienKet = lienKet;
	}

	public DanhMuc getDm() {
		return dm;
	}

	public void setDm(DanhMuc dm) {
		this.dm = dm;
	}

	public TinTuc(String maTT, String tieuDe, String noiDungTT, String lienKet, DanhMuc dm) {
		super();
		this.maTT = maTT;
		this.tieuDe = tieuDe;
		this.noiDungTT = noiDungTT;
		this.lienKet = lienKet;
		this.dm = dm;
	}

	public TinTuc(String maTT, String tieuDe, String noiDungTT, String lienKet) {
		super();
		this.maTT = maTT;
		this.tieuDe = tieuDe;
		this.noiDungTT = noiDungTT;
		this.lienKet = lienKet;
	}

	public TinTuc() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TinTuc [maTT=" + maTT + ", tieuDe=" + tieuDe + ", noiDungTT=" + noiDungTT + ", lienKet=" + lienKet
				+ ", dm=" + dm + "]";
	}
	
}
