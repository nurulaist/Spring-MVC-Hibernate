package com.prodemy.spring.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.prodemy.spring.model.Mahasiswa;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "MAHASISWA")
public class Mahasiswa {
	@Id
	@Column(name = "mhs_id")
	@SequenceGenerator(name = "pk_mahasiswa", sequenceName = "mahasiswa_mhs_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_mahasiswa")
	private int id;

	@Column(name = "mhs_nim")
	private String nim;

	@Column(name = "mhs_nama")
	private String name;

	@Column(name = "mhs_alamat")
	private String alamat;

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getNim() {
//		return nim;
//	}
//
//	public void setNim(String nim) {
//		this.nim = nim;
//	}
//
//	public String getNama() {
//		return nama;
//	}
//
//	public void setNama(String nama) {
//		this.nama = nama;
//	}
//
//	public String getAlamat() {
//		return alamat;
//	}
//
//	public void setAlamat(String alamat) {
//		this.alamat = alamat;
//	}

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(
			name = "prodi_member",
			joinColumns = { @JoinColumn(name = "mhs_id") },
			inverseJoinColumns = {@JoinColumn(name = "pr_id") })
	private Set<Prodi> prodi;

	@Override
	public String toString() {
		return "Mahasiswa [id=" + id + ", nim=" + nim + ", nama=" + name + ", alamat=" + alamat + "]";
	}

//	public Set<Prodi> getProdi() {
//		return prodi;
//	}
//
//	public void setProdi(Set<Prodi> prodi) {
//		this.prodi = prodi;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mahasiswa other = (Mahasiswa) obj;
		if (id != other.id)
			return false;
		return true;
	}

}