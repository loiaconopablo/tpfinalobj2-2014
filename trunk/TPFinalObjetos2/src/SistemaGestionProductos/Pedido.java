package SistemaGestionProductos;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private List<Ficha> fichas;

	public Pedido() {
		this.setFichas(new ArrayList<Ficha>());
	}

	public Pedido(List<Ficha> listaFichas) {
		this.setFichas(listaFichas);

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
			if (fichaInterna.getObjeto() == ficha.getObjeto()
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
				if (ficha.getObjeto() == fichaPedido.getObjeto()) {
					result = ficha;
				}
			}
		}
		return result;
	}

	public List<Ficha> getFichas() {
		return fichas;
	}

	public void setFichas(List<Ficha> fichas) {
		this.fichas = fichas;
	}

}
