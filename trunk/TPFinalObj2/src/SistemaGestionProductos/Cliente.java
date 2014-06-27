package SistemaGestionProductos;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private String nombre;
	private int dni;
	private String direccion;
	private CuentaCorriente cc;
	private List<Venta> historialCompras;
	
	public Cliente(String nombre, int dni, String direccion){
		this.setNombre(nombre);
		this.setDni(dni);
		this.setDireccion(direccion);
		this.setHistorialCompras(new ArrayList<Venta>());
		this.setCc(null);
	}
	
	public void cargarPesosEnCC(double monto){
		this.getCc().actualizarCC(monto);
	}
	
	public void cargarPedidosEnCCProductos(Pedido pedido){
		this.getCc().actualizarCC(pedido);
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
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public CuentaCorriente getCc() {
		if(cc.equals(null)){
			this.setCc(new CuentaCorriente());
		};
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

}
