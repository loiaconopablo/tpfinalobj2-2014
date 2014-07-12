package SistemaGestionVentas;

import java.util.Date;

import SistemaGestionProductos.Cliente;
import SistemaGestionProductos.Pedido;

public class VentaDirecta extends Venta {
	
	public VentaDirecta(Cliente c, Pedido p) {
		this.setPedido(p);
		this.setCliente(c);
		this.setFechaDeVenta(new Date());
	}

	
}
