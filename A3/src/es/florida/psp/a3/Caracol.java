package es.florida.psp.a3;

public class Caracol implements Runnable {
	double distancia = 1;
	double velocidad;
	String nombre;

	public Caracol(String nombre, double velocidad) {
		this.nombre = nombre;
		this.velocidad = velocidad;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] nombres = { "Turbo", "Rayo", "Flash", "Viento", "Lightspeed" };
		double[] velocidades = {0.01,0.011,0.0099,0.00999,0.0105};
		Caracol objetoCaracol;
		Thread hiloCaracol;
		for (int i = 0; i < nombres.length; i++) {
			objetoCaracol = new Caracol(nombres[i], velocidades[i]);
			hiloCaracol = new Thread(objetoCaracol);
			hiloCaracol.start();
		} // end for
	} // end main

	public void run() {
		double avance = 0;
		double porcentaje = 0;
		System.out.println("El caracol " + nombre + " ha empezado a correr");
		while (avance < distancia) {
			avance += velocidad * 1;
			porcentaje = (avance / distancia) * 100;
			System.out.println("El caracol " + nombre + " ha avanzado "+String.format("%.0f", porcentaje)+"%");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // end while
		System.out.println("El caracol " + nombre + " ha llegado a la meta!");
	} // end run
} // end class
