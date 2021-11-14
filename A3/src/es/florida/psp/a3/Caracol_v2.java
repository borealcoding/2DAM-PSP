package es.florida.psp.a3;

public class Caracol_v2 implements Runnable {
	// declaraciones
	double distancia = 1;
	double velocidad;
	String nombre;

	public Caracol_v2(String nombre, double velocidad) {
		this.nombre = nombre;
		this.velocidad = velocidad;
	} // end-constructor

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] nombres = { "Turbo", "Rayo", "Flash", "Viento", "Lightspeed"};
		double[] velocidades = {0.01,0.01,0.01,0.01,0.01};
		int[] prioridades = {1,2,3,4,10};
		Caracol_v2 caracol_v2;
		Thread hiloCaracol_v2;
		for (int i = 0; i < nombres.length; i++) {
			caracol_v2 = new Caracol_v2(nombres[i], velocidades[i]);
			hiloCaracol_v2 = new Thread(caracol_v2);
			hiloCaracol_v2.setPriority(prioridades[i]);
			hiloCaracol_v2.start();
		} // end-for
	} // end-main

	public void run() {
		// TODO Auto-generated method stub
		double avance = 0;
		double porcentaje = 0;
		System.out.println("El caracol " + nombre + " ha empezado a correr");
		while (avance < distancia) {
			avance += velocidad * 1;
			porcentaje = (avance / distancia) * 100;
			System.out.println("El caracol " + nombre + " ha avanzado "+avance+" metros, "+String.format("%.0f", porcentaje)+"%");
			// try {
			// 	Thread.sleep(1000);
			// } catch (InterruptedException e) {
			// 	// TODO Auto-generated catch block
			// 	e.printStackTrace();
			// }
		} // end-while
		System.out.println("El caracol " + nombre + " ha terminado la carrera!!");
	} // end-run
} // end-class
