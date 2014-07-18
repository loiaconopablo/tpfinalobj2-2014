package SistemaGestionProductosTest;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import SistemaGestionEnvios.Enviado;
import SistemaGestionEnvios.Envio;
import SistemaGestionEnvios.enProceso;
import SistemaGestionVentas.Venta;

public class enProcesoTest {
	Envio envioaux;
	Venta ventaaux;
	DateTime fechaaux,fechaaux1;
	Double aux;

	@Before
	
	public void setUp() throws Exception {
		aux=22.0;
		ventaaux=Mockito.mock(Venta.class);
	envioaux=new Envio(ventaaux);
	}

	@Test
	public void testProcesarEstadoActualPasadaFecha() {
		fechaaux1=new DateTime(2013,12,24,0,0);
		envioaux.reprogramarEnvio(fechaaux1);
		envioaux.procesarEnvio();
		envioaux.envioEnProceso(aux);
		envioaux.procesarEnvio();
		assertEquals(Enviado.class,envioaux.getEstadointerno().getClass());
	}
	
	@Test
	public void testProcesarEstadoActualFechaAnterior() {
		fechaaux=new DateTime(2014,12,24,0,0);
		envioaux.reprogramarEnvio(fechaaux);
		envioaux.procesarEnvio();
		envioaux.envioEnProceso(aux);
		envioaux.procesarEnvio();
		assertEquals(enProceso.class,envioaux.getEstadointerno().getClass());
	}

}
