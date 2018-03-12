package br.usjt.arqsw.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * 
 * @author Lucas Nagaoka
 *
 */

public class Chamado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String ABERTO = "aberto";
	public static final String FECHADO = "fechado";

	@NotNull(message="O chamado não pode ser vazio")
	@Min(value=1, message="O chamado não pode ser vazio")
	private int id;
	
	@NotNull
	@Size(min=10, max=100, message="O chamado precisa ter uma descrição.")
	private String descricao;
	
	@NotNull
	@Size(min=5, max=100, message="O chamado precisa ter um status definido.")
	private String status;
	
	@NotNull
	private Date dataAbertura;

	@Null
	private Date dataFechamento;
	
	@NotNull
	private Fila fila;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Fila getFila() {
		return fila;
	}

	public void setFila(Fila fila) {
		this.fila = fila;
	}
	
	@Override
	public String toString() {
		return "Chamado [id=" + id + ", descricao=" + descricao + ", status=" + status + ", dataAbertura="
				+ dataAbertura + ", dataFechamento=" + dataFechamento + ", fila=" + fila + "]";
	}
}