package br.com.proitec.legacy.ws;

import br.com.proitec.legacy.model.EnderecoWS;
import br.com.proitec.legacy.ws.supplier.SupplierWebClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * Classe responsavel por consumir/receber as infomações de um webservice 'qualquer'
 * para representar um objeto Endereco  {@link EnderecoWS}
 * @author fredyefra
 * @see EnderecoConsumer
 */

@Service
public class EnderecoConsumer implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(EnderecoConsumer.class);
    private final SupplierWebClient<WebClient> webClientSupplier;

    protected EnderecoConsumer(){
        webClientSupplier = () -> WebClient.create("https://viacep.com.br/viacep.com.br");
    }

    private EnderecoWS endereco;

    @Deprecated
    public EnderecoWS enderecoConsumer(String cep) {

        try {
            com.sun.jersey.api.client.Client client = Client.create();
            com.sun.jersey.api.client.WebResource resource = client.resource("https://viacep.com.br/viacep.com.br/ws/" + cep + "/json/");

            String json = resource.get(String.class);
            Gson gson = new Gson();
            Type type = new TypeToken<EnderecoWS>() {
            }.getType();
            endereco = gson.fromJson(json, type);

        } catch (UniformInterfaceException e) {
            System.out.println("CEP não localizado!" + e);
            endereco = new EnderecoWS();
        }

        return endereco;
    }

    protected Mono<EnderecoWS> enderecoConsumerv2(final String cep) {

        WebClient webClient = this.webClientSupplier.get();

        Mono<EnderecoWS> enderecoWS = webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/ws/")
                        .path(cep)
                        .path("/json/")
                        .build())
                .header("Content-Type", "application/json")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(EnderecoWS.class);

        enderecoWS.subscribe(endereco -> log.info("# {}", endereco));

        log.info("# {}", cep);

        return enderecoWS;
    }
}