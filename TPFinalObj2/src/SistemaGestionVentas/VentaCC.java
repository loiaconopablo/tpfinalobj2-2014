package SistemaGestionVentas;

import java.util.Date;

import SistemaGestionProductos.Cliente;
import SistemaGestionProductos.Pedido;

public class VentaCC extends Venta {

	public VentaCC (Cliente client, Pedido pedido){
			this.setPedido(pedido);
			this.setCliente(client);
			this.setFechaDeVenta(new Date());
			client.getCc().descontarPlata(pedido);
	}

}
