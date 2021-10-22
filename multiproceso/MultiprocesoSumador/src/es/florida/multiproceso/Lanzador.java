package es.florida.multiproceso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Lanzador {
	public void lanzarSumador(Integer n1, Integer n2) {
		String clase = "es.florida.multiproceso.Sumador";
		try {
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator;
			String classpath = System.getProperty("java.class.path");
			System.out.println(classpath);
			String className = clase;
			
			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(n1.toString());
			command.add(n2.toString());
			
			System.out.println("Commando que pasa a ProcessBuilder: "+command);
			System.out.println("Commando a ejecutar en cmd.exe: "+command);
			
			ProcessBuilder builder = new ProcessBuilder(command);
			//Process process = builder.inheritIO().start(); 
			Process process = builder.start();
			process.waitFor();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Lanzador l = new Lanzador();
		l.lanzarSumador(1,50);
		l.lanzarSumador(51,100);
		System.out.println("Ok!");
	}
}
