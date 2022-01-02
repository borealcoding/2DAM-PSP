package es.florida.psp.ae4;
/*
 * @author Eduardo Rua Chamorro | 2. DAM - Florida Universitaria
 * @version AE4.0 - PSP
 * */
// importacion de librerias
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	@SuppressWarnings("resource")
	/* Metodo: main
	 * Descripcion: Ejecuta el servidor de la aplicacion
	 * */
	public static void main(String[] args) throws IOException {
		System.err.println("SERVIDOR >>> Arranca el servidor, espera peticion");
		ServerSocket socketEscucha = null;
		try {
			socketEscucha = new ServerSocket(9876);
		} catch (IOException e) {
			System.err.println("SERVIDOR >>> Error");
			return;
		} // end-try-catch
		while (true) {
			Socket conexion = socketEscucha.accept();
			System.err.println("SERVIDOR >>> Conexion recibida --> Lanza hilo clase Peticion");
			Peticion p = new Peticion(conexion);
			Thread hilo = new Thread(p);
			hilo.start();
		} // end-while
	} // end-main
} // end-class