package com.mahasiswa.Data.Kampus.matakuliah.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mahasiswa.Data.Kampus.fakultas.model.Fakultas;
import com.mahasiswa.Data.Kampus.fakultas.service.FakultasService;
import com.mahasiswa.Data.Kampus.matakuliah.model.MataKuliah;
import com.mahasiswa.Data.Kampus.matakuliah.service.MakulService;
import com.mahasiswa.Data.Kampus.fakultas.model.Fakultas;



@Controller
public class MakulController {
	@Autowired
	private MakulService service;
	
	@RequestMapping({"/matakuliah","/matakuliah/index"})
	public String matakuliah(Model model) {
		List<MataKuliah> listmatakuliah = service.listAll();
		model.addAttribute("listmatakuliah", listmatakuliah);	
		return "matakuliah/matakuliah";
	}
	
	@RequestMapping("/matakuliah/new")
	public String addmatakuliah(Model model) {
		MataKuliah matakuliah = new MataKuliah();
		model.addAttribute("matakuliah", matakuliah);
		return"matakuliah/act_makul";
	}
	
	@RequestMapping(value = "/matakuliah/save", method = RequestMethod.POST)
	public String savematakuliah(@ModelAttribute("matakuliah") MataKuliah matakuliah) {
		 service.save(matakuliah);
		 return "redirect:/matakuliah/index";
	}
	
	@RequestMapping("/matakuliah/edit/{matakuliah_id}")
	public ModelAndView showEdit(@PathVariable(name = "matakuliah_id") String matakuliah_id) {
		ModelAndView mav = new ModelAndView("matakuliah/act_makul");
		MataKuliah matakuliah= service.get(matakuliah_id);
;		mav.addObject("matakuliah", matakuliah);
		return mav;
	}
	
	@RequestMapping("/matakuliah/delete/{matakuliah_id}")
	public String delete(@PathVariable(name = "matakuliah_id") String matakuliah_id) {
		service.delete(matakuliah_id);
		return "redirect:/";
	}
}
