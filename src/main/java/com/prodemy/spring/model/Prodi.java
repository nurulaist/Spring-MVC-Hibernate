package com.prodemy.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "PRODI")
public class Prodi {

	@Id
	@SequenceGenerator(name="pk_prodi", sequenceName="prodi_pr_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pk_prodi")
	@Column(name = "pr_id")
	private int id;
	
	@Column(name = "pr_kode")
	private String kode;
	
	@Column(name = "pr_nama")
	private String nama;
	
	@Column(name = "pr_kaprodi")
	private String kaprodi;
	
	@SequenceGenerator(name="pk_fakultas", sequenceName="fakultas_fk_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pk_fakultas")
	@Column(name = "fk_id")
	private int fkid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKode() {
		return kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getKaprodi() {
		return kaprodi;
	}

	public void setKaprodi(String kaprodi) {
		this.kaprodi = kaprodi;
	}

	public int getFkid() {
		return fkid;
	}

	public void setFkid(int fkid) {
		this.fkid = fkid;
	}

	@Override
	public String toString() {
		return "Prodi [id=" + id + ", kode=" + kode + ", nama=" + nama + ", kaprodi=" + kaprodi + ", fkid=" + fkid
				+ "]";
	}
	
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
		Prodi other = (Prodi) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}