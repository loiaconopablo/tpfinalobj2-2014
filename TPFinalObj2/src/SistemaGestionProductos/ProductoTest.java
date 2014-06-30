package SistemaGestionProductos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
		assertTrue(aux.getDescripcion().equals("la mejor yerba del mercado"));
		assertTrue(aux.getNombre().equals("Playadito Suave"));
		assertTrue(aux.getTipo().equals("Yerba Mate"));
		assertTrue(aux.getUnidadMedida().equals("gramos"));
		assertTrue(aux.getMarca().equals("Playadito"));
				
	}

	@Test
	public void testTengoPresentacion() {
		assertTrue(aux.getPresentaciones().contains(aux1));
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
