package SistemaGestionVentas;

import java.util.Date;

import SistemaGestionProductos.Cliente;
import SistemaGestionProductos.Pedido;

public abstract class Venta {
	
	
	private Cliente cliente;
	private Date fechaDeVenta;
	private Pedido pedido;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFechaDeVenta() {
		return fechaDeVenta;
	}

	public void setFechaDeVenta(Date fechaDeVenta) {
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
