package com.mahasiswa.Data.Kampus.fakultas.model;

import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.security.auth.x500.X500Principal;

import com.mahasiswa.Data.Kampus.mahasiswa.model.Mahasiswa;

@Entity
public class Fakultas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private String fakultas_id;
	@Column
	private String fakultas;
	@OneToMany(mappedBy = "fakultas", cascade = CascadeType.ALL)
	private Set<Mahasiswa> mahasiswas;
	

	public String getId() {
		return fakultas_id;
	}

	public void setId(String fakultas_id) {
		this.fakultas_id = fakultas_id;
	}

	public String getFakultas() {
		return fakultas;
	}

	public void setFakultas(String fakultas) {
		this.fakultas = fakultas;
	}
	
	public boolean isSelected(String jurusanId){
        if (jurusanId != null) {
            return jurusanId.equals(fakultas_id);
        }
        return false;
    } 
	
	
	
	
}
