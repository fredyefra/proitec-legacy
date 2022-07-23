package br.com.proitec.legacy.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.proitec.legacy.model.Cliente;
import br.com.proitec.legacy.model.Cliente_;
import br.com.proitec.legacy.repository.ClienteRepository;

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
	 * @param {@link int, int}
	 * @return {@code Page}
	 */
	public Page<Cliente> findAll(int pageNum,int pageSize) { 
		Sort sort = Sort.by(Direction.ASC,Cliente_.identificador.toString());
		Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
		return repository.findAll(pageable); 
	}

	/**
	 * @param {@link Long}
	 * @return {@code Optional}
	 */
	public Optional<Cliente> findById(Long id) {
		Optional<Cliente>  optional = repository.findById(id);
		return optional;
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
	public Cliente update(Long id, Cliente obj) {
		Optional<Cliente> optional = findById(id);
		Cliente cliente = optional.get(); // 
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