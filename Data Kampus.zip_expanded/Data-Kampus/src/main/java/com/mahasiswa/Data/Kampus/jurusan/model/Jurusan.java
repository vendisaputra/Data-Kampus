package com.mahasiswa.Data.Kampus.jurusan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jurusan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String jurusan_id;
	@Column
	private String jurusan;
	
	public String getId() {
		return jurusan_id;
	}

	public void setId(String jurusan_id) {
		this.jurusan_id = jurusan_id;
	}

	public String getJurusan() {
		return jurusan;
	}

	public void setJurusan(String jurusan) {
		this.jurusan = jurusan;
	}
	
	public boolean isSelected(String jurusanId){
        if (jurusanId != null) {
            return jurusanId.equals(jurusan_id);
        }
        return false;
    } 
	
	
	
	
}
