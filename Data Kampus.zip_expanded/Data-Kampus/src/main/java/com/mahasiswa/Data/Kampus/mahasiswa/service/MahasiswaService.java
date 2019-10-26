package com.mahasiswa.Data.Kampus.mahasiswa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahasiswa.Data.Kampus.fakultas.repository.FakultasRepository;
import com.mahasiswa.Data.Kampus.jurusan.model.Jurusan;
import com.mahasiswa.Data.Kampus.jurusan.repository.JurusanRepository;
import com.mahasiswa.Data.Kampus.mahasiswa.model.Mahasiswa;

import com.mahasiswa.Data.Kampus.mahasiswa.repository.MahasiswaRepository;

@Service
public class MahasiswaService {
	@Autowired
	private MahasiswaRepository mahasiswaRepository;
	@Autowired
	private JurusanRepository jurusanRepository;
	@Autowired
	private FakultasRepository fakultasRepository;
	

	
	public List<Mahasiswa> listAll(){
		return mahasiswaRepository.findAll();
	}
	
	public void save(Mahasiswa mahasiswa) {
		mahasiswaRepository.save(mahasiswa);
	}
	
	public Mahasiswa get(String nim) {
		return mahasiswaRepository.findById(nim).get();
	}
	
	public void delete(String nim) {
		mahasiswaRepository.deleteById(nim);
	}
}
