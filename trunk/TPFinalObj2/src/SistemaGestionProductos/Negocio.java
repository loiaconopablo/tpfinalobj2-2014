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

	public Negocio(String nombre){
		
		this.setNombre(nombre);
		this.setSucursales(new ArrayList<Sucursal>());
		this.setClientes(new ArrayList<Cliente>());
		Cliente clienteGenerico= new Cliente("Generico", 0, null);
		this.getClientes().add(clienteGenerico);
	}
	
	public void generarNuevaSucursal(int id, List<Ubicacion>ubicaciones){
		Sucursal nuevaSucursal = new Sucursal(id, ubicaciones, this);
		this.getSucursales().add(nuevaSucursal);
	}
	public List<Venta> generarListadoDeVentas(Date fechaVenta){
		//Hay que hacerlo
		return null;
		
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


	
//	PARA COMPARAR FECHAS
//	public static void main(String[] args) throws InterruptedException {
//	    
//	    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//	    Date a = new Date();
//	    Thread.sleep(1000);
//	    Date b = new Date();
//	    boolean sas = ((format.format(a)).equalsIgnoreCase((format.format(b))));
//	    System.out.println(format.format(a));
//	    System.out.println(format.format(b));
//	    System.out.println(sas);
//	    
//	  }

	
		
}
