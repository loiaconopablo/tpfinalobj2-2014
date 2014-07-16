package SistemaGestionProductosTest;
  
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import SistemaGestionProductos.Presentacion;
import SistemaGestionProductos.Producto;

public class PresentacionTest {
	Presentacion auxpresentacion;
	Producto aux;
	@Before
	public void setUp()  {
		aux=Mockito.mock(Producto.class);
		auxpresentacion=new Presentacion("101", 10, 5,20.14, 17.95, aux,500);
	}

	@Test
	public void testPresentacion() {
		Double aux1=20.14;
		Double aux2=17.95;
		Integer aux3=500;
		assertEquals("101",auxpresentacion.getCodDebarras());
		assertEquals(10,auxpresentacion.getStockMinimo());
		assertEquals(5,auxpresentacion.getStockCritico());
		assertEquals(aux1,auxpresentacion.getPrecioVenta());
		assertEquals(aux2,auxpresentacion.getPrecioCompra());
		assertEquals(aux,auxpresentacion.getProducto());
		assertEquals(aux3,auxpresentacion.getCantDeUnidadDeMedida());
		assertTrue(auxpresentacion.getPrecioHistorico().contains(aux1));
		assertEquals(1,auxpresentacion.getPrecioHistorico().size());
		
	}

	@Test
	public void testSoyDelTipoDeProducto() {
		auxpresentacion.soyDelTipoDeProducto(aux);
	}

	@Test
	public void testCambiarPrecioDeVenta() {
		Double aux1 = 21.12;
		auxpresentacion.cambiarPrecioDeVenta(aux1);
		assertEquals(aux1,auxpresentacion.getPrecioVenta());
		assertEquals(2,auxpresentacion.getPrecioHistorico().size());
	}

}
