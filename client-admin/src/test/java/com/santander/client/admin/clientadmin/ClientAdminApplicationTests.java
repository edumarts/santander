package com.santander.client.admin.clientadmin;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ClientAdminApplicationTests {
	@Mock
	ClienteRepository clienteRepository;
	
	private Cliente cliente;
	private Long id;
	private List<Cliente> clientes;
	
	@Before
	public void setUp() {
		cliente = new Cliente("Juan", "Hernández", "Jimenez", new Date(), "JUHJ890502458", (long)5748965748.0, "jhernandez@santander.com");
		clienteRepository.save(cliente);
			
	}
	
	
	
	@Test
	public void getCliente() {
//		id=1L;
//		Optional cliente = clienteRepository.findById(id);
//		assertThat(cliente.get(), IsAnything.anything());
	}
	
	@Test
	public void getClientes() {
//		clientes = clienteRepository.findAll();
//		assertThat(clientes, IsCollectionWithSize.hasSize(6));
	}

}
