package br.com.proitec.legacy.enderecows;

import java.io.Serializable;
import java.lang.reflect.Type;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;

import br.com.proitec.legacy.model.EnderecoWS;

@Service
public class EnderecoConsumer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EnderecoWS endereco;
	
	public EnderecoWS enderecoConsumer(String cep) {
		
		try {
			com.sun.jersey.api.client.Client client = Client.create();
			com.sun.jersey.api.client.WebResource resource = client.resource("https://viacep.com.br/viacep.com.br/ws/"+cep+"/json/");
					
			String json = resource.get(String.class);
			Gson gson = new Gson();
			Type type = new TypeToken<EnderecoWS>(){}.getType();
			endereco = gson.fromJson(json, type);
			
		} catch (UniformInterfaceException e) {
			System.out.println("CEP não localizado!" + e);
		    endereco = new EnderecoWS();
		}
		
		return endereco;
	}
}