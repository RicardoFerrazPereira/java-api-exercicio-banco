package org.serratec.java2.backend.contas.bancarias.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="conta")

public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	@Column(name="conta_cd_numero")
	private Integer numConta;
	
	@Column(name="conta_tx_titula")
	private String titular;
	
	@Column(name="conta_saldo")
	private double saldo;
	
	
	public Conta() {}
	
	

	

	public Integer getNumConta() {
		return numConta;
	}

	public void setNumConta(Integer numConta) {
		this.numConta = numConta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
	
	}
	

		


