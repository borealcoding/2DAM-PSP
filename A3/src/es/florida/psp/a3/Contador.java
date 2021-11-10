package es.florida.psp.a3;

public class Contador implements Runnable {
	int inicioContador, limiteContador;
	String nombreHilo;

	Contador(int inicioContador, int limiteContador, String nombreHilo) {
		this.inicioContador = inicioContador;
		this.limiteContador = limiteContador;
		this.nombreHilo = nombreHilo;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arrayNombreHilos = { "Hilo1", "Hilo2", "Hilo3", "Hilo4", "Hilo5" };
		int[] arrayInicioContador = { 1, 2, 3, 4, 5 };
		int[] arrayLimiteContador = { 10, 20, 30, 40, 50 };
		Contador objetContador;
		Thread hiloContador;
		for(int i = 0; i < arrayNombreHilos.length; i++) {
			objetContador = new Contador(arrayInicioContador[i], arrayLimiteContador[i], arrayNombreHilos[i]);
			hiloContador = new Thread(objetContador);
			hiloContador.start();
		} // end-for
	} // end-main

	public void run() {
		// TODO Auto-generated method stub
		for(int i = inicioContador; i <= limiteContador; i++) {
			System.out.println("Contador "+nombreHilo+"(de "+inicioContador+" a "+limiteContador+") = "+i);
		} // end-for
	} // end-run

}
