package SistemaGestionVentas;

import org.joda.time.DateTime;

import SistemaGestionEnvios.Envio;
import SistemaGestionProductos.Cliente;
import SistemaGestionProductos.Pedido;

public class VentaADomicilio extends Venta{
	
	Envio envio;
	
	public VentaADomicilio (Cliente client, Pedido pedido){
		this.setPedido(pedido);
		this.setCliente(client);
		this.setFechaDeVenta(new DateTime());
		this.envio = new Envio(this);
	}
	
	
}
