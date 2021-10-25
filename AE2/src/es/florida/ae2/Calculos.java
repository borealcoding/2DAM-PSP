package es.florida.ae2;

import java.io.*;

public class Calculos {
	// declaraciones
	static double resultado;
	
	public static double calcularProbabilidad(String nombre, double posicionNEO, double velocidadNEO) {
		// declaraciones
		double posicionTierra = 1;
		double velocidadTierra = 100;
		
		for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) {
			posicionNEO = posicionNEO + velocidadNEO * i;
			posicionTierra = posicionTierra + velocidadTierra * i;
		} // end-for
		resultado = 100 * Math.random() *
		Math.pow( ((posicionNEO-posicionTierra)/(posicionNEO+posicionTierra)), 2);
		
		return resultado;
	} // end-calcularProbabilidad
	
	public static void main(String[] args) {
		calcularProbabilidad(args[0],Double.parseDouble(args[1]),Double.parseDouble(args[2]));
		double resultado = Calculos.resultado;
		
		if(resultado > 10) {
			System.err.println("\nProbabilidades de colision de "+args[0]+": "+(String.format("%.2f", resultado))+" %");
			System.err.println("ALERTA MUNDIAL! Las probabilidades de colision son altas.");
		} else {
			System.out.println("\nProbabilidades de colision de "+args[0]+": "+(String.format("%.2f", resultado))+" %");
			System.out.println("Pocas probabilidades de colision.");
		} // end if-else
		
		File fichero = new File("registroNEO_"+args[0]+".txt");
		try {
			// crea el fichero si no existe
			if(!fichero.exists()) {
				fichero.createNewFile();
			}
			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Probabilidades de colision: "+Double.toString(resultado)+" %");
			bw.close();		
			
		} catch (IOException e) {
			e.printStackTrace();
		} // end-try-catch
		
	} // end-main
} // end-class
