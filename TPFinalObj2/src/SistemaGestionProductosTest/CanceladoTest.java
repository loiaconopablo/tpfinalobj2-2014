package SistemaGestionProductosTest;
import SistemaGestionEnvios.Cancelado;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import SistemaGestionEnvios.Envio;
import SistemaGestionVentas.Venta;

public class CanceladoTest {
	Envio envioaux;
	Venta ventaaux;
	@Before
	public void setUp()  {
		ventaaux=Mockito.mock(Venta.class);
		envioaux=new Envio(ventaaux);
		envioaux.cancelarEnvio("Test");
		
	}

	@Test
	public void testCancelado() {
		envioaux.procesarEnvio();
		assertEquals(Cancelado.class,envioaux.getEstadointerno().getClass());
	}

}
