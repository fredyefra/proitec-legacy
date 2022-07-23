package br.com.proitec.legacy.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.proitec.legacy.model.Cliente;
import br.com.proitec.legacy.service.ClienteService;

@Service
public class DataService {
	
	@Autowired
	private ClienteService service;

	public void startDB() {

		Cliente c1 = new Cliente(null, "Martin Fowler", "Baker Street - Arizona", "(98) 333-1233","fowler@webmail.com");
		Cliente c2 = new Cliente(null, "Guido van Rossum", "7º Avennue - New York", "(44) 222-1111","rossum@webmail.com");
		Cliente c3 = new Cliente(null, "James Gosling", "Palo Alto - California", "(91) 777-1111","gosling@webmail.com");
		
		
		
		service.saveAll(List.of(c1,c2,c3));
	}
}