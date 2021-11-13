package es.florida.psp.ae3;

import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		ArrayList<Minero> mineros = new ArrayList<Minero>();
		Mina mina = new Mina(100);
		Minero minero;
		Thread t;
		for(int i = 0; i<10; i++) {
			minero = new Minero(mina);
			mineros.add(minero);
			t = new Thread(minero);
			t.setName("Minero "+(i+1));
			t.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // end-for
		
		Ventilador ventilador = new Ventilador(false);
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
		
		try {
			Thread.sleep(12500); // en ms
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int totalRecursos = 0;
		for(int i=0; i<mineros.size(); i++) {
			totalRecursos += mineros.get(i).bolsaRecursos;
		}
		System.out.println("Recursos de la mina: "+mina.numStock);
		System.out.println("Recursos de la bolsa: "+totalRecursos);
	} // end-main
} // end-class
