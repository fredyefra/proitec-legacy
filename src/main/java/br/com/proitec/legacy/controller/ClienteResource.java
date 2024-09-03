package br.com.proitec.legacy.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.proitec.legacy.enderecows.EnderecoConsumer;
import br.com.proitec.legacy.model.Cliente;
import br.com.proitec.legacy.service.ClienteService;

/**
* Disponibiliza os recursos de Cliente 
*
* @author fredyefra
* @see EnderecoConsumer
*/

@RestController
@RequestMapping(value = "api/nome")
public class ClienteResource {

	@Autowired
	ClienteService service;
	
	@ResponseBody
	@RequestMapping(value = "/{nome}/ws", produces = MediaType.APPLICATION_JSON)
	public Cliente findNome(@PathVariable String nome) {
		
		List<Cliente> clientes = service.findAll(nome);
		
		  for (Cliente cliente : clientes) { 
		  cliente.getNome(); 
		  cliente.getTelefone();
		  cliente.getEmail(); 
		  cliente.getEndereco(); 
		  return cliente; 
		  
		  }
		 
		return null; 
	}
}