package com.apap.tugas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugas.model.PustakawanModel;
import com.apap.tugas.model.SpesialisasiModel;
import com.apap.tugas.service.PustakawanService;
import com.apap.tugas.service.SpesialisasiService;


@Controller
public class PustakawanController {
	@Autowired
	private PustakawanService pustakawanService;
	
	@Autowired
	private SpesialisasiService spesialisasiService;
	
	@RequestMapping("/")
	private String beranda(Model model) {
		List <PustakawanModel> pustakawan=pustakawanService.listAll();
		List <SpesialisasiModel> spesialisasi=spesialisasiService.listAll();
		model.addAttribute("pustakawan", pustakawan);
		model.addAttribute("spesialisasi", spesialisasi);
		return "beranda";
	}
	
	@RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.GET)
	private String addPustakawan(Model model) {
		List <SpesialisasiModel> spesialisasi = spesialisasiService.listAll();
		PustakawanModel pustakawan = new PustakawanModel();
		pustakawan.setId(pustakawan.getId());
		model.addAttribute("spesialisasi", spesialisasi);
		model.addAttribute("pustakawan", pustakawan);
		return "addPustakawan";
	}
	
	@RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.POST, params={"simpan"} )
	private String addPustakawanSimpan(@RequestParam(value="spesialisasi", required = false) SpesialisasiModel spesialisasi, @ModelAttribute PustakawanModel pustakawan, Model model) {
		pustakawanService.addPustakawan(pustakawan);
		if (!(spesialisasi == null)) {
			Optional<SpesialisasiModel> spesialisasiId = spesialisasiService.getSpesialisasiDetailById(spesialisasi.getId());
			pustakawan.getPustakawanSpes().add(spesialisasiId.get());
		}
		return "tambahSuccess";		
	}
	
	@RequestMapping(value = "/pustakawan", method = RequestMethod.GET)
	public String viewPustakawan(@RequestParam(value = "nip", required = true) String nip, Model model) {
		PustakawanModel pustakawan = pustakawanService.getPustakawanByNIP(nip);
		model.addAttribute("pustakawan", pustakawan);
		return "viewDetailPustakawan";
	}
	
	@RequestMapping(value = "/pustakawan/update/{id}", method = RequestMethod.GET)
	private String updatePustakawan(@PathVariable(value = "id") int id, Model model) {
		List <SpesialisasiModel> spesialisasi = spesialisasiService.listAll();
		PustakawanModel pustakawan = pustakawanService.getPustakawanById(id);
		model.addAttribute("spesialisasi", spesialisasi);
		model.addAttribute("pustakawan", pustakawan);
		return "updatePustakawan";
	}
	
	@RequestMapping(value = "/pustakawan/update/{id}", method = RequestMethod.POST)
	private String updatePustakawanSimpan(@ModelAttribute PustakawanModel updatePustakawan, @PathVariable(value = "id") int id, Model model) {
		pustakawanService.updatePustakawan(id, updatePustakawan);
		return "updateSuccess";
	}
	
	@RequestMapping(value = "/pustakawan/delete/{id}")
	private String hapusPustakawan(@PathVariable(value = "id") int id, Model model) {
		pustakawanService.deletePustakawan(id);
		return "deleteSuccess";
	}
}
