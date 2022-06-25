package com.titansoftware.testejava.estacionamento.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tbl_movimentacao")
@Data
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String placa;
	
	private String modelo;
	
	@Column(name = "data_entrada")
	private LocalDateTime dataEntrada;
	
	@Column(name = "data_saida")
	private LocalDateTime dataSaida;
	
	private double tempo;
	
	@Column(name = "valor_pago")
	private double valorPago;
	
}
