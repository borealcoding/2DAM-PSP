package es.florida.ae2;

/**
 * @author Eduardo Rua Chamorro - 2ºDAM | Florida Universitaria
 * @version 2.0 - AE2 | 25.10.21
 * @description El objetivo del programa NEO Help! es que desarrolles una aplicación Java que calcule la probabilidad de que un objeto tipo NEO colisione con la Tierra en los próximos 50 años. La aplicación deberá realizar lo siguiente:
	> Leer la información de un NEO (nombre, posicionNEO -posición relativa a la tierra- y velocidad NEO -velocidad en kilómetros por segundo relativa al Sol-) de un fichero de datos (se proporciona junto con este enunciado), en el que cada línea corresponde a un NEO, con los parámetros separados por comas.
	> Calcular la probabilidad de que el NEO colisione con la Tierra.
	> Guardar la probabilidad de colisión de cada NEO en un fichero independiente que se denomine <Nombre del NEO>.
	> Mostrar como salida las probabilidades de colisión de cada NEO (con 2 decimales) y si la probabilidad es mayor de un 10% lanzar una alerta mundial (vale con un System.err.println). Si no, lanzar un mensaje que transmita tranquilidad.
	> Mostar por pantalla el tiempo de ejecución total de la aplicación y el tiempo medio de 
ejecución por cada NEO que se ha analizado.
 */

import java.io.*;
import java.util.*;

public class Lanzador {
	// lanzador de comandos
	public void lanzarProceso(String nombre, double posicionNEO, double velocidadNEO, int numProceso, int numCores) {
		String clase = "es.florida.ae2.Calculos";
		try {
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			//System.out.println(classpath);
			String className = clase;
			
			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(nombre);
			command.add(Double.toString(posicionNEO));
			command.add(Double.toString(velocidadNEO));
			command.add(Integer.toString(numProceso));
			command.add(Integer.toString(numCores));
			
			//System.out.println("Commando que pasa a ProcessBuilder: "+command);
			//System.out.println("Commando a ejecutar en cmd.exe: "+command);
			System.out.println(
				"\nNombre asteroide: "+nombre+
				"\nPosicion NEO: "+posicionNEO+
				"\nVelocidad NEO: "+velocidadNEO+" km/s"+
				"\nProceso numero: "+numProceso+
				"\nNumero de cores: "+numCores
			);

			ProcessBuilder builder = new ProcessBuilder(command);
			Process process = builder.inheritIO().start(); 
			//Process process = builder.start();
			if(numProceso == numCores) {
				process.waitFor();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	} // end-lanzarProceso
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long inicio = System.currentTimeMillis();
		String strFicheroLectura = args[0];
		File ficheroNEO = new File(strFicheroLectura);
		Lanzador l = new Lanzador();
	
		try {
			FileReader fr = new FileReader(ficheroNEO);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine(), nombre = "";
			double posicionNEO = 0, velocidadNEO = 0;
			int numCores = Runtime.getRuntime().availableProcessors(), numProceso = 1, numBloque = 1;
			
			while(linea != null) {
				System.out.println("\n --- Bloque num: "+numBloque);
				// cada ejecucion del siguiente bucle for, correspondra a un bloque de informacion con tantas lineas como cores haya disponibles
				for(numProceso = 1; numProceso <= numCores; numProceso++) {
					// al existir 4 cores, se leeran 4 lineas del documento, mostrandose el calculo correspondiente a cada uno de ellos
					String [] neos = linea.split(",");
					nombre = neos[0];
					posicionNEO = Double.parseDouble(neos[1]);
					velocidadNEO = Double.parseDouble(neos[2]);
					linea = br.readLine();
					
					l.lanzarProceso(nombre, posicionNEO, velocidadNEO, numProceso, numCores);
				} // end-for
				numBloque++;
			} // end-while
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} // end-try-catch
		
		long fin = System.currentTimeMillis();
		double tiempo = (double) ((fin - inicio)/1000);
		System.out.println(
				"\n--------------"+
				"\nTiempo MEDIO de ejecucion del proceso: "+String.format("%.2f", (tiempo/12))+" segundos"+
				"\nTiempo TOTAL de ejecucion del proceso: "+String.format("%.2f", tiempo)+" segundos"
			);
	} // end-main
} // end-class
