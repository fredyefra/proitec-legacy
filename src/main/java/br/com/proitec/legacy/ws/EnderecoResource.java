package br.com.proitec.legacy.ws;

import br.com.proitec.legacy.model.EnderecoWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.ws.rs.core.MediaType;

/**
 * Disponibiliza o recurso endereço da classe {@link EnderecoConsumer} para qualquer classe 'consumidora' de endereços
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
        return enderecoConsumer
                .enderecoConsumerv2(cep)
                .block();
    }

    //@GetMapping(value = "/{cep}/ws", produces = MediaType.APPLICATION_JSON)
    public Mono<EnderecoWS> findCep2(@PathVariable String cep) {
        return enderecoConsumer.enderecoConsumerv2(cep);
    }
}