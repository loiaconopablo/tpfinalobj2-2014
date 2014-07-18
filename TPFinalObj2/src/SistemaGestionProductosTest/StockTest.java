package SistemaGestionProductosTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import SistemaGestionProductos.Ficha;
import SistemaGestionProductos.Pedido;
import SistemaGestionProductos.Presentacion;
import SistemaGestionProductos.Producto;
import SistemaGestionProductos.Stock;

public class StockTest {
	
	
	Ficha ficha;
	Ficha ficha2;
	Presentacion presentacionUno;
	Presentacion presentacionDos;
	Stock stock;
	Producto p;
	Pedido ped;
	List<Ficha> listFichas;
	
	@Before
	public void setUp() throws Exception {
		stock = new Stock();
		ficha= Mockito.mock(Ficha.class);
		ficha2= Mockito.mock(Ficha.class);
		p = Mockito.mock(Producto.class);
		ped = Mockito.mock(Pedido.class);
		presentacionUno= new Presentacion("A",0,0,(double)100,(double)0,p,0);
		presentacionDos= new Presentacion("B",0,0,(double)100,(double)0,p,0);
		listFichas = new ArrayList<>();
		listFichas.add(ficha);
		listFichas.add(ficha2);
		Mockito.when(ficha.getPresentacion()).thenReturn(presentacionUno);
		Mockito.when(ficha2.getPresentacion()).thenReturn(presentacionDos);
		Mockito.when(ped.getFichas()).thenReturn(listFichas);
		
	}
	
	@Test
	public void testStock() {
		assertTrue(stock.getFichas().size()==0);;
	}

	@Test
	public void testAgregarFichaAlStock() {
		stock.agregarFichaAlStock(ficha);
		assertTrue(stock.getFichas().size()>0);
	}

	@Test
	public void testRetornarPedidoAlStock() {
		stock.retornarPedidoAlStock(ped);
		assertTrue(stock.getFichas().size()==2);
		
	}

	@Test
	public void testAgregarPedidoAlStock() {
		stock.agregarPedidoAlStock(ped);
		assertTrue(stock.getFichas().size()>2);
	}

	@Test
	public void testGenerarPedidoEnStock() {
		fail("Not yet implemented");
	}

	@Test
	public void testGenerarPedidoSinStock() {
		fail("Not yet implemented");
	}

	@Test
	public void testGenerarPresentacionesEnEstadoCritico() {
		fail("Not yet implemented");
	}

	@Test
	public void testGenerarPresentacionesEnEstadoMinimo() {
		fail("Not yet implemented");
	}

	@Test
	public void testHayStock() {
		fail("Not yet implemented");
	}

	@Test
	public void testDescontarFichaAlStock() {
		fail("Not yet implemented");
	}

	@Test
	public void testDescontarPedidoDelStock() {
		fail("Not yet implemented");
	}

	@Test
	public void testVerificarStock() {
		fail("Not yet implemented");
	}

}
