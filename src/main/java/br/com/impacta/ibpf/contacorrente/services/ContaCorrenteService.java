package br.com.impacta.ibpf.contacorrente.services;

import java.util.ArrayList;
import java.util.List;

import br.com.impacta.ibpf.contacorrente.entities.Conta;
import br.com.impacta.ibpf.contacorrente.entities.ContaDados;
import br.com.impacta.ibpf.contacorrente.entities.ContaSaldo;
import br.com.impacta.ibpf.contacorrente.entities.Lancamento;
import br.com.impacta.ibpf.contacorrente.entities.LancamentoSaldo;
import br.com.impacta.ibpf.contacorrente.feignclients.ContaFeignClient;
import br.com.impacta.ibpf.contacorrente.feignclients.ContaSaldoFeignClient;
import br.com.impacta.ibpf.contacorrente.feignclients.LancamentoFeignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaCorrenteService {

	@Autowired
	private ContaFeignClient contaFeignClient;

	@Autowired
	private ContaSaldoFeignClient contaSaldoFeignClient;

	@Autowired
	private LancamentoFeignClient lancamentoFeignClient;

	public ContaDados getDados(long contaId) {
		Conta conta = contaFeignClient.findById(contaId).getBody();
		ContaSaldo contaSaldo = contaSaldoFeignClient.findByConta(contaId).getBody();
		return new ContaDados(conta.getId(), conta.getAgencia(), conta.getConta(), conta.getCpf(), conta.isStatus(), conta.getNomeCompleto(), contaSaldo.getSaldo());
	}

	public ContaDados getDados(String agencia, String conta) {
		Conta contaDado = contaFeignClient.findByAgenciaAndConta(agencia, conta).getBody();
		ContaSaldo contaSaldo = contaSaldoFeignClient.findByConta(contaDado.getId()).getBody();
		return new ContaDados(contaDado.getId(), contaDado.getAgencia(), contaDado.getConta(), contaDado.getCpf(), contaDado.isStatus(), contaDado.getNomeCompleto(), contaSaldo.getSaldo());
	}

	public List<LancamentoSaldo> getExtrato(String agencia, String conta) {
		Conta contaDado = contaFeignClient.findByAgenciaAndConta(agencia, conta).getBody();
		ContaSaldo contaSaldo = contaSaldoFeignClient.findByContaIni(contaDado.getId()).getBody();

		List<Lancamento> listaLancamentos = lancamentoFeignClient.findByContaId(contaDado.getId()).getBody();
		List<LancamentoSaldo> listaLancamentosSaldo = new ArrayList<>();

		Double saldoCalc = contaSaldo.getSaldo();

		System.out.println(saldoCalc);

		for (Lancamento lanc : listaLancamentos) {

			if (lanc.getTipo().equals("C")) {
				saldoCalc = saldoCalc + lanc.getValor();
			} else {
				saldoCalc = saldoCalc - lanc.getValor();
			}

			LancamentoSaldo lancSaldo = new LancamentoSaldo(contaDado.getAgencia(), contaDado.getConta(), lanc.getData(), lanc.getTipo(), lanc.getOperacao(), lanc
					.getDescricao(), lanc.getValor(), saldoCalc);

			listaLancamentosSaldo.add(lancSaldo);		
		}

		return listaLancamentosSaldo;
	}

}
