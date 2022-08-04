package br.com.proitec.legacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.proitec.legacy.enderecows.EnderecoConsumer;
import br.com.proitec.legacy.enderecows.EnderecoWS;

@RestController
@RequestMapping(value = "api/cep")
public class EnderecoResource {

	    @Autowired
	    private EnderecoConsumer enderecoConsumer;

	    //@GetMapping(value = "cep")
	    @GetMapping(value = "/{cep}/ws")
		public EnderecoWS findCep(@PathVariable String cep) {
	    	EnderecoWS enderecoWS = enderecoConsumer.enderecoConsumer(cep);
	        return enderecoWS;
	    }
	}	