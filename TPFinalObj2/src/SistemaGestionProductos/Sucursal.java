package SistemaGestionProductos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

import SistemaGestionVentas.Venta;
import SistemaGestionVentas.VentaCC;
import SistemaGestionVentas.VentaDirecta;

public class Sucursal {

	private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	private Stock stock;
	private int idSucursal;
	private List<Ubicacion>ubicaciones = new ArrayList<Ubicacion>();
	private List<Oferta>ofertas;
	private List<Venta> historialDeVentas;
	private Negocio negocio;
	private double caja;

	public Sucursal(int id, Negocio negocio){
		
		this.setNegocio(negocio);
		this.stock = new Stock();
		this.idSucursal = id;
		this.ubicaciones = new ArrayList<Ubicacion>();
		this.setOfertas(new ArrayList<Oferta>());
		this.setHistorialDeVentas(new ArrayList<Venta>());
		this.setCaja(0);
	}
	
	public void agregarUbicacion(Ubicacion ubicacion){
		this.getUbicaciones().add(ubicacion);
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

	public void aplicarDescuentoDeOfertas(Pedido ped) {
		if(this.hayOfertas()){
		for(Oferta ofer :this.getOfertas())
			{ofer.aplicarDescuentos(ped);}
		}
	}
	
	private boolean hayOfertas() {
		return this.getOfertas().size()>0;
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
	
	public List<Venta> generarListadoVenta(DateTime desde, DateTime hasta) {
		List<Venta>result = new ArrayList<Venta>();
		for(Venta vent : this.getHistorialDeVentas())
		{if(vent.getFechaDeVenta().isAfter(desde) && vent.getFechaDeVenta().isBefore(hasta))
			result.add(vent);}
	return result;
	}
	
	public List<Venta> generarListadoVenta(DateTime fecha) {
		List<Venta>result = new ArrayList<Venta>();
		for(Venta vent : this.getHistorialDeVentas())
		{if(vent.getFechaDeVenta() == fecha)
			result.add(vent);}
	return result;
	}

	public List<Venta> generarListadoVenta(double desde,double hasta) {
		List<Venta>result = new ArrayList<Venta>();
		for(Venta vent : this.getHistorialDeVentas())
		{if(vent.getPedido().getPrecio()>=desde && vent.getPedido().getPrecio()<= hasta)
			result.add(vent);}
	return result;
	}
	
	public List<Presentacion> generarListadoPresentacionStockMinimo(){
		return this.getStock().generarPresentacionesEnEstadoMinimo();
	}
	
	public List<Presentacion> generarListadoPresentacionStockCritico(){
		return this.getStock().generarPresentacionesEnEstadoCritico();
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
