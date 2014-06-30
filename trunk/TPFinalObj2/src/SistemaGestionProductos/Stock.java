package SistemaGestionProductos;

import SistemaGestionProductos.Ficha;
import java.util.ArrayList;
import java.util.List;

public class Stock {
	
	private List<Ficha>fichas = new ArrayList<Ficha>();
	
	//chequea si la ficha esta,si esta, aumenta la cantidad, sino esta agrega la ficha a la lista.
	public void agregarFichaAlStock(Ficha ficha){
		if(getFichas().contains(ficha)){
			ficha.aumentarCant(ficha.getCantidad());
		}
		else{
			getFichas().add(ficha);
		}
	}

	
	public void descontarFichaAlStock(Ficha ficha){
		this.buscarFicha(ficha).descontarCant(ficha.getCantidad()); //hay que resolver esto....
	}
	
	public void agregarPedidoAlStock(Pedido pedido){
		
	}
	
	private void descontarPedidoDelStock(Pedido pedido){
		
		//llama a verificar stock, si hay stock , hacer el for llamando descontarFicha
		//sino hay......
		//descuenta 
		List<Ficha>fichas = this.getFichas();
		if(verificarStock(pedido)){
			for (Ficha ficha : fichas ) {
				this.descontarFichaAlStock(ficha);
			}
			else{
				//deberia lanzar una excepcion... conversar si deberia llamar
				//aca mismo a los metodos-generarPedidoEnStock() o 
				//-generarPedidoSinStock.
			}	
		}
		
	}
	
	private boolean verificarStock(Pedido pedido) {
		List<Ficha>fichas = pedido.getFichas();
		while(pedido.getFichas().buscarFicha().verificarCantidadPresentacion()==true){//hay que resolver como hacerlo....
			return true;
		}
		return false;
	}

	public List<Ficha> getFichas() {
		return fichas;
	}

	public void setFichas(List<Ficha> fichas) {
		this.fichas = fichas;
	}

}
