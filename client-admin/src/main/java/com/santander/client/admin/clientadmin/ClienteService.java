package com.santander.client.admin.clientadmin;

import java.util.List;

public interface ClienteService {

	List<Cliente> retrieveClientes();

	Cliente retriveCliente(Long id) throws Exception;

	Cliente updateCliente(Cliente cliente) throws Exception;

	void deleteCliente(Long id);

	Cliente createCliente(Cliente cliente) throws Exception;

}