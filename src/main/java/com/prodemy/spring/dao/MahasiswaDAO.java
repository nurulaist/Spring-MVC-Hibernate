package com.prodemy.spring.dao;

import java.util.List;
import com.prodemy.spring.model.Mahasiswa;

public interface MahasiswaDAO {
	public void addMahasiswa(Mahasiswa p);
	public void updateMahasiswa(Mahasiswa p);
	public List<Mahasiswa> listMahasiswa();
	public Mahasiswa getMahasiswaById(int id);
	public void removeMahasiswa(int id);
}
