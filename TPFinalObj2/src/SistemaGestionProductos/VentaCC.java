package SistemaGestionProductos;

public class VentaCC extends Venta {

	public VentaCC (Pedido p, Cliente c){
		
		this.pedido = p;
		this.cliente = c;
	}

}