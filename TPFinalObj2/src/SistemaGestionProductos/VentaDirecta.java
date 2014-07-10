package SistemaGestionProductos;

public class VentaDirecta extends Venta {

	public VentaDirecta(Pedido p, Cliente c) {
		this.pedido = p;
		this.cliente = c;
	}

	public VentaDirecta(Pedido p) {
		this.pedido = p;
	}

	
}
