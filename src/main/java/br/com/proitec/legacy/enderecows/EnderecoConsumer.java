package br.com.proitec.legacy.enderecows;

import br.com.proitec.legacy.enderecows.supplier.SupplierWebClient;
import br.com.proitec.legacy.model.EnderecoWS;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
* Classe responsavel por desserializar o Json especificado em um objeto do tipo {@link EnderecoWS}
*
* @author fredyefra
* @see EnderecoConsumer
*/


@Service
public class EnderecoConsumer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EnderecoWS endereco;

	@Deprecated
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

	public EnderecoWS enderecoConsumerv2 (final String cep){

		//WebClient webClient = WebClient.create("https://viacep.com.br/viacep.com.br");

		SupplierWebClient<WebClient> webClientSupplier = () -> WebClient.create("https://viacep.com.br/viacep.com.br");

		WebClient webClient = webClientSupplier.get();

		return  webClient
				.get()
				.uri(uriBuilder -> uriBuilder.path("/ws/")
						.path(cep)
						.path("/json/")
				        .build())
				        .header("Content-Type", "application/json")
				        .accept(org.springframework.http.MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(EnderecoWS.class)
				.block();
	}
}