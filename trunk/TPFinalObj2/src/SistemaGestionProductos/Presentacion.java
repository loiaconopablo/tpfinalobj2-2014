package SistemaGestionProductos;

import java.util.ArrayList;

public class Presentacion {
	
	private String codDebarras;
	private int stockMinimo;
	private int stockCritico;
	private double precioVenta;
	private double precioCompra;
	private Producto producto;
	private ArrayList<Double>precioHistorico = new ArrayList<Double>();
	
	public Presentacion(String codDeBarras, int stockMin, int StockCri, double precioVta, double precioCmp, Producto produc){
		this.setCodDebarras(codDeBarras);
		this.setStockMinimo(stockMin);
		this.setStockCritico(StockCri);
		this.setPrecioVenta(precioVta);
		this.setPrecioCompra(precioCmp);
		this.setProducto(produc);
		this.precioHistorico.add(this.getPrecioVenta());
	}
	
	
	public boolean soyDelTipoDeProcuto(Producto producto){
		
		if(producto.getClass()== this.getProducto().getClass())
			{return true;}
		else {return false;}
		
	}
	
	public void cambiarPrecioDeVenta(double precioNuevo){
		this.setPrecioVenta(precioNuevo);
	}
	
	
	// ACCESORS
	
	public double getPrecioVenta() {
		return precioVenta;
	}

	public String getCodDebarras() {
		return codDebarras;
	}

	public void setCodDebarras(String codDebarras) {
		this.codDebarras = codDebarras;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public int getStockCritico() {
		return stockCritico;
	}

	public void setStockCritico(int stockCritico) {
		this.stockCritico = stockCritico;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public ArrayList<Double> getPrecioHistorico() {
		return precioHistorico;
	}

	public void setPrecioHistorico(ArrayList<Double> precioHistorico) {
		this.precioHistorico = precioHistorico;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}


	
	
	
}
