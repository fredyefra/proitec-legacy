package br.com.proitec.legacy.enderecows;

import br.com.proitec.legacy.enderecows.supplier.SupplierWebClient;
import br.com.proitec.legacy.model.FipeVeiculoWS;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.Serializable;
import java.util.List;

@Service
public class FipeConsumer implements Serializable {

    private static final long serialVersionUID = 1L;

    private SupplierWebClient<WebClient> webClientSupplier;

    protected FipeConsumer(){
        webClientSupplier = () -> WebClient.create("https://fipe.parallelum.com.br");
    }

    public List<FipeVeiculoWS> veiculoTipo (final String veiculoTipo){

        //exemplo veiculo tipo: "cars" "motorcycles" "trucks"

        //SupplierWebClient<WebClient> webClientSupplier = () -> WebClient.create("https://fipe.parallelum.com.br");

        WebClient webClient = this.webClientSupplier.get();

                return webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/api")
                        .path("/v2/")
                        .path(veiculoTipo)
                        .path("/brands/")
                        .build())
                        .header("Content-Type", "application/json")
                        .accept(org.springframework.http.MediaType.APPLICATION_JSON)
                        //.header("X-Subscription-Token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwiZW1haWwiOiJleGFtcGxlLmNvbSIsImlhdCI6MTUxNjIzOTAyMn0.CmNu23cNxIhxZa9TABqIPD2t3Ja6Vmu_B0l2DJfiIaA")
                .retrieve()
                .bodyToFlux(FipeVeiculoWS.class)
                .collectList()
                .block();
    }
}
