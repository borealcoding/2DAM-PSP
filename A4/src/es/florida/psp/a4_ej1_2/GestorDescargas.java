/*
 * @author Eduardo Ruá Chamorro | 2º DAM
 * @version A4 - 16.12.2021
 * @description: Implementa para que funcione en tu equipo un gestor de descargas de ficheros de texto como el visto en el ejemplo de teoría. Necesitarás tener los recursos a descargar en el directorio correspondiente de XAMPP.
 */


package es.florida.psp.a4_ej1_2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class GestorDescargas {
	public void descargarArchivo(String urlDescargar, String nombreArchivo) {
		System.out.println("> DESCARGANDO ..."+urlDescargar);
		try {
			URL url = new URL(urlDescargar);
			InputStream is = url.openStream();
			InputStreamReader ir = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(ir);
			FileWriter escritorFichero = new FileWriter(nombreArchivo);
			String linea;
			while((linea = br.readLine()) != null) {
				escritorFichero.write(linea);
			} // end-while
			escritorFichero.close();
			br.close();
			ir.close();
			is.close();
			System.out.println("+ ARCHIVO DESCARGADO CORRECTAMENTE!");
		} catch (MalformedURLException mue) {
			System.err.println("LA URL NO ESTA BIEN ESCRITA! :(");
		} catch (IOException ex) {
			System.err.println("FALLO EN LA LECTURA DEL FICHERO! :(");
		}
	} // end-descargarArchivo
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestorDescargas gd = new GestorDescargas();
		String url = "http://localhost:800/archivosMisc/leeme.txt";
		String nombreArchivo = "./txt/leeme.txt";
		gd.descargarArchivo(url, nombreArchivo);
	}

}
