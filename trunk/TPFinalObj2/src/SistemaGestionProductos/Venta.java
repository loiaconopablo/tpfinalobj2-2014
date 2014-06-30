package SistemaGestionProductos;

import java.util.Date;

public abstract class Venta {
	
	private Cliente cliente;
	private Date fechaDeVenta;
	private Pedido pedido;
	
	public abstract Venta generarVenta(Cliente c, Pedido p);

}
