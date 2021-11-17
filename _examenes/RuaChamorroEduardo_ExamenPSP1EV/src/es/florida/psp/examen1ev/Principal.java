package es.florida.psp.examen1ev;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Principal {
	public void lanzarCantidadPersonas(int numPersonas) {
		String clase = "es.florida.psp.examen1ev.Subproceso";
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
			command.add(Integer.toString(numPersonas));
			
			//System.out.println("Commando que pasa a ProcessBuilder: "+command);
			//System.out.println("Commando a ejecutar en cmd.exe: "+command);
			
			System.out.println("Numero de personas: "+numPersonas);
			
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
		Principal lanzador = new Principal();
		lanzador.lanzarCantidadPersonas(50);
	}
}
