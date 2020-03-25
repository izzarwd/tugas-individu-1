package com.apap.tugas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.tugas.model.PerpustakaanModel;
import com.apap.tugas.service.PerpustakaanService;

@Controller
public class PerpustakaanController {
	@Autowired
	private PerpustakaanService perpustakaanService;
	
	@RequestMapping("/perpustakaan")
	private String daftarPerpustakaan(Model model) {
		List <PerpustakaanModel> perpustakaan = perpustakaanService.listAll();
		model.addAttribute("perpustakaan", perpustakaan);
		return "listPerpustakaan";   
	}
	
	@RequestMapping(value = "/perpustakaan/tambah", method = RequestMethod.GET)
	private String addPerpustakaan(Model model) {
		PerpustakaanModel perpustakaan = new PerpustakaanModel();
		perpustakaan.setId(perpustakaan.getId());
		model.addAttribute("perpustakaan", perpustakaan);
		return "addPerpustakaan";
	}
	
	@RequestMapping(value = "/perpustakaan/tambah", method = RequestMethod.POST)
	private String addPerpustakaanSimpan(@ModelAttribute PerpustakaanModel perpustakaan, Model model) {
		perpustakaanService.addPerpustakaan(perpustakaan);
		return "addSuccess";		
	}
	
	@RequestMapping(value = "/perpustakaan/delete/{id}")
	private String deletePerpustakaan(@PathVariable(value = "id") int id, Model model) {
		perpustakaanService.deletePerpustakaan(id);
		return "deleteSuccess";
	}
}
