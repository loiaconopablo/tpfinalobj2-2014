package SistemaGestionEnvios;

import org.joda.time.DateTime;

import SistemaGestionProductos.Venta;

public class Envio {
	Venta venta;
	EstadoDelEnvio estadointerno;
	DateTime fechadeenvio;
	
	
	public Envio(Venta venta){
		
		this.setFechadeenvio(new DateTime());
		this.setVenta(venta);
		this.setEstadointerno(new PendienteDeEnvio(this));
	}


	//Getters y Setters 
	Venta getVenta() {
		return venta;
	}



	void setVenta(Venta venta) {
		this.venta = venta;
	}



	EstadoDelEnvio getEstadointerno() {
		return estadointerno;
	}



	private void setEstadointerno(EstadoDelEnvio estadointerno) {
		this.estadointerno = estadointerno;
	}



	DateTime getFechadeenvio() {
		return fechadeenvio;
	}	



	void setFechadeenvio(DateTime fechadeenvio) {
		this.fechadeenvio = fechadeenvio;
	}
	
	//Metodos para manejo de estado
	
	void resetearEstadoEnvio(){
		this.setEstadointerno(new PendienteDeEnvio(this));
	}
	void cancelarEnvio(String motivo){
		this.setEstadointerno(new Cancelado(motivo,this));
		
	}
	
	void reprogramarEnvio(DateTime nuevaFecha){
		this.setEstadointerno(new Reprogramado(nuevaFecha,this));
	}
	void envioEnProceso(Double cantAPagar){
		this.setEstadointerno(new enProceso(cantAPagar,this));
	}


	public void envioEntregado() {
		this.setEstadointerno(new Enviado(this));
		
	}
	
	

}
