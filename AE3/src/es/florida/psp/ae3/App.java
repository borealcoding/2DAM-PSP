package es.florida.psp.ae3;

import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		/*
		 * Instanciamos un arrayList de mineros para ir añandiendo cada minero generado y que luego enviamos a la mina dentro de una lista. Se instanciará un hilo,enviandole como parámetro el minero generado anteriormente, asignándole un nombre y un número identificativo. 
		 * */
		// declaraciones
		ArrayList<Minero> mineros = new ArrayList<Minero>();
		Mina mina = new Mina(100);
		Minero minero;
		Thread t;
		
		// bucle de creacion de mineros, y asignación de los mismos a cada hilo de trabajo
		for(int i = 0; i<10; i++) {
			minero = new Minero(mina);
			mineros.add(minero);
			t = new Thread(minero);
			t.setName("Minero "+(i+1));
			t.start();
		} // end-for
		
		/*
		 * Una vez terminada la ejecucion de los hilos, se hará una pausa de unos segundos.
		 * Más abajo se registrara mediante un for, el numero total de recursos obtenidos por cada minero, recogiéndolos a traves de las bolsas de cada uno.
		 * */		
		try {
			Thread.sleep(5000); // en ms
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end-try-catch

		int totalRecursos = 0;
		for(int i=0; i<mineros.size(); i++) {
			totalRecursos += mineros.get(i).bolsaRecursos;
		} // end-for
		
		/*
		 * Finalmente, mostraremos el total de recursos obtenidos y los que aún queden disponibles dentro de la mina (que deberían de ser 0)
		 * */
		System.out.println("\n---------------------------------\n");
		System.out.println("Recursos de la mina: "+mina.numStock);
		System.out.println("Recursos de la bolsa: "+totalRecursos);
		System.out.println("\n----------------------------------\n");
		System.out.println("\n----- VENTILADOR ANTI-COVID19 -----\n");
		
		/*
		 * Como amplicacion, se ha creado un ventilador para cumplir con las medidas anti COVID-19. Su funcionamiento se basará en dos hilos independientes, ambos se encargarán de registrar el estado del ventilador, encendiendolo o apagándolo segun corresponda.
		 * */
		Ventilador ventilador = new Ventilador();
		// Hilo encenderVentilador
		Thread hiloEncender = new Thread(new Runnable() {
			@Override
			public void run() {
				ventilador.encenderVentilador();
			} // end-run
		}); // end-thread
		// Hilo apagarVentilador
		Thread hiloApagar = new Thread(new Runnable() {
			@Override
			public void run() {
				ventilador.apagarVentilador();
			} // end-run
		}); // end-thread
		hiloEncender.start();
		hiloApagar.start();
	} // end-main
} // end-class
