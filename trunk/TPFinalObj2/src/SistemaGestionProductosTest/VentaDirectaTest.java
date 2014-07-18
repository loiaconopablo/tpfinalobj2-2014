package SistemaGestionProductosTest;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import SistemaGestionProductos.Cliente;
import SistemaGestionProductos.Pedido;
import SistemaGestionVentas.VentaCC;

public class VentaDirectaTest {

	VentaCC ventaAux;
	Cliente clienteAux;
	Pedido pedidoAux;
	
	@Before 
	public void setUp(){
		
		clienteAux = Mockito.mock(Cliente.class);
		pedidoAux = Mockito.mock(Pedido.class);
		ventaAux = new VentaCC(clienteAux,pedidoAux);
	}
	
	@Test
	public void testVentaDirecta() {
		DateTime fecha = new DateTime();
		assertEquals(clienteAux,ventaAux.getCliente());
		assertEquals(pedidoAux,ventaAux.getPedido());
		assertEquals(fecha.getDayOfYear(),ventaAux.getFechaDeVenta().getDayOfYear());
	}


}
