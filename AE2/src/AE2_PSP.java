import java.io.*;

/*
 * @author Eduardo Rua Chamorro | 2º DAM - Florida Universitaria
 * @version 2.0 | 19.10.21
 * @description El objetivo del programa NEO Help! es que desarrolles una aplicación Java que calcule la probabilidad de que un objeto tipo NEO colisione con la Tierra en los próximos 50 años. La aplicación deberá realizar lo siguiente:
	> Leer la información de un NEO (nombre, posicionNEO -posición relativa a la tierra- y velocidad NEO -velocidad en kilómetros por segundo relativa al Sol-) de un fichero de datos (se proporciona junto con este enunciado), en el que cada línea corresponde a un NEO, con los parámetros separados por comas.
	> Calcular la probabilidad de que el NEO colisione con la Tierra.
	> Guardar la probabilidad de colisión de cada NEO en un fichero independiente que se denomine <Nombre del NEO>.
	> Mostrar como salida las probabilidades de colisión de cada NEO (con 2 decimales) y si la probabilidad es mayor de un 10% lanzar una alerta mundial (vale con un System.err.println). Si no, lanzar un mensaje que transmita tranquilidad.
	> Mostar por pantalla el tiempo de ejecución total de la aplicación y el tiempo medio de ejecución por cada NEO que se ha analizado.
* Para calcular el resultado de la probabilidad de colisión se debe realizar una simulación mediante
el siguiente código:
	double posicionTierra = 1;
	double velocidadTierra = 100;
	for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) {
		posicionNEO = posicionNEO + velocidadNEO * i;
		posicionTierra = posicionTierra + velocidadTierra * i;
	}
	double resultado = 100 * Math.random() *
	Math.pow( ((posicionNEO-posicionTierra)/(posicionNEO+posicionTierra)), 2);
*/
public class AE2_PSP {
	
	public static void leerInfoNEO() {
		String strFichero = "NEOs.txt";
		File ficheroNEO = new File(strFichero);
		try {
			FileReader fr = new FileReader(ficheroNEO);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			
			while(linea != null) {
				System.out.println(linea);
				linea = br.readLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end-try-catch
		
	} // end-leerInfoNEO
	
	public static void calcularProbabilidad() {
		String strFichero = "NEOs.txt";
		File ficheroNEO = new File(strFichero);
		try {
			FileReader fr = new FileReader(ficheroNEO);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			
			while(linea != null) {
				System.out.println(linea);
				linea = br.readLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end-try-catch
		
		/*int [] posicionesNEO = new int[12];
		
		for(int i = 0; i < posicionesNEO.length; i++) {
			
		}
		
		double posicionTierra = 1;
		double velocidadTierra = 100;
		for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) {
			posicionNEO = posicionNEO + velocidadNEO * i;
			posicionTierra = posicionTierra + velocidadTierra * i;
		}
		double resultado = 100 * Math.random() *
		Math.pow( ((posicionNEO-posicionTierra)/(posicionNEO+posicionTierra)), 2);*/
	}
	
	public static void main(String[] args) {
		leerInfoNEO();
	} // end-main
} // end-class
