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
	private double caja;

	public Sucursal(int id, List<Ubicacion>ubicaciones, Negocio negocio){
		
		this.setNegocio(negocio);
		this.stock = new Stock();
		this.idSucursal = id;
		this.ubicaciones = ubicaciones;
		this.setOfertas(new ArrayList<Oferta>());
		this.setHistorialDeVentas(new ArrayList<Venta>());
		this.setCaja(0);
	}

	public void agregarMercaderiaALaSucursal(Pedido pedido){
		this.getStock().agregarPedidoAlStock(pedido);
	}
	public void nuevoCliente(String nombreCl,  int dni, String direccion){
		this.getNegocio().nuevoCliente(nombreCl, dni, direccion);
	}
	
	public void cobrarPedido(double precio){
		this.setCaja(this.getCaja()+precio);
	}
	
	public void efectuarDevolucion(Cliente client, Venta venta){
		this.cancelarVenta(venta);
		this.agregarMercaderiaALaSucursal(venta.getPedido());
		client.efectuarDevolucionYcancelarCompra(venta);
	}

	private void cancelarVenta(Venta venta) {
		this.getHistorialDeVentas().remove(venta);
	}

	public double aplicarDescuentoDeOfertas(Pedido ped) {
		double acobrar = this.getStock().aplicarDescuentoDeOfertaAlPedido(ped);
		return acobrar;
	}
	
	public void efectuarVentaComun(Pedido pedido, Cliente cliente) throws NoPuedeDescontarException{
		this.aplicarDescuentoDeOfertas(pedido);
		VentaDirecta venta = new VentaDirecta(cliente,pedido);
		this.getHistorialDeVentas().add(venta);
		//SE SUPONE QUE SIEMPRE HAY STOCK
		this.getStock().descontarPedidoDelStock(pedido);
		cliente.getHistorialCompras().add(venta);
		this.cobrarPedido(pedido.getPrecio());
	}

	public void efectuarVentaComun(Pedido pedido) throws NoPuedeDescontarException{
		this.aplicarDescuentoDeOfertas(pedido);
		VentaDirecta venta = new VentaDirecta(this.getNegocio().getUserGenerico(),pedido);
		this.getHistorialDeVentas().add(venta);
		//SE SUPONE QUE SIEMPRE HAY STOCK
		this.getStock().descontarPedidoDelStock(pedido);
		this.getNegocio().getUserGenerico().getHistorialCompras().add(venta);
		this.cobrarPedido(pedido.getPrecio());
	}
	
	public void efectuarVentaCC(Pedido pedido, Cliente cliente){
		this.aplicarDescuentoDeOfertas(pedido);
		VentaCC venta = new VentaCC(cliente, pedido);
		this.getHistorialDeVentas().add(venta);
		cliente.getHistorialCompras().add(venta);		
	}
	
	public void efectuarVentaADomicilio(Pedido p, Cliente c){
		//Aca tiene que ir la logica de los envios y demas
	}
	
	public void reponerStock(Pedido pedido){
		this.getStock().agregarPedidoAlStock(pedido);
	}
	
	public void agregarPresentaciones(Presentacion presen, int cant, Ubicacion u ){
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
	
	public double getCaja() {
		return caja;
	}

	public void setCaja(double caja) {
		this.caja = caja;
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
