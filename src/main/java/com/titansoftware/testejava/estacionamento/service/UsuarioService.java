package com.titansoftware.testejava.estacionamento.service;

import org.springframework.stereotype.Service;

import com.titansoftware.testejava.estacionamento.entity.Usuario;

public interface UsuarioService {

	public Usuario findByUsuarioAndSenha(String usuario, String senha);
	
}
