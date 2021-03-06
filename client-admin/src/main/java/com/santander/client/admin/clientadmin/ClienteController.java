package com.santander.client.admin.clientadmin;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/client")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/get-all")
	public List<Cliente> retrieveClientes(@RequestHeader(value="DATA", required = true) String data){
		this.checkHeader(data);
		return clienteService.retrieveClientes();
	}
	
	@GetMapping("/{id}")
	public Cliente retriveCliente(@RequestHeader(value="DATA", required = true) String data, @PathVariable Long id) throws Exception {
		this.checkHeader(data);
		return clienteService.retriveCliente(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateCliente(@RequestHeader(value="DATA", required = true) String data, Cliente cliente) throws Exception {
		this.checkHeader(data);
		clienteService.updateCliente(cliente);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void deleteCliente(@RequestHeader(value="DATA", required = true) String data, @PathVariable Long id) {
		this.checkHeader(data);
		clienteService.deleteCliente(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createCliente(@RequestHeader(value="DATA", required = true) String data, Cliente cliente) throws Exception {
		this.checkHeader(data);
		clienteService.createCliente(cliente);
	}
	
	private void checkHeader(String data) {
		String key = DigestUtils.sha256Hex("SUPERWALLET");
		if(!key.equals(data)) {
			throw new Error("Key not correct");
		}
		
	}

}
