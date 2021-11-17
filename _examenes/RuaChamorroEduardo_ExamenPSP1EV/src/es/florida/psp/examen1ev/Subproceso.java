package es.florida.psp.examen1ev;

import java.util.ArrayList;

public class Subproceso  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> coloresFav = new ArrayList<String>();
		String [] coloresPorDefecto = {"Amarillo","Verde","Rojo","Azul","Naranja"};
		int numDefinidoPersonas = Integer.parseInt(args[0]);
		Persona persona = new Persona(numDefinidoPersonas);
		Thread t;
		
		for(int i = 1; i<=persona.numPersonas; i++) {
			// selecciono un color aleatorio
			int numColor = (int) (Math.random() * 5 + 0);
			// creo una persona (maximo 5)
			persona = new Persona(numDefinidoPersonas);
			coloresFav.add(coloresPorDefecto[numColor]);
			t = new Thread(persona);
			t.setName("Persona "+(i+1));
			t.start();
			System.out.println("La persona "+i+" ha añadido el color "+coloresFav.get(i-1));
			
			try {
				Thread.sleep(50); // en ms
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // end-try-catch
		} // end-for
		
		try {
			Thread.sleep(2000); // en ms
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end-try-catch
		
		System.out.println("\nNumero total de personas: "+persona.numPersonas);
		System.out.println("Tamaño de la lista de colores: "+coloresFav.size());
	}  // end-main
} // end-class
