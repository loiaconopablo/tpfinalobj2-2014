package SistemaGestionProductosTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import SistemaGestionProductos.*;

public class PedidoTest {
	Pedido auxpedido;
	Ficha auxficha,auxficha2,auxficha3;
	Presentacion auxpresentacion;
	Producto auxproducto;

	@Before
	public void setUp() throws Exception {
		auxficha=mock(Ficha.class);
		when(auxficha.getPrecio()).thenReturn(10.0);
		auxficha2=mock(Ficha.class);
		when(auxficha2.getPrecio()).thenReturn(2.0);
		auxficha3=mock(Ficha.class);
		auxpresentacion=mock(Presentacion.class);
		auxpedido=new Pedido();
	}

	@Test
	public void testPedido() {
		assertTrue(auxpedido.getFichas().isEmpty());
	}

	@Test
	public void testGetPrecioSinFichas() {
		Double aux1=0.0;
		assertEquals(aux1,auxpedido.getPrecio());
	}
	
	@Test
	public void testGetPrecioConFichas() {
		Double aux1=12.0;
		auxpedido.agregarFichaAlPedido(auxficha);
		auxpedido.agregarFichaAlPedido(auxficha2);
		assertEquals(aux1,auxpedido.getPrecio());
	}

	@Test
	public void testAgregarFichaAlPedido() {
		auxpedido.agregarFichaAlPedido(auxficha);
		assertTrue(auxpedido.getFichas().contains(auxficha));
	}

	@Test
	public void testAgregarPresentacionAlPedido() {
		//Como corroborar ya que la ficha la crea adentro?
		Ficha auxf=new Ficha(auxpresentacion,10);
		auxpedido.agregarPresentacionAlPedido(auxpresentacion, 10);
		assertEquals(1,auxpedido.getFichas().size());
		//assertEquals(auxf,auxpedido.buscarFicha(auxf));
	}

	@Test
	public void testSacarPresentacionAlPedidoConCantidadEnPedidoSuperior() throws NoPuedeDescontarException {
		//Revisar, no termina de convencer
		auxpedido.agregarPresentacionAlPedido(auxpresentacion, 10);
		auxpedido.sacarPresentacionAlPedido(auxpresentacion, 5);
		assertEquals(5,(auxpedido.getFichas().get(0)).getCantidad());
		
	}
	
	@Test
	
	public void testSacarPresentacionAlPedidoConCantidadEnPedidoInferior() throws NoPuedeDescontarException {
		//Revisar, no termina de convencer
		auxpedido.agregarPresentacionAlPedido(auxpresentacion, 10);
		try{
			auxpedido.sacarPresentacionAlPedido(auxpresentacion, 11);
		}
		catch(NoPuedeDescontarException e){}
		
		
	}

	@Test
	public void testPedidoListOfFicha() {
		ArrayList<Ficha> arrayfichas= new ArrayList<Ficha>();
		arrayfichas.add(auxficha);
		arrayfichas.add(auxficha2);
		auxpedido=new Pedido(arrayfichas);
		assertEquals(arrayfichas,auxpedido.getFichas());
	}

	@Test
	public void testSetFichas() {
		ArrayList<Ficha> arrayfichas= new ArrayList<Ficha>();
		arrayfichas.add(auxficha);
		auxpedido.setFichas(arrayfichas);
		assertEquals(arrayfichas,auxpedido.getFichas());
	}

	@Test
	public void testBuscarFicha() {
		fail("Not yet implemented");
	}

}
