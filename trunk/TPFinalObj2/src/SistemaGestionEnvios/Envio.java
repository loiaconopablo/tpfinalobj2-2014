package SistemaGestionEnvios;

import org.joda.time.DateTime;

import SistemaGestionVentas.Venta;

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
	public Venta getVenta() {
		return venta;
	}



	void setVenta(Venta venta) {
		this.venta = venta;
	}



	public EstadoDelEnvio getEstadointerno() {
		return estadointerno;
	}



	private void setEstadointerno(EstadoDelEnvio estadointerno) {
		this.estadointerno = estadointerno;
	}



	public DateTime getFechadeenvio() {
		return fechadeenvio;
	}	



	void setFechadeenvio(DateTime fechadeenvio) {
		this.fechadeenvio = fechadeenvio;
	}
	
	//Metodos para manejo de estado
	
	public void resetearEstadoEnvio(){
		this.setEstadointerno(new PendienteDeEnvio(this));
	}
	public void cancelarEnvio(String motivo){
		this.setEstadointerno(new Cancelado(motivo,this));
		
	}
	
	public void reprogramarEnvio(DateTime nuevaFecha){
		this.setEstadointerno(new Reprogramado(nuevaFecha,this));
	}
	public void envioEnProceso(Double cantAPagar){
		this.setEstadointerno(new enProceso(cantAPagar,this));
	}


	public void envioEntregado() {
		this.setEstadointerno(new Enviado(this));
		
	}
	
	public void procesarEnvio(){
		
		this.getEstadointerno().procesarEstadoActual();
	}

}
