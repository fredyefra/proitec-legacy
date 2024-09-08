package br.com.proitec.legacy.ws.supplier;

import java.util.function.Supplier;

/**
 * Representa um fornecedor de resultados, nesse caso @{@link org.springframework.web.reactive.function.client.WebClient}.
 * A ideia é que todos serviços consumidos externamente sejam fornecidos por essa interface
 *
 * @author fredyefra
 */

public interface SupplierWebClient<T> extends Supplier<T> {

    @Override
    T get();
}
