package es.florida.psp.examen1ev;

public class Persona implements Runnable {
	Subproceso subproceso;
	int numPersonas;
	
	public Persona() {
		this.numPersonas = 100;
	}
	
	public Persona(int numPersonas) {
		super();
		this.numPersonas = numPersonas;
	}  // end-constructor

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String nombre = Thread.currentThread().getName();
	}
}
