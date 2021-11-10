package es.florida.psp.a3;

public class MostrarASCII implements Runnable {

	int tipo;
	
	MostrarASCII(int tipo) {
		this.tipo = tipo;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MostrarASCII objeto1 = new MostrarASCII(1);
		MostrarASCII objeto2 = new MostrarASCII(2);
		Thread hilo1 = new Thread(objeto1);
		Thread hilo2 = new Thread(objeto2);
		hilo1.start();
		hilo2.start();
	}

	public void run() {
		// TODO Auto-generated method stub
		if (tipo == 1) {
			for (int i = 0; i < 256; i+=2) {
				System.err.println("Caracter impar nº: "+i+": "+((char)i));
			}
		} else {
			for (int i = 255; i >= 0; i+=2) {
				System.err.println("Caracter par nº: "+i+": "+((char)i));
			} // end-for
		} // end-if
	} // end-run 

}
