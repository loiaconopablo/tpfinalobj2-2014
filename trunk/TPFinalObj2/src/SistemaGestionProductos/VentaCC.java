package SistemaGestionProductos;

import java.util.Date;

public class VentaCC extends Venta {

	public VentaCC (Cliente client, Pedido pedido){
			this.setPedido(pedido);
			this.setCliente(client);
			this.setFechaDeVenta(new Date());
			client.getCc().descontarPlata(pedido);
		}

}
