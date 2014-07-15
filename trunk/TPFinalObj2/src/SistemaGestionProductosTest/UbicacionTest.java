package SistemaGestionProductosTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock.*;
import org.mockito.Mockito;

import SistemaGestionProductos.Presentacion;
import SistemaGestionProductos.Producto;
import SistemaGestionProductos.Ubicacion;

public class UbicacionTest {

	Ubicacion u;
	Ubicacion uAux;
	List<Producto> productos;
	Producto p;
	
	@Before 
	public void setUp(){
		u = new Ubicacion("4a", "1");
		productos = new ArrayList<Producto>();
		uAux = new Ubicacion("1b", "2", productos);
		p = Mockito.mock(Producto.class);
		
	}
	
	@Test
	public void testUbicacion() {
		assertEquals("4a", u.getFila());
		assertEquals("1", u.getGondola());
	}
	
	@Test 
	public void testUbicacionConProductos(){
		u.setProductos(productos);
		u.getProductos().add(p);
		assertEquals("4a", u.getFila());
		assertEquals("1", u.getGondola());
		assertEquals(productos, u.getProductos());
	}
	
	@Test
	public void testAgregarProducto(){
		u.agregarProducto(p);
		assertTrue(u.getProductos().contains(p));
	}
	@Test
	public void testSacarProducto(){
		u.sacarProducto(p);
		assertFalse(u.getProductos().contains(p));
	}
	@Test
	public void testEstaElProducto(){
		u.agregarProducto(p);
		assertTrue(u.estaElProducto(p));
	}
}
