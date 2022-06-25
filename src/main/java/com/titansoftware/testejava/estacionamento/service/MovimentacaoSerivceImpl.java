package com.titansoftware.testejava.estacionamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.titansoftware.testejava.estacionamento.dao.MovimentacaoRepository;
import com.titansoftware.testejava.estacionamento.entity.Movimentacao;

@Service
@Transactional
public class MovimentacaoSerivceImpl implements MovimentacaoService {

	@Autowired
	MovimentacaoRepository movimentacaoRepository;
	
	@Override
	public void save(Movimentacao movimentacao) {
		movimentacaoRepository.save(movimentacao);	
	}

	@Override
	public void deleteById(int theId) {
		movimentacaoRepository.deleteById(theId);
	}

	@Override
	public List<Movimentacao> findBydataSaidaIsNull() {
		return movimentacaoRepository.findByDataSaidaIsNull();
	}

	@Override
	public List<Movimentacao> findByDataSaidaIsNotNull() {
		return movimentacaoRepository.findByDataSaidaIsNotNull();
	}

}
