package com.titansoftware.testejava.estacionamento.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.titansoftware.testejava.estacionamento.entity.Movimentacao;
import com.titansoftware.testejava.estacionamento.entity.Valor;
import com.titansoftware.testejava.estacionamento.service.MovimentacaoService;
import com.titansoftware.testejava.estacionamento.service.ValorService;

@Controller
@RequestMapping("/movimentacao")
public class MovimentacaoController {
	
	@Autowired
	private MovimentacaoService movimentacaoService;
	
	@Autowired
	private ValorService valorService;
	
	@GetMapping("/list")
	public String showList(Model model) {
		return "redirect:/movimentacao/estacionados";
	}
	
	//Abre o formulário para entrada de novo veículo com a data atual já pre definida.
	@GetMapping("/entrada-form")
	public String entradaShowForm(Model model) {
		
		Movimentacao movimentacao = new Movimentacao();
		
		model.addAttribute("movimentacao", movimentacao);
		return "entrada-form";
	}
	
	//Salva a entrada de um veículo
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("movimentacao") Movimentacao movimentacao, BindingResult result) {
		
		if (result.hasErrors()) {
			return "entrada-form";
		}
		
		try {
			movimentacaoService.save(movimentacao);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "entrada-form";
	}
	
	//Busca um veículo pelo id.
	@GetMapping("/veiculo")
	public String buscarVeiculo(@RequestParam("veiculoId") int veiculoId, Model model) {
		Movimentacao movimentacao = movimentacaoService.findById(veiculoId);
		model.addAttribute("movimentacao", movimentacao);
		return "entrada-form";
	}
	
	@GetMapping("/saida-form")
	public String saidaShowform(@RequestParam("veiculoId") int veiculoId, Model model) {
		
		Movimentacao movimentacao = movimentacaoService.findById(veiculoId);
		try {
			
			//Se ainda não foi dada a saída do veículo.
			if (movimentacao.getValorPago() <= 0 ) {
				
				Valor valor = valorService.findById(1);

				// Define valores automaticamente para a saída do veículo
				movimentacao.setDataSaida(LocalDateTime.now());
				movimentacao.setTempo(getTempoTotalEstadia(movimentacao));
				movimentacao.setValorPago(definirValor(movimentacao, valor));  //Tem que chamar o setTempo() antes de chamar o setValorPago()
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("movimentacao", movimentacao);
		
		return "saida-form";
	}  
	
	@PostMapping("/efetuar-saida")
	public String efetuarSaida(@ModelAttribute("movimentacao") Movimentacao movimentacao) {

		movimentacaoService.save(movimentacao);
		
		return "saida-form";
	}
	
	@GetMapping("/estacionados")
	public String getAllEstacionados(Model model) {
		List<Movimentacao> movimentacoes = movimentacaoService.findBydataSaidaIsNull();
		model.addAttribute("movimentacoes", movimentacoes);
		model.addAttribute("pesquisaLabel", "(Estacionados)");
		return "index";
	}
	
	@GetMapping("/sairam")
	public String getAllSairam(Model model) {
		List<Movimentacao> movimentacoes = movimentacaoService.findByDataSaidaIsNotNull();
		model.addAttribute("movimentacoes", movimentacoes);
		model.addAttribute("pesquisaLabel", "(Saíram)");	
		return "index";
	}
	
	private int getTempoTotalEstadia(Movimentacao mov) {
		
		//Identifica quantos dias o veículo ficou estacionado
		int dias = (mov.getDataSaida().getDayOfMonth() - mov.getDataEntrada().getDayOfMonth());
		
		int horaEntrada = mov.getDataEntrada().getHour();
		int horaSaida = (mov.getDataSaida().getHour() + (dias * 24));
		int horasTotais = (horaSaida - horaEntrada);
		
		return (horasTotais == 0) ? 1 : horasTotais;
	}
	
	private double definirValor(Movimentacao mov, Valor valor) {	
		
		//O campo movimentacao.tempo (mov.getTempo) tem que já estar preenchido previamente.
		
		double valorPrimeiraHora = valor.getValorPrimeiraHora();
		double valorAdicional = ( (mov.getTempo() - 1) * valor.getValorDemaisHoras() ) ;
	
		return valorPrimeiraHora + valorAdicional;
	
	}
	
}
