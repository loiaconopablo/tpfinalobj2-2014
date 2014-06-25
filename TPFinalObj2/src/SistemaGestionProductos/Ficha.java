package SistemaGestionProductos;
//
public class Ficha {
	
	public Presentacion getObjeto() {
		return objeto;
	}

	public Ficha(Presentacion objeto, int cantidad) {
		this.setCantidad(cantidad);
		this.setObjeto(objeto);
	}

	

	public double precio(){
		return 	this.getCantidad()*this.getObjeto().getPrecioVenta();
	}
	
	public void descontarCant(int cantidad2) {
		// TODO Auto-generated method stub
		
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
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	private Presentacion objeto;
	private int cantidad;
		

}
