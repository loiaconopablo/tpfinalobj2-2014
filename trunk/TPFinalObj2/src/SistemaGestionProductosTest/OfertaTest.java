package SistemaGestionProductosTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import SistemaGestionProductos.Ficha;
import SistemaGestionProductos.Oferta;
import SistemaGestionProductos.Pedido;
import SistemaGestionProductos.Presentacion;
import SistemaGestionProductos.Producto;

public class OfertaTest {
	Oferta oferta;
	Producto p;
	Ficha f;
	Ficha fi;
	Pedido pedido;
	Presentacion presentacionUno;
	Presentacion presentacionDos;

	@Before
	public void setUp() throws Exception {
		oferta = new Oferta(10);
		p = Mockito.mock(Producto.class);
		presentacionDos= new Presentacion("",0,0,20,0,p,0);
		presentacionUno= new Presentacion("",0,0,100,0,p,0);
		f = new Ficha(presentacionUno,1);
		fi = new Ficha(presentacionDos,1);
		pedido = Mockito.mock(Pedido.class);
		List<Ficha> res = new ArrayList<Ficha>();
		res.add(f);res.add(fi);
		Mockito.when(pedido.getFichas()).thenReturn(res);
	}

	@Test
	public void testOferta() {
		assertEquals(10, oferta.getPorcentajeDescuento());
		assertEquals(Oferta.class, oferta.getClass());
	}

	@Test
	public void testGetProductos() {
		assertEquals(new ArrayList<Producto>(), oferta.getProductos());
	}

	@Test
	public void testSetProductos() {
		List<Producto> a = new ArrayList<Producto>();
		oferta.setProductos(a);
		assertEquals(a,oferta.getProductos());
	}

	@Test
	public void testGetPorcentajeDescuento() {
		assertEquals(oferta.getPorcentajeDescuento(), 10);
	}

	@Test
	public void testSetPorcentajeDescuento() {
		oferta.setPorcentajeDescuento(12);
		assertEquals(oferta.getPorcentajeDescuento(), 12);
		oferta.setPorcentajeDescuento(24);
		assertTrue(oferta.getPorcentajeDescuento()==24);
	}

	@Test
	public void testAgregarProductoAlaOferta() {
		oferta.agregarProductoAlaOferta(p);
		assertTrue(oferta.getProductos().size()==1);
		assertTrue(oferta.getProductos().get(0)==p);
		
	}

	@Test
	public void testAplicarDescuentos() {
		oferta.agregarProductoAlaOferta(p);
		oferta.aplicarDescuentos(pedido);
		assertTrue((pedido.getFichas().get(1).getPrecio())==18);
		assertTrue(pedido.getFichas().get(0).getPrecio()==90);
		
	}

}
