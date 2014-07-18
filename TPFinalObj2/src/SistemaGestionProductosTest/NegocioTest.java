package SistemaGestionProductosTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import SistemaGestionProductos.Cliente;
import SistemaGestionProductos.Negocio;
import SistemaGestionProductos.Sucursal;

public class NegocioTest {

	Negocio negocio;
	Cliente cliente;
	Sucursal sucur;
	@Before
	public void setUp() throws Exception {
		negocio = new Negocio("COTO");
		cliente = Mockito.mock(Cliente.class);
		sucur = Mockito.mock(Sucursal.class);
		when(sucur.getIdSucursal()).thenReturn(5);
		
		
	}

	@Test
	public void testNegocio() {
		assertEquals("COTO", negocio.getNombre());
		assertTrue(negocio.getClientes().size()==1);
		assertTrue(negocio.getSucursales().size()==0);
		assertTrue(negocio.getCaja()==0.00);		
	}
	
	@Test
	public void TestGenerarNuevaSucursal(){
		negocio.generarNuevaSucursal(1);
		assertTrue(negocio.getSucursales().size()==1);
		
	}
	@Test
	public void TestAgregarCliente(){
	negocio.agregarCliente(cliente);
		assertTrue(negocio.getClientes().size()==2);
		assertEquals(cliente, negocio.getClientes().get(1));
	}
	@Test
	public void TestDevolverSucural(){
		negocio.getSucursales().add(sucur);
		assertEquals(sucur,negocio.devolverSucural(5));
	}
	
}
