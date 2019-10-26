package com.mahasiswa.Data.Kampus.jurusan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahasiswa.Data.Kampus.jurusan.model.Jurusan;
import com.mahasiswa.Data.Kampus.jurusan.repository.JurusanRepository;

@Service
public class JurusanService {
	@Autowired
	private JurusanRepository jurusanRepository;
	
	public List<Jurusan> listAll(){
		return jurusanRepository.findAll();
	}
	
	public void save(Jurusan jurusan) {
		jurusanRepository.save(jurusan);
	}
	
	public Jurusan get(String jurusan_id) {
		return jurusanRepository.findById(jurusan_id).get();
	}
	
	public void delete(String jurusan_id) {
		jurusanRepository.deleteById(jurusan_id);
	}
}
