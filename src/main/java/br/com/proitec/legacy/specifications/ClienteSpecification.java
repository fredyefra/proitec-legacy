package br.com.proitec.legacy.specifications;

import java.io.Serializable;

import org.springframework.data.jpa.domain.Specification;

import br.com.proitec.legacy.model.Cliente;
import br.com.proitec.legacy.model.Cliente_;

public class ClienteSpecification implements Serializable {

	private static final long serialVersionUID = 1L;

	
	public static Specification<Cliente> byNome(String nome) {
		return (root, query, builder) -> 
		builder.
		 like(root.get(Cliente_.nome), nome);
	}
}