package SistemaGestionProductos;

import SistemaGestionProductos.Ficha;

import java.util.ArrayList;
import java.util.List;

public class Stock {
	
	private List<Ficha>fichas = new ArrayList<Ficha>();
	
	//chequea si la ficha esta,si esta, aumenta la cantidad, sino esta agrega la ficha a la lista.
	public void agregarFichaAlStock(Ficha ficha){
		if(this.contienePresentencion(ficha)){
			this.buscarYDevolverFicha(ficha).aumentarCant(ficha.getCantidad());
		}
		else{
			this.getFichas().add(ficha);
		}
	}

	public double aplicarDescuentoDeOfertaAlPedido(Pedido ped) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void retornarPedidoAlStock(Pedido pedido){
		this.agregarPedidoAlStock(pedido);
	}
	
	public void agregarPedidoAlStock(Pedido pedido) {
		for(Ficha ficha : pedido.getFichas()){
			this.agregarFichaAlStock(ficha);
		}
	}

	public Pedido generarPedidoEnStock(Pedido pedido){
		Pedido result = new Pedido();
		for( Ficha ficha : pedido.getFichas()){
			if(this.hayStock(ficha)){
				pedido.agregarFichaAlPedido(ficha);
			}
		}
		return result;
	}
	
	public Pedido generarPedidoSinStock(Pedido pedido){
		Pedido result = new Pedido();
		for( Ficha ficha : pedido.getFichas()){
			if(!this.hayStock(ficha)){
				pedido.agregarFichaAlPedido(ficha);
			}
		}
		return result;
	}
	public Pedido generarPresentacionesEnEstadoCritico(){
		Pedido result = new Pedido();
		for(Ficha ficha : this.getFichas()){
			if(ficha.getCantidad()<ficha.getPresentacion().getStockCritico())
				result.agregarFichaAlPedido(ficha);
		}
		return result;
	}
	
	public Pedido generarPresentacionesEnEstadoMinimo(){
		Pedido result = new Pedido();
		for(Ficha ficha : this.getFichas()){
			if(ficha.getCantidad()<ficha.getPresentacion().getStockMinimo())
				result.agregarFichaAlPedido(ficha);
		}
		return result;
	}
	
	private boolean contienePresentencion(Ficha ficha) {
		boolean result = false;
		for(Ficha fic : this.getFichas()){
			if(	fic.getPresentacion() == ficha.getPresentacion()){
				result = true;
				break;}
			}
		return result;
	}
	
	public boolean hayStock(Ficha ficha){
		if(this.contienePresentencion(ficha)&&
				this.buscarYDevolverFicha(ficha).getCantidad()>= ficha.getCantidad()){
			return true;}
		else{
			return false;
		}
	}


	public void descontarFichaAlStock(Ficha ficha){
		this.buscarYDevolverFicha(ficha).descontarCant(ficha.getCantidad()); 
	}
	
	private Ficha buscarYDevolverFicha(Ficha ficha) {
		Ficha fichaEncontrada = null;
		for(Ficha fic : this.getFichas()){
			if(	fic.getPresentacion() == ficha.getPresentacion()){
				fichaEncontrada = fic;
				break;}
			}
		return fichaEncontrada;
	}


	
	public void descontarPedidoDelStock(Pedido pedido) throws NoPuedeDescontarException{
		//llama a verificar stock, si hay stock , hacer el for llamando descontarFicha
		//sino hay......
		//descuenta 
		List<Ficha>fichas = pedido.getFichas();
		if(verificarStock(pedido)){
			for (Ficha ficha : fichas ) {
				this.descontarFichaAlStock(ficha);
			}}
			else{
				throw new NoPuedeDescontarException();
				//deberia lanzar una excepcion... conversar si deberia llamar
				//aca mismo a los metodos-generarPedidoEnStock() o 
				//-generarPedidoSinStock.
			}	
		}
		
	
	public boolean verificarStock(Pedido pedido) {
		boolean result = true;
		for( Ficha ficha : pedido.getFichas()){
			if(!this.hayStock(ficha)){
				result = false; 
				break;
			}
		}
		return result;
	}

	public List<Ficha> getFichas() {
		return fichas;
	}

	public void setFichas(List<Ficha> fichas) {
		this.fichas = fichas;
	}


	
	
}
