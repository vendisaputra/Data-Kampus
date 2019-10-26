package com.mahasiswa.Data.Kampus.mahasiswa.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mahasiswa.Data.Kampus.mahasiswa.model.Mahasiswa;


public interface MahasiswaRepository extends JpaRepository<Mahasiswa, String>{

}
