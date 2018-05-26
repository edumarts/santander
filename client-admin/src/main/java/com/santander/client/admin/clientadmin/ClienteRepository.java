package com.santander.client.admin.clientadmin;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	List<Cliente> findAll();
	Optional<Cliente> findById(Long id);
}
