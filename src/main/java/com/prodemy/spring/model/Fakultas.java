package com.prodemy.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "fakultas")
public class Fakultas {
	@Id
	@Column(name = "fk_id")
	
	@SequenceGenerator(name="pk_fakultas", sequenceName="fakultas_mhs_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pk_fakultas")
	
	private int id;
	
	@Column(name = "fk_kode")
	private String kode;
	
	@Column(name = "fk_nama")
	private String name;
	
	@Column (name = "fk_dekan")
	private String dekan;
}