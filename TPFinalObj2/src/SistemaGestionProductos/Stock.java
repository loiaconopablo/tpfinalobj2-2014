package SistemaGestionProductos;

import SistemaGestionProductos.Ficha;
import java.util.ArrayList;
import java.util.List;

public class Stock {
	
	private List<Ficha>fichas = new ArrayList<Ficha>();
	
	public void agregarFichaAlStock(Ficha ficha){
		getFichas().getPresentaciones().buscarPresentacion();
		
	}
	
	public void descontarFichaAlStock(Ficha ficha){
		getFichas().remove(ficha);
	}
	
	public void agregarPedidoAlStock(Pedido pedido){
		
	}
	
	private void descontarPedidoDelStock(Pedido pedido){
		
		for (Ficha ficha : pedido.getFichas()) {
			this.descontarFichaAlStock(ficha);
		}
		
	}
	
	public List<Ficha> getFichas() {
		return fichas;
	}

	public void setFichas(List<Ficha> fichas) {
		this.fichas = fichas;
	}

}
