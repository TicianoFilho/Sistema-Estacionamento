package com.titansoftware.testejava.estacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.titansoftware.testejava.estacionamento.dao.ValorRepository;
import com.titansoftware.testejava.estacionamento.entity.Valor;

@Service
@Transactional
public class ValorServiceImpl implements ValorService {

	@Autowired
	ValorRepository valorRepository;
	
	@Override
	public Valor findById(int valorId) {
		return valorRepository.findById(valorId);
	}

}
