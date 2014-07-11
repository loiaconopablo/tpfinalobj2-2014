package SistemaGestionProductos;

public class CuentaCorriente {
	
	private Double monto;
	
	public CuentaCorriente(){
		this.setMonto(0.0);
	}
	
	public void actualizarCCconPlata(Double monto) {
		this.setMonto(this.getMonto()+ monto);
	}
	
	public void actualizarCCconPedido(Pedido pedido) {
			this.actualizarCCconPlata(pedido.getPrecio());
	}

	
	//ACCESORS
	
	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public void descontarPlata(Pedido pedido) {
		this.setMonto(this.getMonto()- pedido.getPrecio());
		
	}





}
