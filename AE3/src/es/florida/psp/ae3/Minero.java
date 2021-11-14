package es.florida.psp.ae3;

public class Minero implements Runnable {
	// donde se guardan los recursos que obtiene el minero
	int bolsaRecursos;
	// tiempo de trabajo necesario para extraer cada recurso
	int tiempoExtraccion = 100; // en milisegundos
	// declaramos la mina
	Mina mina;
	
	public Minero(Mina mina) {
		this.bolsaRecursos = 0;
		this.mina = mina;
	} // end-constructor
	
	synchronized public void extraerRecurso(String nombre, int recurso) {
		// extrae de la mina un recurso en cada turno y lo guarda en la bolsa
			while(mina.numStock > 0) {
				if (recurso <= mina.numStock) {
					mina.numStock -= recurso;
					bolsaRecursos += recurso;
					System.out.println("El "+nombre+" ha extraido "+recurso+" de la mina. Dentro aun quedan "+mina.numStock+" disponibles");
					try {
						Thread.sleep(tiempoExtraccion); // en ms
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} // end-try-catch
				} // end-if
			} // end-while
	} // end-extraerRecurso
	
	public void run() {
		// extraerRecurso();
		String nombre = Thread.currentThread().getName(); // obtiene el nombre del hilo
		int recursos = 1;
		extraerRecurso(nombre,recursos);
	} // end-run
	
} // end-class
