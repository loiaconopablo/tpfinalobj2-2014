package SistemaGestionProductos;

public class VentaDirecta extends Venta {

	public VentaDirecta(Pedido p) {
		this.setPedido(p);
		this.setCliente(new Cliente("Generico",null,null));
	}

	public VentaDirecta(Cliente c, Pedido p) {
		this.setPedido(p);
		this.setCliente(c);
	}

	public Venta generarVenta(Pedido p) {
		VentaDirecta nueva= new VentaDirecta(p);
		return nueva;
	}
	
	@Override
	public VentaDirecta generarVenta(Cliente c, Pedido p) {
		VentaDirecta nueva= new VentaDirecta(c,p);
		return nueva;
	}
}
