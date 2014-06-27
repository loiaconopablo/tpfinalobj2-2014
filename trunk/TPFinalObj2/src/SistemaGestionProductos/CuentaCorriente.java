package SistemaGestionProductos;

import java.util.ArrayList;
import java.util.List;

public class CuentaCorriente {
	
	private double monto;
	private List<Presentacion> pedido;
	
	public CuentaCorriente(){
		this.setMonto(0);
		this.setPedido(new ArrayList<Pedido>());
	}
	
	public void actualizarCC(double monto) {
		// TODO Auto-generated method stub
		
	}
	
	public void actualizarCC(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}

	
	//ACCESORS
	
	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public List<Presentacion> getPedido() {
		return pedido;
	}

	public void setPedido(List<Presentacion> pedido) {
		this.pedido = pedido;
	}


}
