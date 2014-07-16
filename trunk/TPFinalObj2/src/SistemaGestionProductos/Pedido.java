package SistemaGestionProductos;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private List<Ficha> fichas;

	public Pedido() {
		this.setFichas(new ArrayList<Ficha>());
	}

	public Double getPrecio() {
		Double result = 0.0;
		for(Ficha ficha :this.getFichas()){
			result += ficha.getPrecio();
		}
		return result;
	}
	
	public void agregarFichaAlPedido(Ficha ficha){
		this.fichas.add(ficha);//revisar
	}

	public void agregarPresentacionAlPedido(Presentacion objeto, int cantidad) {
		Ficha ficha = new Ficha(objeto, cantidad);
		this.fichas.add(ficha);
	}

	public void sacarPresentacionAlPedido(Presentacion objeto, int cantidad) throws NoPuedeDescontarException {
		Ficha ficha = new Ficha(objeto, cantidad);
		this.descontar(ficha);
	}

	private void descontar(Ficha ficha) throws NoPuedeDescontarException {
		this.devolverFichaQueTiene(ficha).descontarCant(ficha.getCantidad());
	}

	private boolean puedeDescontar(Ficha ficha)
			throws NoPuedeDescontarException {
		boolean result = false;
		for (Ficha fichaInterna : this.getFichas()) {
			if (fichaInterna.getPresentacion() == ficha.getPresentacion()
					& fichaInterna.getCantidad() >= ficha.getCantidad()) {
				result = true;
			}
		}
		if (result == true) {
			return true;
		} else {
			throw new NoPuedeDescontarException();
		}
	}

	private Ficha devolverFichaQueTiene(Ficha fichaPedido) throws NoPuedeDescontarException {
		Ficha result = null;
		if (this.puedeDescontar(fichaPedido)) {
			for (Ficha ficha : this.getFichas()) {
				if (ficha.getPresentacion() == fichaPedido.getPresentacion()) {
					result = ficha;
				}
			}
		}
		return result;
	}

	public List<Ficha> getFichas() {
		return fichas;
	}

	public Pedido(List<Ficha> listaFichas) {
		this.setFichas(listaFichas);

	}
	
	public void setFichas(List<Ficha> fichas) {
		this.fichas = fichas;
	}
	
	public Ficha buscarFicha(Ficha ficha){
		return this.getFichas().get(getFichas().indexOf(ficha));
		
	}


}
