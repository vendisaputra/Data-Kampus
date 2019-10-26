package com.mahasiswa.Data.Kampus.loginSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mahasiswa.Data.Kampus.jurusan.model.Jurusan;
import com.mahasiswa.Data.Kampus.jurusan.service.JurusanService;

@Controller
public class AppController {
	
	@Autowired
	private JurusanService jurusanService;

	@GetMapping({"/","/login"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	
	
}
