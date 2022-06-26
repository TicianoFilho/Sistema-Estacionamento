package com.titansoftware.testejava.estacionamento.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.titansoftware.testejava.estacionamento.entity.Usuario;
import com.titansoftware.testejava.estacionamento.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/")
	public String showLoginForm(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("user", usuario);
		return "login";
	}
	
	@PostMapping("/autenticarUser")
	public String autenticarUsuario(@Valid @ModelAttribute("user") Usuario usuario, BindingResult result) {

		if (result.hasErrors()) {
			return "login";
		}
		
		Usuario dbUser = usuarioService.findByUsuarioAndSenha(usuario.getUsuario(), usuario.getSenha());
		
		if (dbUser != null) {
			if (usuario.getUsuario().equals(dbUser.getUsuario()) && usuario.getSenha().equals(dbUser.getSenha())) {
				return "redirect:/movimentacao/list";
			}
		}
		
		return "login";
	}
	
}
