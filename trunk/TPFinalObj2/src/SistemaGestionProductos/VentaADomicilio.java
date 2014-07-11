package SistemaGestionProductos;

import java.util.Date;

public class VentaADomicilio extends Venta{
	
	Envio envio;
	
	public VentaADomicilio (Cliente client, Pedido pedido){
		this.setPedido(pedido);
		this.setCliente(client);
		this.setFechaDeVenta(new Date());
		this.envio = new Envio(this);
	}
	
	
}
