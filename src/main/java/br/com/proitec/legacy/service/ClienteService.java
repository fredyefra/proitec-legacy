package br.com.proitec.legacy.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.proitec.legacy.model.Cliente;
import br.com.proitec.legacy.repository.ClienteRepository;
import br.com.proitec.legacy.specifications.ClienteSpecification;

/**
* Classe responsavel pelas operações na base de dados
*
* @author fredyefra
* @see ClienteService 
*/

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	/**
	 * @return {@code Collection List}
	 */
	public List<Cliente> findAll() { 
		return repository.findAll(); 
	}

	/**
	 * @param {@link String}
	 * @return {@code Collection List}
	 */
	public List<Cliente> findAll(String nome) { 
		return repository.findAll(Specification.where(ClienteSpecification.byNome(nome))); 
	}

	/**
	 * @param {@link Long}
	 * @return {@code Optional}
	 */
	public Cliente findById(Long id) {
		Optional<Cliente>  optional = repository.findById(id);
		Cliente cliente = optional.get();
		return cliente;
	}

	/**
	 * if id null jpa save object
	 * 
	 * @param {@link Cliente}
	 * @return {@code Cliente}
	 */
	public Cliente save(Cliente  cliente) {
		cliente.setIdentificador(null); 
		return repository.save(cliente);
	}

	//@Transactional
	public List<Cliente> saveAll(Collection<Cliente> entities) {

		List<Cliente> result = new ArrayList<Cliente>();

		for (Cliente entity : entities) {
			result.add(save(entity));
		}
     	return result;
	}

    /**
	 * if id exist jpa update object
	 * 
	 * @param {@link Long, Cliente}
	 * @return {@code Cliente}
	 */
	public Cliente update(Long id, Cliente param) {
		Cliente cliente = findById(id);
		cliente.setNome(param.getNome());
		cliente.setTelefone(param.getTelefone());
		cliente.setEmail(param.getEmail());
		cliente.setEndereco(param.getEndereco());
		return repository.save(cliente);
	}

	/**
	 * if id exist jpa delete object
	 * 
	 * @param {@link Long}
	 * @return {@code void}
	 */
	public void delete (Long id) {
		repository.deleteById(id);		
	}
}