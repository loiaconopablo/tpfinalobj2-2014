
package SistemaGestionProductos;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private String nombre;
	private Integer dni;
	private String direccion;
	private CuentaCorriente cc;
	private List<Venta> historialCompras;


	public Cliente(String nombre, Integer dni, String direccion){
		this.setNombre(nombre);
		this.setDni(dni);
		this.setDireccion(direccion);
		this.setHistorialCompras(new ArrayList<Venta>());
		this.setCc(new CuentaCorriente());/*Modifique el null ya que tiraba un error en pointexception y 
		nos ahorramos de preguntar cuando usamos el get(charlie)*/
	}
	
	public void cargarPesosEnCC(Double monto){
		this.getCc().actualizarCCconPlata(monto);
	}
	
	//ACCESORS
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public CuentaCorriente getCc() {
		return cc;
		
	}
	public void setCc(CuentaCorriente cc) {
		this.cc = cc;
	}
	public List<Venta> getHistorialCompras() {
		return historialCompras;
	}
	public void setHistorialCompras(List<Venta> historialCompras) {
		this.historialCompras = historialCompras;
	}

	public void efectuarDevolucionYcancelarCompra(Venta venta) {
		this.getCc().actualizarCCconPedido(venta.getPedido());
		this.historialCompras.remove(venta);
		
	}


}

