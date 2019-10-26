package com.mahasiswa.Data.Kampus.mahasiswa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.mahasiswa.Data.Kampus.fakultas.model.Fakultas;
import com.mahasiswa.Data.Kampus.jurusan.model.Jurusan;

@Entity
@Table(name = "mahasiswa")
public class Mahasiswa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String nim;
	@Column
	private String nama;
	@Column
	private String alamat;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jurusan_id")
	@Fetch(FetchMode.JOIN)
	private Jurusan jurusan;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fakultas_id")
	@Fetch(FetchMode.JOIN)
	private Fakultas fakultas;
	
	public String getNim() {
		return nim;
	}
	public void setNim(String nim) {
		this.nim = nim;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public Jurusan getJurusan() {
		return jurusan;
	}
	public void setJurusan(Jurusan jurusan) {
		this.jurusan = jurusan;
	}
	public Fakultas getFakultas() {
		return fakultas;
	}
	public void setFakultas(Fakultas fakultas) {
		this.fakultas = fakultas;
	}
	
	
		
	
}
