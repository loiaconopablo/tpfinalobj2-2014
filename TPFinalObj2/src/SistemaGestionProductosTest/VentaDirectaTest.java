package SistemaGestionProductosTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class VentaDirectaTest {

	VentaCC ventaAux;
	Cliente clienteAux;
	Pedido pedidoAux;
	
	@Before 
	public void setUp(){
		
		clienteAux = mock(Cliente.class);
		pedidoAux = mock(Pedido.class);
		ventaAux = new VentaCC(clienteAux,pedidoAux);
	}
	
	@Test
	public void testVentaDirecta() {
		DateTime fecha = new DateTime();
		assertEquals(clienteAux,ventaAux.getCliente());
		assertEquals(pedidoAux,ventaAux.getPedido());
		assertEquals(fecha.getDayOfYear(),ventaAux.getFechaDeVenta().getDayOfYear());
	}

	@Test
	public void testDebePagarDiferencia() {
		fail("Not yet implemented");
	}

}
