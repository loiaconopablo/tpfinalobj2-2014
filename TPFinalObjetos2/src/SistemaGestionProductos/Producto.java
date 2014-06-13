package SistemaGestionProductos;

import java.util.ArrayList;


public class Producto {
	
	String descripcion;
	String nombre;
	ArrayList<Presentacion> presentaciones = new ArrayList<Presentacion>();
	String tipo;
	String unidadMedida;

	
	public Producto (String descrip, String nom, ArrayList<Presentacion> presen, String tipo, String unidadMedida){
		
		this.descripcion = descrip; 
		this.nombre = nom;
		this.presentaciones = presen;
		this.tipo = tipo;
		this.unidadMedida = unidadMedida;
	}
	
	
//////////////////////////getters&setters////////////////////////////////////
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Presentacion> getPresentaciones() {
		return presentaciones;
	}

	private void setPresentaciones(ArrayList<Presentacion> presentaciones) {
		this.presentaciones = presentaciones;
	}

	public String getTipo() {
		return tipo;
	}

	private void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	private void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	
///////////////////////////////////////////////////////////////////////////////////	
	
	public boolean tengoPresentacion(Presentacion p){
		
		return this.presentaciones.contains(p);
	}
	
	public boolean esDeMiTipo(String t){
		
		return getTipo()==t;
	}
	
	public void agregarPresentacion(Presentacion p){
		
		this.presentaciones.add(p);
	}
	
	public void quitarPresentacion(Presentacion p){
		
		this.presentaciones.remove(p);
	}
}


