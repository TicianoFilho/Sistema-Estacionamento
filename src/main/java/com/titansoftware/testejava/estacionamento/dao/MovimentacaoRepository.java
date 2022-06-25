package com.titansoftware.testejava.estacionamento.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.titansoftware.testejava.estacionamento.entity.Movimentacao;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer>{
	
	//Veículos estacionados
	public List<Movimentacao> findByDataSaidaIsNull();
	
	//Veículos que já saíram
	public List<Movimentacao> findByDataSaidaIsNotNull();

}
