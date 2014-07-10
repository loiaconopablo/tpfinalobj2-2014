package SistemaGestionProductos;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {

	private Stock stock;
	private int idSucursal;
	private List<Ubicacion>ubicaciones = new ArrayList<Ubicacion>();
	private List<Oferta>ofertas;
	private List<Venta> historialDeVentas;
	private Negocio negocio;
	
	public Sucursal(int id, List<Ubicacion>ubicaciones, Negocio negocio){
		
		this.setNegocio(negocio);
		this.stock = new Stock();
		this.idSucursal = id;
		this.ubicaciones = ubicaciones;
		this.setOfertas(new ArrayList<Oferta>());
		this.setHistorialDeVentas(new ArrayList<Venta>());
	}

	public void agregarMercaderiaALaSucursal(Pedido pedido){
		this.getStock().agregarPedidoAlStock(pedido);
	}
	public void nuevoCliente(String nombreCl,  int dni, String direccion){
		this.getNegocio().nuevoCliente(nombreCl, dni, direccion);
	}

	public void efectuarVentaComun(Pedido pedido, Cliente cliente) throws NoPuedeDescontarException{
		VentaDirecta venta = new VentaDirecta(cliente,pedido);
		this.getHistorialDeVentas().add(venta);
		//SE SUPONE QUE SIEMPRE HAY STOCK
		this.getStock().descontarPedidoDelStock(pedido);
		cliente.getHistorialCompras().add(venta);
	}
	
	public void efectuarVentaComun(Pedido pedido) throws NoPuedeDescontarException{
		VentaDirecta venta = new VentaDirecta(this.getNegocio().getUserGenerico(),pedido);
		this.getHistorialDeVentas().add(venta);
		//SE SUPONE QUE SIEMPRE HAY STOCK
		this.getStock().descontarPedidoDelStock(pedido);
		this.getNegocio().getUserGenerico().getHistorialCompras().add(venta);
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
	
	//GETTERS Y SETTERS
	public Negocio getNegocio() {
		return negocio;
	}

	public void setNegocio(Negocio negocio) {
		this.negocio = negocio;
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
	
}
