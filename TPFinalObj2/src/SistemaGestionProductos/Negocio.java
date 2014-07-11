package SistemaGestionProductos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Negocio {
	
	private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	private List<Sucursal> sucursales;
	private List<Cliente> clientes;
	private String nombre;
	private double caja;

	public Negocio(String nombre){
		
		this.setCaja(0);
		this.setNombre(nombre);
		this.setSucursales(new ArrayList<Sucursal>());
		this.setClientes(new ArrayList<Cliente>());
		Cliente clienteGenerico= new Cliente("Generico", 0, null);
		this.getClientes().add(clienteGenerico);
	}
	
	public Sucursal devolverSucural(int id){
		for (Sucursal sucur : this.getSucursales()) {
			if(sucur.getIdSucursal() == id)
				{return sucur;}
			
		}
		return null;
	}

	public void generarNuevaSucursal(int id, List<Ubicacion>ubicaciones){
		Sucursal nuevaSucursal = new Sucursal(id, ubicaciones, this);
		this.getSucursales().add(nuevaSucursal);
	}
	public List<Venta> generarListadoDeVenta(){
		List<Venta>result = new ArrayList<Venta>();
		for(Sucursal sucu : this.getSucursales())
			{result.addAll(sucu.getHistorialDeVentas());}
		return result;
	}
	
	public List<Venta>generarListadoVenta(Date desde, Date hasta){
		List<Venta>result = new ArrayList<Venta>();
		for(Sucursal sucu : this.getSucursales())
		{result.addAll(sucu.generarListadoVenta(desde,hasta));}
	return result;
	}
	
	public List<Venta>generarListadoVenta(Date fecha){
		List<Venta>result = new ArrayList<Venta>();
		for(Sucursal sucu : this.getSucursales())
		{result.addAll(sucu.generarListadoVenta(fecha));}
	return result;
	}
	
	public List<Venta>generarListadoVenta(double desde, double hasta){
		List<Venta>result = new ArrayList<Venta>();
		for(Sucursal sucu : this.getSucursales())
		{result.addAll(sucu.generarListadoVenta(desde,hasta));}
	return result;
	}

	public List<Double> montoCompradoPor(Cliente client){
		List<Double> result = new ArrayList<Double>();
		for(Venta venta : client.getHistorialCompras()){
			result.add(venta.getPedido().getPrecio());
		}
		return result;
	}
	
	public List<Double> montoCompradoPor(Cliente client, Date fecha){
		List<Double> result = new ArrayList<Double>();
		for(Venta venta : client.getHistorialCompras()){
			if(format.format(venta.getFechaDeVenta())== format.format(fecha)){
				result.add(venta.getPedido().getPrecio());
			}
		}
		return result;
	}
	
	public Cliente getUserGenerico() {
		return this.getClientes().get(0);
	}
	public void nuevoCliente(String nombreCl,  int dni, String direccion){
		this.getClientes().add(new Cliente(nombreCl, dni, direccion));
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public double getCaja() {
		return caja;
	}

	public void setCaja(double caja) {
		this.caja = caja;
	}
	


	
		
}
