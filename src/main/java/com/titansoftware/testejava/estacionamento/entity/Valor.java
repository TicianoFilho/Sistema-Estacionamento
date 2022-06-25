package com.titansoftware.testejava.estacionamento.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Entity
@Table(name = "tbl_valor")
@Data
public class Valor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Value("${projeto.valorPrimeiraHora}")
	@Column(name = "valor_primeira_hora")
	private double valorPrimeiraHora;
	
	@Column(name = "valor_demais_horas")
	private double valorDemaisHoras;
	
	@Column(name = "data_fim")
	private LocalDateTime dataFim;
}
