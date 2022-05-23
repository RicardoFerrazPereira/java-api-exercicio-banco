package org.serratec.java2.backend.contas.bancarias.controller;

import java.util.List;

import org.serratec.java2.backend.contas.bancarias.entity.Conta;
import org.serratec.java2.backend.contas.bancarias.exception.ContaException;
import org.serratec.java2.backend.contas.bancarias.exception.OperacaoException;
import org.serratec.java2.backend.contas.bancarias.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")

public class ContaController {
	
	@Autowired
	ContaService contaService;
	
	@GetMapping("/lista")
	public List<Conta> getConta() {
		return contaService.listaContas();
	}
	
	@GetMapping("/buscar/{numConta}")
	public ResponseEntity<Conta> buscarPorNumConta(@PathVariable int numConta) throws ContaException {
		return ResponseEntity.ok(contaService.buscarPorNumConta(numConta));
	}
	
	@PostMapping("/adicionar")
	public ResponseEntity<Void> adicionar(@RequestBody Conta conta) {
		contaService.adicionar(conta);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/atualizar/{numConta}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer numConta, @RequestBody Conta conta) throws ContaException {
		contaService.atualizar(numConta, conta);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
		
	@DeleteMapping("/delete/{numConta}")
	public ResponseEntity<Void> delete(@PathVariable int numConta) {
		contaService.delConta(numConta);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	
	
	@PutMapping("/debitar/{numConta}")
	public ResponseEntity<Void> debitar(@PathVariable Integer numConta, @RequestParam float valor) throws OperacaoException {
		contaService.debitar(numConta, valor);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/creditar/{numConta}")
	public ResponseEntity<Void> creditar(@PathVariable Integer numConta, @RequestParam float valor) throws ContaException {
		contaService.creditar(numConta, valor);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	

	
}	
	
	
	


