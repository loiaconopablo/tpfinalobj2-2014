package SistemaGestionEnvios;

public class enProceso extends EstadoDelEnvio {
Double cantAAbonar;

    enProceso(Double cantAbonar,Envio e){
    	super(e);
    	this.setCantAAbonar(cantAbonar);
    }
	private void setCantAAbonar(Double cantAbonar) {
		this.cantAAbonar=cantAbonar;
		

	

}
	@Override
	void procesarEstadoActual() {
		if (this.getEnvio().getFechadeenvio().isAfterNow()){
		
			this.getEnvio().envioEntregado();
		}
		}
		
	}
