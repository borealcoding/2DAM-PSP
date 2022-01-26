package es.florida.psp.examen2ev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("CLIENTE >>> Arranca cliente");
		System.out.println("CLIENTE >>> Conexion al servidor");
		
		Scanner sc = new Scanner(System.in);
		
		InetSocketAddress direccion = new InetSocketAddress("localhost", 9876);
		Socket socket = new Socket();
		socket.connect(direccion);
		System.out.println("CLIENTE >>> Preparado canal para recibir resultado");
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader bfr = new BufferedReader(isr);
		
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		// enviamos el nombre de usuario
		System.out.print("CLIENTE >>> Indica tu nombre de usuario: ");
		String nombreCliente = sc.nextLine();
		pw.print(nombreCliente+"\n");
		pw.flush();
		String resultado = bfr.readLine();
		System.out.println("CLIENTE >>> Usuario recibido: " + resultado);

		// recibimos respuesta de autorizacion
		String autorizado = bfr.readLine();
		if (autorizado.equals("200 OK")) {
			System.out.println("CLIENTE >>> Usuario autorizado");
			// solicitamos contrasena y enviamos
			System.out.print("Introduce la contrasena: ");
			String contrasena = sc.nextLine();
			pw.print(contrasena+"\n");
			pw.flush();
			// recibimos respuesta de confirmacion de contrasena
			String confirmacion = bfr.readLine();
			if (confirmacion.equals("200 OK")) {
				System.out.println("CLIENTE >>> Contrasena correcta");
				// enviamos confirmacion al servidor
				pw.print("PREPARADO\n");
				pw.flush();
				// recibimos lineas de texto del fichero
				String lineas = bfr.readLine();
				System.out.println("CLIENTE >>> Lineas del fichero leido: " + lineas);
				// recibimos texto del fichero
				String texto = bfr.readLine();
				while(texto != null) {
					System.out.println("CLIENTE >>> Texto recibido: " + texto);
					texto = bfr.readLine();
					Thread.sleep(500);
				}
				System.out.println("CLIENTE >>> Fin de fichero.");
				socket.close();
			} 
			if (confirmacion.equals("ERROR")) {
				System.out.println("CLIENTE >>> "+confirmacion+". Contrasena incorrecta");
				pw.write("ERROR\n");
				pw.flush();
				// cerramos comunicacion
				socket.close();
			}
		} 
		if (autorizado.equals("ERROR")) {
			System.out.println("CLIENTE >>> "+autorizado+". Usuario no autorizado");
		}
	} // end-main
} // end-class
