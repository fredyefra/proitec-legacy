package br.com.proitec.legacy.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.proitec.legacy.model.Cliente;
import br.com.proitec.legacy.model.EnderecoWS;
import br.com.proitec.legacy.service.ClienteService;


/**
* Realiza o inserte inicial na base de dados 
*
* @author fredyefra
* @see DataService
*/

@Service
public class DataService {
	
	@Autowired
	private ClienteService service;

	public void startDB() {

		EnderecoWS enderecoWS = new EnderecoWS(null, "70073-901", "SBS Quadra 1 Bloco G Lote 32", "12371720", "Asa Sul"); 
		EnderecoWS enderecoWS1 = new EnderecoWS(null, "70073-901", "SBS Quadra 3 Bloco B", "12371720", "Asa Sul");
		EnderecoWS enderecoWS2 = new EnderecoWS(null, "70073-901", "SAUN Quadra 5 Lote B Torres I", "12371720", "Asa Sul");
		
		Cliente c1 = new Cliente(null, "Martin Fowler", "(98) 333-1233","fowler@webmail.com", enderecoWS);
		Cliente c2 = new Cliente(null, "Guido van Rossum", "(44) 222-1111", "vanrossum@webmail.com",enderecoWS1);
		Cliente c3 = new Cliente(null, "James Gosling", "(89) 555-4478", "gosling@webmail.com",enderecoWS2);
		
		service.saveAll(List.of(c1,c2,c3));
	}
}