package br.com.impacta.ibpf.contacorrente.entities;

import java.io.Serializable;

public class ContaDados implements Serializable {

	private Long id;
	private String agencia;
	private String conta;
	private String cpf;
	private boolean status;
	private String nomeCompleto;
	private Double saldo;

	public ContaDados() {
	}

	public ContaDados(Long id, String agencia, String conta, String cpf, boolean status, String nomeCompleto, Double saldo) {
		super();
		this.id = id;
		this.agencia = agencia;
		this.conta = conta;
		this.cpf = cpf;
		this.status = status;
		this.nomeCompleto = nomeCompleto;
		this.saldo = saldo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	void setConta(String conta) {
		this.conta = conta;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ContaDados conta1 = (ContaDados) o;

		if (id != null ? !id.equals(conta1.id) : conta1.id != null) return false;
		if (agencia != null ? !agencia.equals(conta1.agencia) : conta1.agencia != null) return false;
		if (conta != null ? !conta.equals(conta1.conta) : conta1.conta != null) return false;
		return cpf != null ? cpf.equals(conta1.cpf) : conta1.cpf == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (agencia != null ? agencia.hashCode() : 0);
		result = 31 * result + (conta != null ? conta.hashCode() : 0);
		result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Conta{" +
				"id=" + id +
				", agencia='" + agencia + '\'' +
				", conta='" + conta + '\'' +
				", cpf='" + cpf + '\'' +
				", status=" + status +
				", nomeCompleto='" + nomeCompleto + '\'' +
				'}';
	}
}
