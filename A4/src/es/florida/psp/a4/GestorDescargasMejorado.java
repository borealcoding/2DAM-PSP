/*
 * @author Eduardo Ru� Chamorro | 2� DAM
 * @version A4 - 16.12.2021
 * @description: Modifica el programa anterior para que puedas descargar tambi�n im�genes y otros tipos de archivos que no sean ficheros de texto. Ten en cuenta que tendr�s que manejar los datos como bytes, ya no valdr� utilizar objetos de tipo Reader que leen l�neas o caracteres.
 */

package es.florida.psp.a4;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class GestorDescargasMejorado {
	public void descargarArchivo(String urlDescargar, String nombreArchivo) {
		System.out.println("> DESCARGANDO ..."+urlDescargar);
		try {
			URL url = new URL(urlDescargar);
			InputStream is = url.openStream();
			Byte [] buff;
			OutputStream os = new FileOutputStream(nombreArchivo);
			
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
		String url = "http://localhost:800/archivosMisc/kfcMeme.jpg";
		String nombreArchivo = "./txt/kfcMeme.jpg";
		gd.descargarArchivo(url, nombreArchivo);
	}

}
