package br.com.impacta.ibpf.contacorrente.entities;

import java.io.Serializable;
import java.util.Date;

public class ContaSaldo implements Serializable {

	private Long id;
	private Date dataEvento;
	private Double saldo;
	private boolean status;
	private Long contaId;

	public ContaSaldo() {
	}

	public ContaSaldo(Long id, Date dataEvento, Double saldo, boolean status, Long contaId) {
		this.id = id;
		this.dataEvento = dataEvento;
		this.saldo = saldo;
		this.status = status;
		this.contaId = contaId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
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

		ContaSaldo that = (ContaSaldo) o;

		if (status != that.status) return false;
		if (!id.equals(that.id)) return false;
		if (!dataEvento.equals(that.dataEvento)) return false;
		if (!saldo.equals(that.saldo)) return false;
		return contaId.equals(that.contaId);
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + dataEvento.hashCode();
		result = 31 * result + saldo.hashCode();
		result = 31 * result + (status ? 1 : 0);
		result = 31 * result + contaId.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "ContaSaldo{" +
				"id=" + id +
				", dataEvento=" + dataEvento +
				", saldo=" + saldo +
				", status=" + status +
				", contaId=" + contaId +
				'}';
	}
}
