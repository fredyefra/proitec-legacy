package br.com.proitec.legacy.ws;

import br.com.proitec.legacy.model.FipeVeiculoWS;
import br.com.proitec.legacy.ws.supplier.SupplierWebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Serializable;

@Service
public class FipeConsumer implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(FipeConsumer.class);
    private final SupplierWebClient<WebClient> webClientSupplier;

    protected FipeConsumer(){
        webClientSupplier = () -> WebClient.create("https://fipe.parallelum.com.br");
    }

    protected Flux<FipeVeiculoWS> veiculoTipo (final String veiculoTipo){

        //exemplo veiculo tipo: "cars" "motorcycles" "trucks"

        WebClient webClient = this.webClientSupplier.get();

        Flux<FipeVeiculoWS> fipeVeiculoWS = webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/api")
                        .path("/v2/")
                        .path(veiculoTipo)
                        .path("/brands/")
                        .build())
                .header("Content-Type", "application/json")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(FipeVeiculoWS.class);

        fipeVeiculoWS.subscribe(resultado -> log.info("# {}", resultado));

        log.info("# {}", veiculoTipo);

        return fipeVeiculoWS;

    }

    protected Mono<FipeVeiculoWS> veiculoTipoMono (final String veiculoTipo){

        //exemplo veiculo tipo: "cars" "motorcycles" "trucks"

        WebClient webClient = this.webClientSupplier.get();

        Mono<FipeVeiculoWS> fipeVeiculoWS = webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/api")
                        .path("/v2/")
                        .path(veiculoTipo)
                        .path("/brands/")
                        .build())
                .header("Content-Type", "application/json")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(FipeVeiculoWS.class);

        fipeVeiculoWS.subscribe(resultado -> log.info("# {}", resultado));

        log.info("# {}", veiculoTipo);

        return fipeVeiculoWS;

    }
}