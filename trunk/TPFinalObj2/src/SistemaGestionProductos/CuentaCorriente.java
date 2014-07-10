package SistemaGestionProductos;

import java.util.ArrayList;
import java.util.List;

public class CuentaCorriente {
	
	private Double monto;
	private List<Ficha> pedido;
	
	public CuentaCorriente(){
		this.setMonto(0.0);
		this.setPedido(new ArrayList<Ficha>());
	}
	
	public void actualizarCC(Double monto) {
		this.setMonto(this.getMonto()+ monto);
	}
	
	public void actualizarCC(Pedido pedido) {
		for (Ficha ficha : pedido.getFichas()) {
			pedido.agregarFichaAlPedido(ficha);
		}
	}

	
	//ACCESORS
	
	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public List<Ficha> getPedido() {
		return pedido;
	}

	public void setPedido(List<Ficha> pedido) {
		this.pedido = pedido;
	}


}
