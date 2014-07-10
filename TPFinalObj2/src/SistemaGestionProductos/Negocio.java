package SistemaGestionProductos;

import java.util.List;

public class Negocio {
	
	private List<Sucursal> sucursales;
	private List<Cliente> clientes;

	public Negocio(List<Sucursal>sucur,List<Cliente> clientes){
		
		this.sucursales = sucur;
		this.clientes = clientes;
	}
	
	public generarListadoDeVentas(Date fechaVenta){
		
	}
}
