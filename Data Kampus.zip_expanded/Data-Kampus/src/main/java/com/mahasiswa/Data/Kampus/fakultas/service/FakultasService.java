package com.mahasiswa.Data.Kampus.fakultas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahasiswa.Data.Kampus.fakultas.model.Fakultas;
import com.mahasiswa.Data.Kampus.fakultas.repository.FakultasRepository;
import com.mahasiswa.Data.Kampus.jurusan.model.Jurusan;
import com.mahasiswa.Data.Kampus.jurusan.repository.JurusanRepository;

@Service
public class FakultasService {
	@Autowired
	private FakultasRepository fakultasRepository;
	
	public List<Fakultas> listAll(){
		return fakultasRepository.findAll();
	}
	
	public void save(Fakultas fakultas) {
		fakultasRepository.save(fakultas);
	}
	
	public Fakultas get(String fakultas_id) {
		return fakultasRepository.findById(fakultas_id).get();
	}
	
	public void delete(String fakultas_id) {
		fakultasRepository.deleteById(fakultas_id);
	}
}
