package com.santander.client.admin.clientadmin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteServiceImpl implements ClienteService {
	String nameReg = "^[\\wÀ-ÖØ-öø-ÿ\\s]*$";
	String emailReg = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> retrieveClientes(){
		return clienteRepository.findAll();
	}
	
	@Override
	public Cliente retriveCliente(Long id) throws Exception {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		if(cliente.isPresent()) {
			return cliente.get();
		}else {
			throw new Exception("Not found");
		}
	}
	
	@Override
	public Cliente updateCliente(Cliente cliente) throws Exception {
		validate(cliente);
		return clienteRepository.save(cliente);
	}
	
	@Override
	public void deleteCliente(Long id) {
		clienteRepository.deleteById(id);
	}
	
	@Override
	public Cliente createCliente(Cliente cliente) throws Exception {
		if(cliente.getId()!=null) {
			throw new Exception("El id del cliente no se debe especificar en un alta");
		}
		validate(cliente);
		return clienteRepository.save(cliente);
	}
	
	private void validate(Cliente cliente) throws Exception {
		if(cliente.getNombre()!=null) {
			if(!cliente.getNombre().matches(nameReg)) {
				throw new Exception("Nombre no puede tener caracteres especiales");
			}
		}
		if(cliente.getApellidoPaterno()!=null) {
			if(!cliente.getApellidoPaterno().matches(nameReg)) {
				throw new Exception("Apellido Paterno no puede tener caracteres especiales");
			}
		}
		if(cliente.getApellidoMaterno()!=null) {
			if(!cliente.getApellidoMaterno().matches(nameReg)) {
				throw new Exception("Apellido Materno no puede tener caracteres especiales");
			}
		}
		if(cliente.getRfc()==null || cliente.getRfc().isEmpty()) {
			throw new Exception("RFC es requerido");
		}
		if(cliente.getEmail()!=null) {
			if(!cliente.getEmail().matches(emailReg)) {
				throw new Exception("Email incorrecto");
			}
		}
	}

}
