package com.titansoftware.testejava.estacionamento.service;

import java.util.List;

import com.titansoftware.testejava.estacionamento.entity.Movimentacao;

public interface MovimentacaoService {

	public void save(Movimentacao movimentacao);
	public void deleteById(int theId);
	
	//Veículos estacionados
	public List<Movimentacao> findBydataSaidaIsNull();
	
	//Veículos que já saíram
	public List<Movimentacao> findByDataSaidaIsNotNull();
	
}
