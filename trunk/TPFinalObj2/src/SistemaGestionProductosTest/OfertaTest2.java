package SistemaGestionProductosTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import SistemaGestionProductos.Oferta;
import SistemaGestionProductos.Producto;

public class OfertaTest2 {
	Oferta auxoferta;
	Producto auxProducto;
	
	
	

	@Before
	public void setUp() throws Exception {
		int auxDouble=22;
		auxoferta= new Oferta(auxDouble);
		auxProducto=mock(Producto.class);
		
	}

	@Test
	public void testOferta() {
		int auxDouble1= 22;
		assertEquals(auxDouble1,auxoferta.getPorcentajeDescuento());
		assertTrue(auxoferta.getProductos().isEmpty());
	}


	@Test
	public void testAgregarProductoAlaOferta() {
	auxoferta.agregarProductoAlaOferta(auxProducto);
	assertTrue(auxoferta.getProductos().contains(auxProducto));
	}

//	@Test
//	public void testAplicarDescuentos() {
//		
//		
//	}


}
