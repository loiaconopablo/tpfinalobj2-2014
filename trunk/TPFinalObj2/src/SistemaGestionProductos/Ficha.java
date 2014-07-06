package SistemaGestionProductos;
//
public class Ficha {
	
	private Presentacion objeto;
	private int cantidad;


	public Ficha(Presentacion objeto, int cantidad) {
		this.setCantidad(cantidad);
		this.setObjeto(objeto);
	}	

	public Presentacion getPresentacion() {
		return objeto;
	}
	public double precio(){
		return 	this.getCantidad()*this.getPresentacion().getPrecioVenta();
	}
	
	public void aumentarCant(int cantidad){
		this.setCantidad(this.getCantidad()+ cantidad);
	}
	
	public void descontarCant(int cantidad2) {
		this.setCantidad(this.getCantidad()- cantidad2);
		// hay que ver si hacemos que devuelva una excepcion o suponemos que la cantidad a descontar siempre es menor,
		// aunque es medio moncho hacer eso ja
	}

	public boolean tienePresentacion(Presentacion presentacion){
		return this.objeto == presentacion;
	}

	public void setObjeto(Presentacion objeto) {
		this.objeto = objeto;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	private void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public boolean verificarCantidadPresentacion(Ficha ficha) {
		// TODO Auto-generated method stub
		return this.getCantidad()>ficha.getCantidad();
	}

		

}
