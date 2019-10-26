package com.mahasiswa.Data.Kampus.mahasiswa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.spring5.expression.Mvc;

import com.mahasiswa.Data.Kampus.fakultas.model.Fakultas;
import com.mahasiswa.Data.Kampus.fakultas.service.FakultasService;
import com.mahasiswa.Data.Kampus.jurusan.model.Jurusan;
import com.mahasiswa.Data.Kampus.jurusan.service.JurusanService;
import com.mahasiswa.Data.Kampus.mahasiswa.model.Mahasiswa;
import com.mahasiswa.Data.Kampus.mahasiswa.service.MahasiswaService;


@Controller
public class MahasiswaController {
	@Autowired
	private MahasiswaService service;
	
	@Autowired
	private JurusanService jService;
	
	@Autowired
	private FakultasService fService;
	
	@RequestMapping({"/mahasiswa","/mahasiswa/index"})
	public String mahasiswa(Model model) {
		List<Mahasiswa> listmahasiswas = service.listAll();
		model.addAttribute("listMahasiswa", listmahasiswas);
		model.addAttribute("no", listmahasiswas.size());	
		return "mahasiswa/mahasiswa";
	}
	
	
	@RequestMapping("/mahasiswa/new")
	public String addmahasiswa(Model model) {
		Mahasiswa mahasiswa = new Mahasiswa();
		model.addAttribute("mahasiswa", mahasiswa);
		return"mahasiswa/act_mahasiswa";
	}
	
	@RequestMapping(value = "/mahasiswa/save", method = RequestMethod.POST)
	public String savemahasiswa(@ModelAttribute("mahasiswa") Mahasiswa mahasiswa) {
		 service.save(mahasiswa);
		 return "redirect:/mahasiswa/index";
	}
	
	@RequestMapping("/mahasiswa/edit/{nim}")
	public ModelAndView showEdit(@PathVariable(name = "nim") String nim) {
		ModelAndView mav = new ModelAndView("mahasiswa/act_mahasiswa");
		List<Fakultas> listFakultas = fService.listAll();
		List<Jurusan> listJurusan= jService.listAll();
		Mahasiswa mahasiswa = service.get(nim);
		mav.addObject("id_fakul",mahasiswa.getFakultas());
		mav.addObject("id_jurus",mahasiswa.getJurusan());
		mav.addObject("listFakultas",listFakultas);
		mav.addObject("listJurusan",listJurusan);
;		mav.addObject("mahasiswa", mahasiswa);
		return mav;
	}
	
	@RequestMapping("/mahasiswa/delete/{nim}")
	public String delete(@PathVariable(name = "nim") String nim) {
		service.delete(nim);
		return "redirect:/";
	}
}
