package SistemaGestionProductos;

import java.util.List;

public class Ubicacion {
	
	String fila;
	String gondola;
	List<Producto> productos;
	
	public Ubicacion (String fila, String gondola, List<Producto>productos){
		
		this.fila = fila;
		this.gondola = gondola;
		this.productos = productos;
	}

	public String getFila() {
		return fila;
	}

	public void setFila(String fila) {
		this.fila = fila;
	}

	public String getGondola() {
		return gondola;
	}

	public void setGondola(String gondola) {
		this.gondola = gondola;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public void agregarProducto(Producto p){
		getProductos().add(p);
	}
	
	public void sacarProducto(Producto p){
		getProductos().remove(p);
	}
	
	public boolean estaElProducto(Producto p){
		return getProductos().contains(p);
	}
}