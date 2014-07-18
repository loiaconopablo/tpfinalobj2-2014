package SistemaGestionProductosTest;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import SistemaGestionEnvios.Cancelado;
import SistemaGestionEnvios.Enviado;
import SistemaGestionEnvios.Envio;
import SistemaGestionEnvios.PendienteDeEnvio;
import SistemaGestionEnvios.Reprogramado;
import SistemaGestionEnvios.enProceso;
import SistemaGestionVentas.Venta;

public class EnvioTest {
	Envio auxenvio;
	Venta auxventa;
	
	@Before
	public void setUp() {
		auxventa=Mockito.mock(Venta.class);
		auxenvio=new Envio(auxventa);
	}

	@Test
	public void testEnvio() { 
		DateTime auxfecha= new DateTime();
		assertEquals(auxventa,auxenvio.getVenta());
		assertEquals(auxfecha.getDayOfYear(),auxenvio.getFechadeenvio().getDayOfYear());
	}


	@Test
	public void testCancelarEnvio() {
		auxenvio.cancelarEnvio("Test");
		assertEquals(auxenvio.getEstadointerno().getClass(),Cancelado.class);
	}
	@Test
	public void testResetearEstadoEnvio() {
		auxenvio.cancelarEnvio("Test");
		assertEquals(auxenvio.getEstadointerno().getClass(),Cancelado.class);
		auxenvio.resetearEstadoEnvio();
		assertEquals(PendienteDeEnvio.class,auxenvio.getEstadointerno().getClass());
	}

	@Test
	public void testReprogramarEnvio() {
		DateTime auxdatetime=new DateTime();
		auxenvio.reprogramarEnvio(auxdatetime);
	    assertEquals(Reprogramado.class,auxenvio.getEstadointerno().getClass());
	}

	@Test
	public void testEnvioEnProceso() {
		auxenvio.envioEnProceso((double)22);
		assertEquals(enProceso.class,auxenvio.getEstadointerno().getClass());
	}
	
	

	@Test
	public void testEnvioEntregado() {
		auxenvio.envioEntregado();
		assertEquals(Enviado.class,auxenvio.getEstadointerno().getClass());
	}

}
