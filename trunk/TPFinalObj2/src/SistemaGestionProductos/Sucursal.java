package SistemaGestionProductos;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {

	private Stock stock;
	int idSucursal;
	private List<Ubicacion>ubicaciones = new ArrayList<Ubicacion>();
	private List<Oferta>ofertas = new ArrayList<Oferta>();
	private List<Venta> historialDeVentas = new ArrayList<Venta>();
	private Negocio negocio;
	
	public Sucursal(Stock stock, int id, List<Ubicacion>ubicaciones, List<Oferta>ofertas,List<Venta>ventas){
		
		this.stock = stock;
		this.idSucursal = idSucursal;
		this.ubicaciones = ubicaciones;
		this.ofertas = ofertas;
		this.historialDeVentas = ventas;
	}
	
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public List<Ubicacion> getUbicaciones() {
		return ubicaciones;
	}

	public void setUbicaciones(List<Ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}

	public List<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}

	public List<Venta> getHistorialDeVentas() {
		return historialDeVentas;
	}

	public void setHistorialDeVentas(List<Venta> historialDeVentas) {
		this.historialDeVentas = historialDeVentas;
	}
	
	public void efectuarVentaComun(Pedido p, Cliente c){
		VentaDirecta venta = new VentaDirecta(p,c);
		this.getHistorialDeVentas().add(venta);
		c.getHistorialCompras().add(venta);
	}
	
	public void efectuarVentaComun(Pedido p){
		VentaDirecta venta = new VentaDirecta(p);
		this.getHistorialDeVentas().add(venta);
	}
	
	public void efectuarVentaCC(Pedido pedido, Cliente c){
		VentaCC venta = new VentaCC(pedido, c);
		this.getHistorialDeVentas().add(venta);
		c.getHistorialCompras().add(venta);
		//falta hacer metodo para agregar el pedido a la cuenta corriente, y ademas hacer el descuento del monto a la cuenta
		
	}
	
	public void efectuarVentaADomicilio(Pedido p, Cliente c){
		
	}
	
	public void reponerStock(Pedido pedido){
		this.getStock().agregarPedidoAlStock(pedido);
	}
	
	public void agregarPresentaciones(Presentacion presen, int cant, Ubicacion u ){
		//hay que cambiar el nombre de este metodo, ya que agrega fichas al stock, no presentaciones como dice el UML.
		Ficha ficha = new Ficha(presen, cant);
		this.getStock().agregarFichaAlStock(ficha);
	}
}
