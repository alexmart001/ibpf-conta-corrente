package br.com.impacta.ibpf.contacorrente.entities;

import java.io.Serializable;
import java.util.Date;

public class LancamentoSaldo implements Serializable {

	private String agencia;
	private String conta;
	private Date data;
	private String tipo;
	private String operacao;
	private String descricao;
	private Double valor;
	private Double saldo;

	public LancamentoSaldo() {
	}

	public LancamentoSaldo(String agencia, String conta, Date data, String tipo, String operacao, String descricao, Double valor, Double saldo) {
		this.agencia = agencia;
		this.conta = conta;
		this.data = data;
		this.tipo = tipo;
		this.operacao = operacao;
		this.descricao = descricao;
		this.valor = valor;
		this.saldo = saldo;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}
