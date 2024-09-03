package br.com.proitec.legacy.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.proitec.legacy.enderecows.EnderecoConsumer;
import br.com.proitec.legacy.model.EnderecoWS;

/**
* Disponibiliza o recurso de CEP da classe {@link EnderecoConsumer} para a classe {@link EnderecoWS}
*
* @author fredyefra
* @see EnderecoConsumer
*/

@RestController
@RequestMapping(value = "api/cep")
public class EnderecoResource {

	    @Autowired
	    private EnderecoConsumer enderecoConsumer;

	    @GetMapping(value = "/{cep}/ws", produces = MediaType.APPLICATION_JSON)
		public EnderecoWS findCep(@PathVariable String cep) {
	    	EnderecoWS enderecoWS = enderecoConsumer.enderecoConsumer(cep);
	        return enderecoWS;
	    }
	}	