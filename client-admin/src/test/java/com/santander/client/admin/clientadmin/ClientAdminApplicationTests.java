package com.santander.client.admin.clientadmin;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ClientAdminApplicationTests {
	@Mock
	ClienteRepository clienteRepository;
	@InjectMocks private ClienteServiceImpl clienteService;
	
	private Cliente cliente;
	private Cliente cliente2;
	private Cliente cliente3;
	private Long id;
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	@Before
	public void setUp() {
		cliente = new Cliente(1L, "Juan", "Hernández", "Jimenez", new Date(), "JUHJ890502458", 5748965748L, "jhernandez@santander.com");
		cliente2 = new Cliente(2L, "Pedro", "López", "Duarte", new Date(), "PELD810205256", 48965748L, "plopes@santander.com");
		cliente3 = new Cliente(3L, "José", "Gómez", "Salinas", new Date(), "JOGS9103207687", 585675L, "jgomez@santander.com");
		clientes.add(cliente);
		clientes.add(cliente2);
		clientes.add(cliente3);
	}
	
	
	
	@Test
	public void getCliente() throws Exception {
		id=1L;
		when(clienteRepository.findById(id)).thenReturn(Optional.of(cliente));
		Cliente cliente = clienteService.retriveCliente(id);
		assertNotNull(cliente);
	}
	
	@Test
	public void getClientes() {
		when(clienteRepository.findAll()).thenReturn(clientes);
		List<Cliente> clientesRet = clienteService.retrieveClientes();
		assertTrue(clientesRet.size()==3);
	}
	
	@Test
	public void altaCliente() throws Exception {
		Cliente clientTotSave = new Cliente(null, "Juan", "Hernández", "Jimenez", new Date(), "JUHJ890502458", 5748965748L, "jhernandez@santander.com");
		when(clienteRepository.save(clientTotSave)).thenReturn(cliente);
		Cliente savedClient = clienteService.createCliente(clientTotSave);
		assertTrue(savedClient.getId()!=null);
	}
	
	@Test(expected = Exception.class) 
	public void trowsErrorWhenCreateClientWithId() throws Exception {
		Cliente clientTotSave = new Cliente(1L, "Juan", "Hernández", "Jimenez", new Date(), "JUHJ890502458", 5748965748L, "jhernandez@santander.com");
		clienteService.createCliente(clientTotSave);
	}
	
	@Test(expected = Exception.class) 
	public void thowsErrorWhenSpecialCharactersInNombre() throws Exception {
		Cliente clientNameIncorrect = new Cliente(null, "Juan#", "Hernández", "Jimenez", new Date(), "JUHJ890502458", 5748965748L, "jhernandez@santander.com");
		clienteService.createCliente(clientNameIncorrect);
	}
	
	@Test(expected = Exception.class) 
	public void thowsErrorWhenSpecialCharactersInApellidoPaterno() throws Exception {
		Cliente clientNameIncorrect = new Cliente(null, "Juan", "Hernández$", "Jimenez", new Date(), "JUHJ890502458", 5748965748L, "jhernandez@santander.com");
		clienteService.createCliente(clientNameIncorrect);
	}
	
	@Test(expected = Exception.class) 
	public void thowsErrorWhenSpecialCharactersInApellidoMaterno() throws Exception {
		Cliente clientNameIncorrect = new Cliente(null, "Juan", "Hernández", "Jimenez%", new Date(), "JUHJ890502458", 5748965748L, "jhernandez@santander.com");
		clienteService.createCliente(clientNameIncorrect);
	}
	
	@Test(expected = Exception.class)
	public void throwsErrorWhenRfcIsNull() throws Exception {
		Cliente clientNameIncorrect = new Cliente(null, "Juan", "Hernández", "Jimenez", new Date(), null, 5748965748L, "jhernandez@santander.com");
		clienteService.createCliente(clientNameIncorrect);
	}
	
	@Test(expected = Exception.class)
	public void throwsErrorWhenRfcIsEmpty() throws Exception {
		Cliente clientNameIncorrect = new Cliente(null, "Juan", "Hernández", "Jimenez", new Date(), "", 5748965748L, "jhernandez@santander.com");
		clienteService.createCliente(clientNameIncorrect);
	}
	
	@Test(expected = Exception.class)
	public void throwsErrorWhenErrorInEmail() throws Exception {
		Cliente clientNameIncorrect = new Cliente(null, "Juan", "Hernández", "Jimenez", new Date(), "JUHJ890502458", 5748965748L, "jhernandez_santander.com");
		clienteService.createCliente(clientNameIncorrect);
	}
	
}
