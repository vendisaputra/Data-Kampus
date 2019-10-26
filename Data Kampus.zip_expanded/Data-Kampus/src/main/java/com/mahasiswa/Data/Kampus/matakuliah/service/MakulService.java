package com.mahasiswa.Data.Kampus.matakuliah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahasiswa.Data.Kampus.jurusan.repository.JurusanRepository;
import com.mahasiswa.Data.Kampus.matakuliah.model.MataKuliah;
import com.mahasiswa.Data.Kampus.matakuliah.repository.MakulRepository;

@Service
public class MakulService {
	@Autowired
	private MakulRepository makulRepository;
	
	public List<MataKuliah> listAll(){
		return makulRepository.findAll();
	}
	
	public void save(MataKuliah makul) {
		makulRepository.save(makul);
	}
	
	public MataKuliah get(String makul_id) {
		return makulRepository.findById(makul_id).get();
	}
	
	public void delete(String makul_id) {
		makulRepository.deleteById(makul_id);
	}
}
