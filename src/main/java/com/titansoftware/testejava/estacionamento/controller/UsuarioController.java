package com.titansoftware.testejava.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String autenticarUsuario(@ModelAttribute("user") Usuario usuario) {

		Usuario dbUser = usuarioService.findByUsuarioAndSenha(usuario.getUsuario(), usuario.getSenha());
		
		if (dbUser != null) {
			if (camposPreenchidos(usuario.getUsuario(), usuario.getSenha())) {
				if (usuario.getUsuario().equals(dbUser.getUsuario()) && usuario.getSenha().equals(dbUser.getSenha())) {
					return "redirect:/movimentacao/list";
				}
			}
		}
		
		return "login";
	}
	
	private boolean camposPreenchidos(String usuario, String senha) {
		if (usuario.isBlank() || usuario.isEmpty() || senha.isBlank() || senha.isEmpty()) {
			return false;
		}
		return true;
	}
}
