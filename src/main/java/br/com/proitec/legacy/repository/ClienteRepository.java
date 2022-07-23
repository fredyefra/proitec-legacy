package br.com.proitec.legacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.proitec.legacy.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> , JpaSpecificationExecutor<Cliente> {

}
