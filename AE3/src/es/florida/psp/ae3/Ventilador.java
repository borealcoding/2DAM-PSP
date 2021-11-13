package es.florida.psp.ae3;

public class Ventilador {

	boolean modoFuncionamiento = false; // true = encendido | false = apagado
	int tiempoFuncionamiento = 5000;
	
	public Ventilador (boolean modoFuncionamiento) {
		this.modoFuncionamiento = modoFuncionamiento;
	}

	public void encenderVentilador() {
		while(true) {
			synchronized (this) {
				try {
					while (modoFuncionamiento == false) wait();
					System.err.print("ESTADO: ");
					System.out.println("--> Ventilador encendido durante "+tiempoFuncionamiento/1000+" segundos");
					modoFuncionamiento = false;
					notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} // end-try-catch
			} // end-synchronized
		} // end-while
	} // end-encenderVentilador

	public void apagarVentilador() {
		while (true) {
			synchronized (this) {
				try {
					while (modoFuncionamiento == true) wait();
					System.err.print("ESTADO: ");
					System.out.println("--> Ventilador apagado durante "+tiempoFuncionamiento/1000+" segundos");
					Thread.sleep(tiempoFuncionamiento);
					modoFuncionamiento = true;
					notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} // end-try-catch
			} // end-synchronized
		} // end-while
	} // end-apagarVentilador
} // end-class

