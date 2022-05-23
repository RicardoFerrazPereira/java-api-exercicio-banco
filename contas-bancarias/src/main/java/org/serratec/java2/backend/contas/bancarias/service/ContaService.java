package org.serratec.java2.backend.contas.bancarias.service;

import java.util.List;

import org.serratec.java2.backend.contas.bancarias.entity.Conta;
import org.serratec.java2.backend.contas.bancarias.exception.ContaException;
import org.serratec.java2.backend.contas.bancarias.exception.OperacaoException;
import org.serratec.java2.backend.contas.bancarias.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ContaService {
	
	@Autowired
	ContaRepository contaRepository;
	
	// Lista todas as contas
	
	public List<Conta> listaContas() {
		return contaRepository.findAll();
	}
	
	// Serviço buscar pelo numero
	
	public Conta buscarPorNumConta(Integer numConta) throws ContaException {
		Conta contaBanco = new Conta();
			for (Conta conta : listaContas()) {
				if(conta.getNumConta().equals(numConta)) {
					contaBanco = conta;
				}
			}
			if(contaBanco.getNumConta() == null) {
				throw new ContaException(numConta);
			}
			return contaBanco;
		}
	
	
	// Adicionar conta
	
	public void adicionar(Conta conta) {
		contaRepository.save(conta);
		
	}
	

	
	// Atualizar conta
	
	public void atualizar(Integer numConta, Conta conta) throws ContaException{
		Conta contaLista = new Conta();
		for(Conta contaAtualiza : listaContas()) {
			if(contaAtualiza.getNumConta().equals(numConta)) {
				contaLista = conta;
				if(conta.getTitular() != null) {
					contaLista.setTitular(conta.getTitular());
				}
				if(conta.getNumConta() != null) {
					contaLista.setNumConta(conta.getNumConta());
				}
				contaRepository.save(contaLista);
			}
			
		}
		if(contaLista.getNumConta() == null) {
			throw new ContaException(numConta);
		}
	}
	
	
	// Deletar conta
	
	public void delConta(Integer numConta) {
		Conta contaDelete = new Conta();
		for (Conta conta : listaContas()) {
			if(conta.getNumConta().equals(numConta)) {
				contaDelete = conta;
			}
		}
		contaRepository.delete(contaDelete);
	}
	
	
	
	// Debitar
	
	public void debitar(Integer numConta, float valor) throws OperacaoException {
		Conta contaDeb = new Conta();
		for(Conta conta : listaContas()) {
			if(conta.getNumConta().equals(numConta)) {
				contaDeb = conta;
				contaDeb.setSaldo(contaDeb.getSaldo() - valor);
				
			}
		}
		if(contaDeb.getSaldo() < valor) {
			throw new OperacaoException(valor);
		}
		contaRepository.save(contaDeb);
				
	}
	
	// Creditar
	
	public void creditar(Integer numConta, float valor) throws ContaException {
		Conta contaCred = new Conta();
		for(Conta conta : listaContas()) {
			if(conta.getNumConta().equals(numConta)) {
				contaCred = conta;
				contaCred.setSaldo(contaCred.getSaldo() + valor);
			}
		}
		if(contaCred.getNumConta() == null) {
			throw new ContaException(numConta);
		}
		contaRepository.save(contaCred);
		
	}
	
	
}
