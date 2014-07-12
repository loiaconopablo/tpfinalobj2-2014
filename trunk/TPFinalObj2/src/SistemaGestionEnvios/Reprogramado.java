/**
 * 
 */
package SistemaGestionEnvios;

import org.joda.time.DateTime;

public class Reprogramado extends EstadoDelEnvio {
DateTime fecha;

	Reprogramado(DateTime fechanueva,Envio envio){
		super(envio);
		this.setFecha(fechanueva);	
	}
	private void setFecha(DateTime fechanueva) {
		this.fecha=fechanueva;
		
	

}
	@Override
	void procesarEstadoActual() {
		this.getEnvio().setFechadeenvio(this.fecha);
		this.getEnvio().resetearEstadoEnvio();
	}
	}
