package com.titansoftware.testejava.estacionamento.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.titansoftware.testejava.estacionamento.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	public Usuario findByUsuarioAndSenha(String usuario, String senha);
}
