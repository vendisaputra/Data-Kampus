package com.mahasiswa.Data.Kampus.matakuliah.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahasiswa.Data.Kampus.fakultas.model.Fakultas;
import com.mahasiswa.Data.Kampus.matakuliah.model.MataKuliah;

public interface MakulRepository extends JpaRepository<MataKuliah, String>{

}
