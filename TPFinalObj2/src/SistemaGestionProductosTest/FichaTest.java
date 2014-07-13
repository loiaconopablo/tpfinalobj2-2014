package SistemaGestionProductosTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Mock.*;
import org.mockito.Mockito.*;

import SistemaGestionProductos.Ficha;
import SistemaGestionProductos.Presentacion;

public class FichaTest {
	Presentacion p;
	Ficha f;

	@Before
	public void setUp() {
		 p = Mockito.mock(Presentacion.class);
		Mockito.when(p.getPrecioVenta()).thenReturn(5.5);
		f=new Ficha(p, 10);
			
	}

	@Test
	public void testFicha() {
		assertEquals(f.getCantidad(), 10);
		assertEquals(f.getPresentacion(),p);
	}

	@Test
	public void testPrecio() {
		Double daux=55.0;
		assertEquals(daux,f.getPrecio());
	}

	@Test
	public void testAumentarCant() {
		f.aumentarCant(5);
		assertEquals(15,f.getCantidad());
		
	}

	@Test
	public void testDescontarCant() {
		f.descontarCant(5);
		assertEquals(5,f.getCantidad());
	}

	@Test
	public void testTienePresentacion() {
		assertTrue(f.tienePresentacion(p));
	}

	

	@Test
	public void testVerificarCantidadPresentacionMenor() {
		Ficha faux=Mockito.mock(Ficha.class);
		Mockito.when(faux.getCantidad()).thenReturn(8);
		assertTrue(f.verificarCantidadPresentacion(faux));
	}
	@Test
	public void testVerificarCantidadPresentacionMayor() {
		Ficha faux=Mockito.mock(Ficha.class);
		Mockito.when(faux.getCantidad()).thenReturn(12);
		assertFalse(f.verificarCantidadPresentacion(faux));
	}

}
