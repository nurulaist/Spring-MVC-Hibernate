package com.prodemy.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.prodemy.spring.model.Mahasiswa;
import com.prodemy.spring.service.MahasiswaService;

@Controller
public class MahasiswaController {
	@Autowired
	private MahasiswaService mahasiswaService;

	@RequestMapping(value = "/mahasiswas", method = RequestMethod.GET)
	public String listMahasiswas(Model model) {
		model.addAttribute("mahasiswa", new Mahasiswa());
		model.addAttribute("listMahasiswas", this.mahasiswaService.listMahasiswas());
		return "mahasiswa";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("mahasiswa", new Mahasiswa());
		model.addAttribute("listMahasiswas", this.mahasiswaService.listMahasiswas());
		return "index";
	}

	// For add and update phone both
	@RequestMapping(value = "/mahasiswa/add", method = RequestMethod.POST)
	public String addMahasiswa(@ModelAttribute("mahasiswa") Mahasiswa p) {
		if (p.getId() == 0) {
			// new phone, add it
			this.mahasiswaService.addMahasiswa(p);
		} else {
			// existing phone, call update
			this.mahasiswaService.updateMahasiswa(p);
		}
		return "redirect:/";
	}

	@RequestMapping("/remove/{id}")
	public String removeMahasiswa(@PathVariable("id") int id) {
		this.mahasiswaService.removeMahasiswa(id);
		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public String editMahasiswa(@PathVariable("id") int id, Model model) {
		model.addAttribute("mahasiswa", this.mahasiswaService.getMahasiswaById(id));
		model.addAttribute("listMahasiswas", this.mahasiswaService.listMahasiswas());
		return "index";
	}
}