package org.serratec.java2.backend.contas.bancarias.exception;

public class ContaException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private Integer numConta;

	public ContaException(Integer numConta) {
		super();
		this.numConta = numConta;
	}

	public Integer getnumConta() {
		return numConta;
	}

	public void setId(Integer numConta) {
		this.numConta = numConta;
	}
	
	
	
	
	

}
