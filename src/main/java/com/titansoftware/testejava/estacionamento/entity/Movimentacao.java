package com.titansoftware.testejava.estacionamento.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_movimentacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Campo obrigatório")
	@Pattern(regexp = "[a-zA-Z]{3}[0-9][a-zA-Z0-9][0-9]{2}", message = "Placa no formato inválido")
	private String placa;
	
	@NotBlank(message = "Campo obrigatório")
	private String modelo;
	
	@Column(name = "data_entrada")
	private LocalDateTime dataEntrada = LocalDateTime.now();
	
	@Column(name = "data_saida")
	private LocalDateTime dataSaida;
	
	private int tempo;
	
	@Column(name = "valor_pago")
	private double valorPago;
	
}
