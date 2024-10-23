package dao;

import java.util.List;

import enitities.DeTai;
import enitities.GiangVien;

public interface DetailsDAO {
	public List<GiangVien> getAllGiangVien();
	
	public List<DeTai> getDeTaiTheoMGV(String maGV);
	
	public boolean addGiangVien(GiangVien gv);
	
	public boolean addDeTai(DeTai dt);
}
