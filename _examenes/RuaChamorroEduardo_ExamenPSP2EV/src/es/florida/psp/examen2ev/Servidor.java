package es.florida.psp.examen2ev;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.err.println("SERVIDOR >>> Arranca el servidor, espera peticion");
		ServerSocket socketEscucha = null;
		try {
			socketEscucha = new ServerSocket(9876);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		while (true) {
			Socket conexion = socketEscucha.accept();
			System.err.println("SERVIDOR >>> Conexion recibida!");
			InputStream is = conexion.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader bf = new BufferedReader(isr);
			System.err.println("SERVIDOR >>> Lee datos para la operacion");
			
			// lectura del nombre de usuario
			String nombreCliente = bf.readLine();
			OutputStream os = conexion.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write(nombreCliente+"\n");
			pw.flush();
			System.err.println("SERVIDOR >>> Espera nueva peticion de "+nombreCliente);

			// revisar lista de usuarios
			File listaUsuarios = new File("./txt/Usuarios_autorizados.txt");
			FileReader fr = new FileReader(listaUsuarios);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			boolean autorizado = false;
			// revisar si el usuario esta en la lista de usuarios
			while (linea != null) {
				if (linea.equals(nombreCliente)) {
					autorizado = true;
				}
				linea = br.readLine();
			}

			if(autorizado) {
				System.err.println("SERVIDOR >>> Usuario autorizado");
				pw.write("200 OK\n");
				pw.flush();
			} else {
				System.err.println("SERVIDOR >>> Usuario no autorizado");
				pw.write("ERROR\n");
				pw.flush();
			}

			// lectura de la contrasena
			String contrasena = bf.readLine();
			System.err.println("SERVIDOR >>> Contrasena recibida: "+contrasena);
			// revisar lista de contrasenas
			File listaContrasenas = new File("./txt/Contrasenyas_autorizadas.txt");
			FileReader fr2 = new FileReader(listaContrasenas);
			BufferedReader br2 = new BufferedReader(fr2);
			String linea2 = br2.readLine();
			boolean correcta = false;
			while (linea2 != null) {
				if (linea2.equals(contrasena)) {
					correcta = true;
				}
				linea2 = br2.readLine();
			}

			if(correcta) {
				System.err.println("SERVIDOR >>> Contrasena autorizada");
				pw.write("200 OK\n");
				pw.flush();
			} else {
				System.err.println("SERVIDOR >>> Contrasena no autorizada");
				pw.write("ERROR\n");
				pw.flush();
			}

			// recibimos mensaje del cliente para saber si estamos preparados para enviar el fichero
			String estado = bf.readLine();
			System.err.println("SERVIDOR >>> Estado recibido: "+estado);
			if (estado.equals("PREPARADO")) {
				System.err.println("SERVIDOR >>> Preparados para enviar el fichero!");
				// leemos el fichero para enviarlo como mensaje
				File mensaje = new File("./txt/Contenido_a_enviar.txt");
				FileReader fr3 = new FileReader(mensaje);
				BufferedReader br3 = new BufferedReader(fr3);
				String linea3 = br3.readLine();
				// recogemos cuantas lineas tiene el fichero y enviamos su contenido
				int numLineas = 0;
				while (linea3 != null) {
					numLineas++;
					linea3 = br3.readLine();
				}
				pw.write(numLineas+"\n");
				pw.flush();
				System.err.println("SERVIDOR >>> Numero de lineas: "+numLineas);
				fr3 = new FileReader(mensaje);
				br3 = new BufferedReader(fr3);
				linea3 = br3.readLine();
				while (linea3 != null) {
					pw.write(linea3+"\n");
					pw.flush();
					linea3 = br3.readLine();
				}
				System.err.println("SERVIDOR >>> Fichero enviado!");
				// terminados todos los procesos, cerramos la conexion y todos los demas objetos
				conexion.close();
				pw.close();
				br.close();
				br2.close();
				br3.close();
				fr.close();
				fr2.close();
				fr3.close();
				break;
			}
			if (estado.equals("ERROR")) {
				System.err.println("SERVIDOR >>> No preparado para enviar fichero");
				// cerramos conexion y objetos
				conexion.close();
				pw.close();
				br.close();
				br2.close();
				fr.close();
				fr2.close();
				break;
			}
		}
	} // end-main
} // end-class
