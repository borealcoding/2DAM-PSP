package es.florida.psp.a3;

public class MostrarASCII implements Runnable {
	// declaraciones
	int tipo;
	
	MostrarASCII(int tipo) {
		this.tipo = tipo;
	} // end-constructor

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MostrarASCII objeto1 = new MostrarASCII(1);
		MostrarASCII objeto2 = new MostrarASCII(2);
		Thread hilo1 = new Thread(objeto1);
		Thread hilo2 = new Thread(objeto2);
		hilo1.start();
		hilo2.start();
	} // end-main

	public void run() {
		// TODO Auto-generated method stub
		if (tipo == 1) {
			for (int i = 1; i < 256; i+=2) {
				System.err.println("Caracter impar nº: "+i+": "+((char)i));
			} // end-for
		} else {
			for (int i = 2; i <= 256; i+=2) {
				System.err.println("Caracter par nº: "+i+": "+((char)i));
			} // end-for
		} // end-if
	} // end-run 
} // end-class