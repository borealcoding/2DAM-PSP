package es.florida.ae2;

import java.io.*;
import java.util.*;

public class Lanzador {
	// lanzador de comandos
	public void lanzarProceso(String nombre, double posicionNEO, double velocidadNEO) {
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
			
			//System.out.println("Commando que pasa a ProcessBuilder: "+command);
			//System.out.println("Commando a ejecutar en cmd.exe: "+command);
			System.out.println(
				"\nNombre asteroide: "+nombre+
				"\nPosicion NEO: "+posicionNEO+
				"\nVelocidad NEO: "+velocidadNEO+" km/s"
			);

			ProcessBuilder builder = new ProcessBuilder(command);
			Process process = builder.inheritIO().start(); 
			//Process process = builder.start();
			process.waitFor();
		
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	} // end-lanzarProceso
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long inicio = System.currentTimeMillis();
		String strFicheroLectura = args[0]; // strFicheroEscritura = args[1];
		int numProceso = 0, numCores = 0;
		File ficheroNEO = new File(strFicheroLectura); //ficheroResultados = new File(strFicheroEscritura);
		Lanzador l = new Lanzador();
	
		try {
			FileReader fr = new FileReader(ficheroNEO);
			BufferedReader br = new BufferedReader(fr);
			//FileWriter fw = new FileWriter(ficheroResultados);
			//BufferedWriter bw = new BufferedWriter(fw);
			String linea = br.readLine(), nombre = "";
			double posicionNEO = 0, velocidadNEO = 0;
			int cores = Runtime.getRuntime().availableProcessors(), contador = 0;
			
			// se crea el fichero de escritura sino existe
			/*if(!ficheroResultados.exists()) {
				ficheroResultados.createNewFile();
			} // end-if*/
			
			while(contador < cores) {
				String [] neos = linea.split(",");
				nombre = neos[0];
				posicionNEO = Double.parseDouble(neos[1]);
				velocidadNEO = Double.parseDouble(neos[2]);
				linea = br.readLine();
				
				l.lanzarProceso(nombre, posicionNEO, velocidadNEO);
				contador++;
				
			} // end-while

		} catch (IOException e) {
			e.printStackTrace();
		} // end-try-catch
		long fin = System.currentTimeMillis();
		double tiempo = (double) ((fin - inicio)/1000);
		System.out.println("\nTiempo MEDIO de ejecucion del proceso: "+String.format("%.2f", (tiempo/12))+" segundos");
        System.out.println("Tiempo TOTAL de ejecucion del proceso: "+String.format("%.2f", tiempo)+" segundos");
	}
}
