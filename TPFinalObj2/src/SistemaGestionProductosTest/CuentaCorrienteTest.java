package SistemaGestionProductosTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import SistemaGestionProductos.CuentaCorriente;
import SistemaGestionProductos.Pedido;

public class CuentaCorrienteTest {
	CuentaCorriente cuentaAux;
	Pedido auxpedido;
	

	@Before
	public void setUp() throws Exception {
		 cuentaAux= new CuentaCorriente();
		 auxpedido=mock(Pedido.class);
		when(auxpedido.getPrecio()).thenReturn(19.00);
	}

	@Test
	public void testCuentaCorriente() {
		Double aux=0.0;
		assertEquals(aux,cuentaAux.getMonto());
	}

	@Test
	public void testActualizarCCconPlata() {
		Double auxDouble=20.12;
		cuentaAux.actualizarCCconPlata(auxDouble);
		assertEquals(auxDouble,cuentaAux.getMonto());
	}

	@Test
	public void testActualizarCCconPedido() {
		Double auxDouble=19.00;
		cuentaAux.actualizarCCconPedido(auxpedido);
		assertEquals(auxDouble,cuentaAux.getMonto());
	}

	@Test
	public void testDescontarPlata() {
		Double auxDouble=1.0;
		cuentaAux.actualizarCCconPlata(20.00);
		cuentaAux.descontarPlata(auxpedido);
		assertEquals(auxDouble,cuentaAux.getMonto());
	}
	
	// Falta Test si plata no alcanza(ver que el metodo tiene que tirar una exception)

}
