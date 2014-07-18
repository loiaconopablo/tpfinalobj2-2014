package SistemaGestionProductosTest;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import SistemaGestionEnvios.Envio;
import SistemaGestionVentas.Venta;
import SistemaGestionVentas.VentaADomicilio;

public class ReprogramadoTest {
	Envio envioaux;
	Venta auxventa;
	DateTime auxfecha;
	@Before
	public void setUp(){
		auxfecha=new DateTime(2014,12,24,0,0);
		auxventa=Mockito.mock(VentaADomicilio.class);
		envioaux=new Envio(auxventa);
		envioaux.reprogramarEnvio(auxfecha);
	}

	@Test
	public void testProcesarEnvio() {
		assertEquals(auxfecha,envioaux.getFechadeenvio());
	}

}
