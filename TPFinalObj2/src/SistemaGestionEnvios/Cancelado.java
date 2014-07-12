package SistemaGestionEnvios;


public class Cancelado extends EstadoDelEnvio {
	String motivo;
	
	Cancelado(String aux,Envio envio){
		super(envio);
		this.setMotivo(aux);
	}


	String getMotivo() {
		return motivo;
	}

	void setMotivo(String motivo) {
		this.motivo = motivo;
	}


	@Override
	void procesarEstadoActual() {
		// TODO Auto-generated method stub
		
	}

}
