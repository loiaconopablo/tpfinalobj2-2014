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
import SistemaGestionVentas.VentaADomicilio;

public class PendienteDeEnvioTest {
	Envio envioaux;
	Venta auxventa;
	Double aux;

	@Before
	public void setUp() throws Exception {
			 aux=22.0;
			auxventa=Mockito.mock(VentaADomicilio.class);
			Mockito.when(auxventa.debePagarDiferencia()).thenReturn(aux);
			envioaux=new Envio(auxventa);
			
	}

	@Test
	public void testProcesarEstadoActual() {
		envioaux.procesarEnvio();
		assertEquals(enProceso.class,envioaux.getEstadointerno().getClass());
		
   }
}