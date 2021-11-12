package es.florida.psp.a3;

public class Contador implements Runnable {
	// declaraciones
	int inicioContador, limiteContador;
	String nombreHilo;

	Contador(int inicioContador, int limiteContador, String nombreHilo) {
		this.inicioContador = inicioContador;
		this.limiteContador = limiteContador;
		this.nombreHilo = nombreHilo;
	} // end-constructor

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arrayHilos = { "Hilo1", "Hilo2", "Hilo3", "Hilo4", "Hilo5" };
		int[] arrayInicioContador = { 1, 2, 3, 4, 5 };
		int[] arrayLimiteContador = { 10, 20, 30, 40, 50 };
		Contador contar;
		Thread hiloContador;
		for(int i = 0; i < arrayHilos.length; i++) {
			contar = new Contador(arrayInicioContador[i], arrayLimiteContador[i], arrayHilos[i]);
			hiloContador = new Thread(contar);
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
