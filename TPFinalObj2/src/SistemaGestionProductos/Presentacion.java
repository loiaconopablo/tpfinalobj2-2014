package SistemaGestionProductos;

import java.util.ArrayList;
import java.util.List;

public class Presentacion {
	private Integer cantDeUnidadDeMedida;
	private String codDebarras;
	private int stockMinimo;
	private int stockCritico;
	private double precioVenta;
	private double precioCompra;
	private Producto producto;
	private List<Double>precioHistorico ;
	
	public Presentacion(String codDeBarras, int stockMin, int StockCri, Double precioVta, Double precioCmp, Producto produc,Integer cantDeUnidadDeMedida){
		this.setCodDebarras(codDeBarras);
		this.setCantDeUnidadDeMedida(cantDeUnidadDeMedida);
		this.setStockMinimo(stockMin);
		this.setStockCritico(StockCri);
		this.setPrecioHistorico(new ArrayList<Double>());
		this.setPrecioVenta(precioVta);
		this.setPrecioCompra(precioCmp);
		this.setProducto(produc);
		produc.agregarPresentacion(this);
	}
	
	
	public boolean soyDelTipoDeProducto(Producto producto){
		
		return (producto.equals(this.getProducto()));
			
	}
	
	public void cambiarPrecioDeVenta(double precioNuevo){
		this.setPrecioVenta(precioNuevo);
	}
	
	public boolean equals(Presentacion presentacion){
		return this.getCodDebarras().equals(presentacion.getCodDebarras());
	}
	
	
	// ACCESORS
	
	public Double getPrecioVenta() {
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

	public Double getPrecioCompra() {
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

	public List<Double> getPrecioHistorico() {
		return precioHistorico;
	}

	public void setPrecioHistorico(ArrayList<Double> precioHistorico) {
		this.precioHistorico = precioHistorico;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
		this.precioHistorico.add(this.getPrecioVenta());
	}


	public Integer getCantDeUnidadDeMedida() {
		return cantDeUnidadDeMedida;
	}


	public void setCantDeUnidadDeMedida(Integer cantDeUnidadDeMedida) {
		this.cantDeUnidadDeMedida = cantDeUnidadDeMedida;
	}


	
	
	
}
