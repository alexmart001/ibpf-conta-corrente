package br.com.impacta.ibpf.contacorrente.entities;

import java.io.Serializable;
import java.util.Date;

public class Lancamento implements Serializable {
    
    private Long id;
	private Date data;
	private String tipo;
	private String operacao;
	private String descricao;
	private Double valor;
	private boolean status;
	private Long contaId;

	public Lancamento() {
	}

	public Lancamento(Long id, Date data, String tipo, String operacao, String descricao, Double valor, boolean status, Long contaId) {
		this.id = id;
		this.data = data;
		this.tipo = tipo;
		this.operacao = operacao;
		this.descricao = descricao;
		this.valor = valor;
		this.status = status;
		this.contaId = contaId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Long getContaId() {
		return contaId;
	}

	public void setContaId(Long contaId) {
		this.contaId = contaId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Lancamento that = (Lancamento) o;

		if (data != null ? !data.equals(that.data) : that.data != null) return false;
		if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;
		if (operacao != null ? !operacao.equals(that.operacao) : that.operacao != null) return false;
		if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;
		if (valor != null ? !valor.equals(that.valor) : that.valor != null) return false;
		return contaId != null ? contaId.equals(that.contaId) : that.contaId == null;
	}

	@Override
	public int hashCode() {
		int result = data != null ? data.hashCode() : 0;
		result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
		result = 31 * result + (operacao != null ? operacao.hashCode() : 0);
		result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
		result = 31 * result + (valor != null ? valor.hashCode() : 0);
		result = 31 * result + (contaId != null ? contaId.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Lancamento{" +
				"id=" + id +
				", data=" + data +
				", tipo='" + tipo + '\'' +
				", operacao='" + operacao + '\'' +
				", descricao='" + descricao + '\'' +
				", valor=" + valor +
				", status=" + status +
				", contaId=" + contaId +
				'}';
	}
}
