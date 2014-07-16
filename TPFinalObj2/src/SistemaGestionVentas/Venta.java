package SistemaGestionVentas;

import org.joda.time.DateTime;

import SistemaGestionProductos.Cliente;
import SistemaGestionProductos.Pedido;

public abstract class Venta {
	
	
	private Cliente cliente;
	private DateTime fechaDeVenta;
	private Pedido pedido;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public DateTime getFechaDeVenta() {
		return fechaDeVenta;
	}

	public void setFechaDeVenta(DateTime fechaDeVenta) {
		this.fechaDeVenta = fechaDeVenta;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Double debePagarDiferencia() {
		// TODO Auto-generated method stub
		return null;
	}


}
