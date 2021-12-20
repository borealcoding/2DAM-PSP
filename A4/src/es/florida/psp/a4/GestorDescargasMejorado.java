/*
 * @author Eduardo Ruï¿½ Chamorro | 2ï¿½ DAM
 * @version A4 - 16.12.2021
 * @description: Modifica el programa anterior para que puedas descargar tambiï¿½n imï¿½genes y otros tipos de archivos que no sean ficheros de texto. Ten en cuenta que tendrï¿½s que manejar los datos como bytes, ya no valdrï¿½ utilizar objetos de tipo Reader que leen lï¿½neas o caracteres.
 */

package es.florida.psp.a4;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GestorDescargasMejorado {
	public void descargarArchivo(String urlDescargar, String nombreArchivo) {
		System.out.println("> DESCARGANDO ..."+urlDescargar);
		try {
			String nombreDir = "./descarreges";
			URL url = new URL(urlDescargar);  
			// Conexión abierta  
			URLConnection con = url.openConnection();  
			// Establece el tiempo de espera de la solicitud en 5s  
			con.setConnectTimeout(5*1000);  
			// Flujo de entrada  
			InputStream is = con.getInputStream();  
			 
			// Buffer
			byte[] bs = new byte[1024];  
			// Longitud de los datos leidos 
			int len;  
			// Flujo de archivo de salida  
			File sf=new File(nombreDir);  
			if(!sf.exists()){  
			    sf.mkdirs();  
			}  
			OutputStream os = new FileOutputStream(sf.getPath()+"/"+nombreArchivo);  
			
		    // Proceso de lectura
		    while ((len = is.read(bs)) != -1) {  
		      os.write(bs, 0, len);  
		    }  
		    // Proceso finalizado 
		    os.close();  
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
		String url = "http://localhost:800/archivosMisc/kfcMeme.jpg";
		String nombreArchivo = "kfcMeme.jpg";
		gd.descargarArchivo(url, nombreArchivo);
	}

}
