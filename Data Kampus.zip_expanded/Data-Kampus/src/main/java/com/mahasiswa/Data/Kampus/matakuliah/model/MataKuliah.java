package com.mahasiswa.Data.Kampus.matakuliah.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class MataKuliah {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private String makul_id;
	@Column
	private String makul;
	@Column
	private String kodeMakul;
	
	public String getId() {
		return makul_id;
	}

	public void setId(String makul_id) {
		this.makul_id = makul_id;
	}

	public String getMakul() {
		return makul;
	}

	public String getKodeMakul() {
		return kodeMakul;
	}

	public void setKodeMakul(String kodeMakul) {
		this.kodeMakul = kodeMakul;
	}

	public void setMakul(String makul) {
		this.makul = makul;
	}
	
	
	
	
}
