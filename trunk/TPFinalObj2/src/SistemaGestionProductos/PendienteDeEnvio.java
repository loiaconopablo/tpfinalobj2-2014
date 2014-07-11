package SistemaGestionProductos;

public class PendienteDeEnvio extends EstadoDelEnvio {

	PendienteDeEnvio(Envio envio){
		super(envio);
	}

	@Override
	void procesarEstadoActual() {
	
		this.getEnvio().envioEnProceso(this.getEnvio().getVenta().debePagarDiferencia());
		
	}
	


	

}
