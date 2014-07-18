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
	
	public Double getCantAAbonar(){
		return this.cantAAbonar;
	}
	


	@Override
	void procesarEstadoActual() {
		if (this.getEnvio().getFechadeenvio().isBeforeNow()){
		
			this.getEnvio().envioEntregado();
		}
		}
		
	}
