package es.florida.ae2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
				"\nVelocidad NEO: "+velocidadNEO
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
		String strFichero = args[0];
		int numProceso = 0;
		int numCores = 0;
		File ficheroNEO = new File(strFichero);
		Lanzador l = new Lanzador();
	
		try {
			FileReader fr = new FileReader(ficheroNEO);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			String nombre = "";
			double posicionNEO = 0, velocidadNEO = 0;
			
			while(linea != null) {
				//System.out.println(linea);
				String [] neos = linea.split(",");
				nombre = neos[0];
				posicionNEO = Double.parseDouble(neos[1]);
				velocidadNEO = Double.parseDouble(neos[2]);
				linea = br.readLine();
				
				l.lanzarProceso(nombre, posicionNEO, velocidadNEO);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end-try-catch
		long fin = System.currentTimeMillis();
		
		double tiempo = (double) ((fin - inicio)/1000);
		System.out.println("\nTiempo MEDIO de ejecucion del proceso: "+(tiempo/12)+" segundos");
        System.out.println("\nTiempo TOTAL de ejecucion del proceso: "+tiempo+" segundos");
	}
}
