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
			//System.out.println(t.getName()+" entra a la mina");
		} // end-for
		try {
			Thread.sleep(5000); // en ms
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
