package SistemaGestionProductos;

import java.util.ArrayList;
import java.util.List;

public class Oferta {

	private List<Producto> productos;
	private int porcentajeDescuento;

	public Oferta(int porcentaje) {
		this.setProductos(new ArrayList<Producto>());
		this.setPorcentajeDescuento(porcentaje);
	}

	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public int getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(int porcentaje) {
		this.porcentajeDescuento = porcentaje;
	}

	public void agregarProductoAlaOferta(Producto product) {
		this.getProductos().add(product);
	}

	public void aplicarDescuentos(Pedido pedido) {
		for (Ficha ficha : pedido.getFichas()) {
			if (this.getProductos().contains(
					ficha.getPresentacion().getProducto())) {

				ficha.setPrecio(ficha.getPrecio()
						- ((ficha.getPrecio() * this.getPorcentajeDescuento()) ));

				ficha.setPrecio((ficha.getPrecio()
						- ((ficha.getPrecio() * this.getPorcentajeDescuento()) / 100)));
			}
		}
	}
}
