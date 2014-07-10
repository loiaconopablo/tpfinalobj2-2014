package SistemaGestionProductos;

import java.util.Date;

public class VentaDirecta extends Venta {
	
	public VentaDirecta(Cliente c, Pedido p) {
		this.setPedido(p);
		this.setCliente(c);
		this.setFechaDeVenta(new Date());
	}

	
}
