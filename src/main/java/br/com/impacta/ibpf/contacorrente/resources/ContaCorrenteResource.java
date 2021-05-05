package br.com.impacta.ibpf.contacorrente.resources;

import java.util.List;

import br.com.impacta.ibpf.contacorrente.entities.ContaDados;
import br.com.impacta.ibpf.contacorrente.entities.LancamentoSaldo;
import br.com.impacta.ibpf.contacorrente.services.ContaCorrenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/contascorrente")
public class ContaCorrenteResource {

	@Autowired
	private ContaCorrenteService contaCorrenteService;

	@GetMapping(value = "/{contaId}")
	public ResponseEntity<ContaDados> getDados(@PathVariable Long contaId) {
		ContaDados contaDados = contaCorrenteService.getDados(contaId);
		return ResponseEntity.ok(contaDados);
	}

	@GetMapping(value = "/saldo")
	public ResponseEntity<ContaDados> findByContaData(@RequestParam("agencia") String agencia, @RequestParam("conta") String conta) {
		ContaDados contaDados = contaCorrenteService.getDados(agencia, conta);
		return ResponseEntity.ok(contaDados);		
	}

	@GetMapping(value = "/extratoConta")
	public ResponseEntity<List<LancamentoSaldo>> findByContaExtrato(@RequestParam("agencia") String agencia, @RequestParam("conta") String conta) {
		List<LancamentoSaldo> saldoList = contaCorrenteService.getExtrato(agencia, conta);
		return ResponseEntity.ok(saldoList);
	}

}
