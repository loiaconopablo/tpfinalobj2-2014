package SistemaGestionProductosTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import SistemaGestionProductos.Cliente;

public class ClienteTest {
	Cliente aux;
	@Before
	public void setUp() throws Exception {
	aux= new Cliente("Timoteo Griguol", 2222222, "Diagonal 42");
	
	}

	@Test
	public void testCliente() {
		assertEquals(aux.getNombre(),"Timoteo Griguol");
		assertEquals(aux.getDireccion(),"Diagonal 42");
		assertEquals(2222222,aux.getDni());
		
	}

	@Test
	public void testCargarPesosEnCC() {
		Double pesos=22.2;
		aux.cargarPesosEnCC(pesos);
		assertEquals(pesos,aux.getCc().getMonto());
		
	}

	@Test
	public void testCargarPedidosEnCCProductos() {
		
	}

	@Test
	public void testGetCc() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCc() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHistorialCompras() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetHistorialCompras() {
		fail("Not yet implemented");
	}

}
