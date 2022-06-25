package com.titansoftware.testejava.estacionamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movimentacao")
public class MovimentacaoController {

	@GetMapping("/list")
	public String showForm(Model model) {
		model.addAttribute("test", "Principal");
		return "index";
	}
}
