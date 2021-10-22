package es.florida.ae2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Calculos {

	public static void calcularProbabilidad(String nombre, double posicionNEO, double velocidadNEO) {
		
		double posicionTierra = 1;
		double velocidadTierra = 100;
		for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) {
			posicionNEO = posicionNEO + velocidadNEO * i;
			posicionTierra = posicionTierra + velocidadTierra * i;
		}
		double resultado = 100 * Math.random() *
		Math.pow( ((posicionNEO-posicionTierra)/(posicionNEO+posicionTierra)), 2);
		;
		
		
		
		if(resultado > 10) {
			System.err.println("Probabilidades de colision: "+(String.format("%.2f", resultado)));
			System.err.println("ALERTA MUNDIAL! Las probabilidades de colision son altas.");
		}
		else {
			System.out.println("Probabilidades de colision: "+(String.format("%.2f", resultado)));
			System.out.println("Pocas probabilidades de colision.");
		}
	}
		
	public static void main(String[] args) {
		calcularProbabilidad(args[0],Double.parseDouble(args[1]),Double.parseDouble(args[2]));
       
        // System.nanoTime
	} // end-main

}
