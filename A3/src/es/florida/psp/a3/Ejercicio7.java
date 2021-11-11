package es.florida.psp.a3;

import java.io.*;
public class Ejercicio7 implements Runnable {
	double distancia = 1;
	double velocidad;
	String nombre;
	static String nombreFicheroLlegada = "ficheroLlegada.txt";

	Ejercicio7(String nombre, double velocidad) {
		this.nombre = nombre;
		this.velocidad = velocidad;
	} // end-constructor

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File ficheroLlegada = new File(nombreFicheroLlegada);
		ficheroLlegada.delete(); // borrar si existe para empezar carrera nueva

		String[] nombres = {"Turbo","Rayo","Flash","Viento","Lightspeed"};
		double[] velocidades = {0.01,0.01,0.01,0.01,0.01};
		int[] prioridades = {1,2,3,4,10};
		Ejercicio7 objetoCaracol;
		Thread hiloCaracol;
		for (int i = 0; i < nombres.length; i++) {
			objetoCaracol = new Ejercicio7(nombres[i], velocidades[i]);
			hiloCaracol = new Thread(objetoCaracol);
			hiloCaracol.setPriority(prioridades[i]);
			hiloCaracol.start();
		} // end-for
		boolean ficheroExiste = false;
		FileReader fr;
		while (!ficheroExiste) {
			try {
				fr = new FileReader(nombreFicheroLlegada);
				BufferedReader br = new BufferedReader(fr);
				String nombre = br.readLine();
				System.err.println("El caracol " + nombre + " ha llegado a la meta!!");
				br.close();
				fr.close();
				ficheroExiste = true;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				ficheroExiste = false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
			} // end-try
		} // end-while
		System.out.println("El caracol ha llegado a la meta");
	} // end-main
	
	public void run() {
		File ficheroLlegada = new File(nombreFicheroLlegada);
		double avance = 0;
		double porcentaje = 0;
		System.out.println("El caracol " + nombre + " ha empezado a correr");
		while (avance < distancia) {
			if(ficheroLlegada.exists()) {
				System.out.println(nombre+"> Alguien ha ganado la carrera... abandono en el "+String.format("%.0f", porcentaje)+"% :(");
				avance = distancia;
			} else {
				avance += velocidad * 1;
				porcentaje = (avance / distancia) * 100;
				System.out.println(nombre+" > "+String.format("%.0f", porcentaje)+"%");
			} // end-if
		} // end-while
		if(!ficheroLlegada.exists()) {
			FileWriter fw;
			try {
				fw = new FileWriter(nombreFicheroLlegada,true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(nombre);
				bw.newLine();
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // end-try
			System.err.println(nombre+" > ¡¡¡HE LLEGADO A LA META!!! ¡¡¡HE GANADO LA CARRERA!!!");
		} // end-if
	} // end-run
} // end-class
