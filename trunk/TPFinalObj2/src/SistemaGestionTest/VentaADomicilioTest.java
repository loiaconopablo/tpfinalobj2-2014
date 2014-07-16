package SistemaGestionTest;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import SistemaGestionProductos.Cliente;
import SistemaGestionProductos.Pedido;
import SistemaGestionVentas.VentaADomicilio;

public class VentaADomicilioTest {
	VentaADomicilio auxventa;
	Cliente auxcliente;
	Pedido  auxpedido;

	@Before
	public void setUp() throws Exception {
		auxcliente=mock(Cliente.class);
		auxpedido=mock(Pedido.class);
		auxventa=new VentaADomicilio(auxcliente,auxpedido);
	}

	@Test
	public void testVentaADomicilio() {
		DateTime aux1=new DateTime();
		assertEquals(auxcliente,auxventa.getCliente());
		assertEquals(auxpedido,auxventa.getPedido());
		assertEquals(aux1.getDayOfYear(),auxventa.getFechaDeVenta().getDayOfYear());
	}



	
	@Test
	public void testDebePagarDiferencia() {
		fail("Not yet implemented");
	}

}
