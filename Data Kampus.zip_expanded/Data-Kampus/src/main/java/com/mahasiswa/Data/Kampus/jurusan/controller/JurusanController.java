package com.mahasiswa.Data.Kampus.jurusan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mahasiswa.Data.Kampus.jurusan.model.Jurusan;
import com.mahasiswa.Data.Kampus.jurusan.service.JurusanService;


@Controller
public class JurusanController {
	@Autowired
	private JurusanService service;
	
	@RequestMapping("/jurusan/index")
	public String jurusan(Model model) {
		List<Jurusan> listJurusans = service.listAll();
		model.addAttribute("listJurusans", listJurusans);
		model.addAttribute("no", listJurusans.size());	
		return "jurusan/jurusan";
	}
	
	@RequestMapping("/jurusan/new")
	public String addJurusan(Model model) {
		Jurusan jurusan = new Jurusan();
		model.addAttribute("jurusan", jurusan);
		return"jurusan/act_jurusan";
	}
	
	@RequestMapping(value = "/jurusan/save", method = RequestMethod.POST)
	public String saveJurusan(@ModelAttribute("jurusan") Jurusan jurusan) {
		 service.save(jurusan);
		 return "redirect:/jurusan/index";
	}
	
	@RequestMapping("/jurusan/edit/{jurusan_id}")
	public ModelAndView showEdit(@PathVariable(name = "jurusan_id") String jurusan_id) {
		ModelAndView mav = new ModelAndView("jurusan/act_jurusan");
		Jurusan jurusan = service.get(jurusan_id);
;		mav.addObject("jurusan", jurusan);
		return mav;
	}
	
	@RequestMapping("/jurusan/delete/{jurusan_id}")
	public String delete(@PathVariable(name = "jurusan_id") String jurusan_id) {
		service.delete(jurusan_id);
		return "redirect:/";
	}
}
