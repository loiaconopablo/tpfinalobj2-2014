package SistemaGestionProductos;

import java.util.ArrayList;


public class Producto {
	
	private String descripcion;
	private String nombre;
	private ArrayList<Presentacion> presentaciones ;
	private String tipo;
	private String unidadMedida;
	private String marca;

	
	public Producto (String descrip, String nom, String tipo, String unidadMedida,String marca){
		// Inicializo la lista vacia de presentaciones.
		this.setDescripcion(descrip); 
		this.setNombre (nom);
		this.setPresentaciones (new ArrayList<Presentacion>());
		this.setTipo(tipo);
		this.setUnidadMedida(unidadMedida);
		this.setMarca(marca);
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
	
	private void setMarca(String marca2) {
		this.marca=marca2 ;
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

	public String getMarca() {
		// TODO Auto-generated method stub
		return this.marca;
	}
}


