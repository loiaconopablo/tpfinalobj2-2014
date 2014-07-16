package SistemaGestionVentas;

import org.joda.time.DateTime;
import SistemaGestionProductos.Cliente;
import SistemaGestionProductos.Pedido;

public class VentaCC extends Venta {

	public VentaCC (Cliente client, Pedido pedido){
			this.setPedido(pedido);
			this.setCliente(client);
			this.setFechaDeVenta(new DateTime());
			client.getCc().descontarPlata(pedido);
	}

}
