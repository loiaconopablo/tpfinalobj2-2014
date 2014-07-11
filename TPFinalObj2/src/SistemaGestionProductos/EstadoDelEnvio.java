package SistemaGestionProductos;

abstract class  EstadoDelEnvio {
	Envio enviorelacionado;
	
	EstadoDelEnvio(Envio envio){
		enviorelacionado=envio;
	}
	
	abstract void procesarEstadoActual();
	
	Envio getEnvio(){
		return this.enviorelacionado;
	}
	
}

