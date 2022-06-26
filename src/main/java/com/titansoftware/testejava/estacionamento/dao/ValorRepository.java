package com.titansoftware.testejava.estacionamento.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.titansoftware.testejava.estacionamento.entity.Valor;

@Repository
public interface ValorRepository extends JpaRepository<Valor, Integer> {

	public Valor findById(int valorId);
}
