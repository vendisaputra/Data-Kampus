package com.mahasiswa.Data.Kampus.fakultas.controller;

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
import com.mahasiswa.Data.Kampus.fakultas.model.Fakultas;



@Controller
public class FakultasController {
	@Autowired
	private FakultasService service;
	
	@RequestMapping({"/fakultas","/fakultas/index"})
	public String fakultas(Model model) {
		List<Fakultas> listFakultas = service.listAll();
		model.addAttribute("listFakultas", listFakultas);	
		return "fakultas/fakultas";
	}
	
	@RequestMapping("/fakultas/new")
	public String addfakultas(Model model) {
		Fakultas fakultas = new Fakultas();
		model.addAttribute("fakultas", fakultas);
		return"fakultas/act_fakultas";
	}
	
	@RequestMapping(value = "/fakultas/save", method = RequestMethod.POST)
	public String savefakultas(@ModelAttribute("fakultas") Fakultas fakultas) {
		 service.save(fakultas);
		 return "redirect:/fakultas/index";
	}
	
	@RequestMapping("/fakultas/edit/{fakultas_id}")
	public ModelAndView showEdit(@PathVariable(name = "fakultas_id") String fakultas_id) {
		ModelAndView mav = new ModelAndView("fakultas/act_fakultas");
		Fakultas fakultas= service.get(fakultas_id);
;		mav.addObject("fakultas", fakultas);
		return mav;
	}
	
	@RequestMapping("/fakultas/delete/{fakultas_id}")
	public String delete(@PathVariable(name = "fakultas_id") String fakultas_id) {
		service.delete(fakultas_id);
		return "redirect:/";
	}
}
