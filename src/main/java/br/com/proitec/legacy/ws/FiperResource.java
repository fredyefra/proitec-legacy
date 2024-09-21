package br.com.proitec.legacy.ws;


import br.com.proitec.legacy.model.FipeVeiculoWS;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Disponibiliza o recurso veiculo da classe {@link br.com.proitec.legacy.model.FipeVeiculoWS} para qualquer classe 'consumidora' de veiculos
 *
 * @author fredyefra
 * @see FipeConsumer
 */

@RestController
@RequestMapping(value = "api/veiculo")
public class FiperResource {

    @Inject
    private FipeConsumer fipeConsumer;

    @GetMapping(value = "/{veiculo}/ws", produces = MediaType.APPLICATION_JSON)
    public List<FipeVeiculoWS> findVeiculo(@PathVariable String veiculo){
        return fipeConsumer.veiculoTipo(veiculo).collectList().block();
    }
}