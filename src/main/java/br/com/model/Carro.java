package br.com.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Carro")
public class Carro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idcarro")
	private int idcarro;
	@Column(name="modelo", unique=false, nullable=false)
	private String modelo;
	@Column(name="cor", unique=false, nullable=false)
	private String cor;
	
	@OneToOne(mappedBy = "carro", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private Localidade localidade;
	
	@Column(name="ativo", unique=false, nullable=false)
	private boolean ativo;
	
	public int getIdcarro() {
		return idcarro;
	}
	public void setIdcarro(int idcarro) {
		this.idcarro = idcarro;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Localidade getLocalidade() {
		return localidade;
	}
	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
