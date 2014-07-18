package SistemaGestionProductosTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import SistemaGestionProductos.Cliente;
import SistemaGestionProductos.CuentaCorriente;
import SistemaGestionVentas.Venta;

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
	public void testGetCcVacia() {
		Double aux1=0.0;
		assertEquals(aux1,aux.getCc().getMonto());
	}
	
	@Test
	public void testGetCcConDinero(){
		aux.getCc().actualizarCCconPlata(20.2);
		Double aux1=20.2;
		assertEquals(aux1,aux.getCc().getMonto());
		
	}

	@Test
	public void testSetCc() {
		CuentaCorriente ccaux=Mockito.mock(CuentaCorriente.class);	
		aux.setCc(ccaux);
		assertEquals(ccaux,aux.getCc());	
	}

	@Test
	public void testGetHistorialCompras() {
		assertEquals(new ArrayList<Venta>(), aux.getHistorialCompras());
	}

	@Test
	public void testSetHistorialCompras() {
		ArrayList <Venta> list = new ArrayList<Venta>();
		aux.setHistorialCompras(list);
		assertEquals(list, aux.getHistorialCompras());
	}


}
