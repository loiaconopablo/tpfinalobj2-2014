package SistemaGestionProductosTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import SistemaGestionProductos.Presentacion;
import SistemaGestionProductos.Producto;

public class ProductoTest {
	Producto aux;
	Presentacion aux1,aux2;

	@Before
	public void setUp() throws Exception {
		aux=new Producto("la mejor yerba del mercado","Playadito Suave","Yerba Mate","gramos","Playadito");
		aux1=new Presentacion("101", 10, 5,20.14, 17.95, aux,500);
		aux2=new Presentacion("110",10,5,35.17,30.08,aux,1000);
	}

	@Test
	public void testProducto() {
		assertEquals("la mejor yerba del mercado",aux.getDescripcion());
		assertEquals("Playadito Suave",aux.getNombre());
		assertEquals("Yerba Mate",aux.getTipo());
		assertEquals("gramos",aux.getUnidadMedida());
		assertEquals("Playadito",aux.getMarca());
				
	}

	@Test
	public void testTengoPresentacion() {
		aux.agregarPresentacion(aux1);
		assertTrue(aux.tengoPresentacion(aux1));
	}

	@Test
	public void testEsDeMiTipo() {
		assertTrue(aux.esDeMiTipo("Yerba Mate"));
		
	}
	@Test
	public void testNoEsDeMiTipo() {
		assertFalse(aux.esDeMiTipo("Lacteo"));
		
	}
	@Test
	public void testQuitarPresentacion() {
		aux.quitarPresentacion(aux1);
		assertFalse(aux.getPresentaciones().contains(aux1));
		assertTrue(aux.getPresentaciones().contains(aux2));
	}

}
