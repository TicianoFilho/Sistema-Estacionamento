package com.titansoftware.testejava.estacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titansoftware.testejava.estacionamento.dao.UsuarioRepository;
import com.titansoftware.testejava.estacionamento.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario findByUsuarioAndSenha(String usuario, String senha) {
		return usuarioRepository.findByUsuarioAndSenha(usuario, senha);
	}

}
