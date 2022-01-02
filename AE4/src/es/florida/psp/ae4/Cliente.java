package es.florida.psp.ae4;
/*
 * @author Eduardo Rua Chamorro | 2. DAM - Florida Universitaria
 * @version AE4.0 - PSP
 * */
// importacion de librerias
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	/* Metodo: main
	 * Descripcion: Ejecuta el cliente de la aplicacion
	 * */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("CLIENTE >>> Arranca cliente");
		System.out.println("CLIENTE >>> Conexion al servidor");
		
		// recogemos el host del cliente por teclado
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce el host: ");
		String host = sc.nextLine();
		
		// proceso que recogera la contraseña introducida por el cliente
		InetSocketAddress direccion = new InetSocketAddress(host, 9876);
		Socket socket = new Socket(); socket.connect(direccion);
		ObjectInputStream inObjeto = new ObjectInputStream(socket.getInputStream());
		Contrasenya contrasenya = (Contrasenya) inObjeto.readObject();
		System.out.println("CLIENTE >>> Preparado canal para recibir resultado!");
		System.out.print("CLIENTE >>> Introduce una contrasenya: ");
		contrasenya.setContrasenyaIntroducida(sc.nextLine());
		ObjectOutputStream outObjeto = new ObjectOutputStream(socket.getOutputStream());
		outObjeto.writeObject(contrasenya);
		
		// menu de seleccion en el que el cliente indicara que metodo de encriptacion desea utilizar para la contraseña introducida
		System.out.println("CLIENTE >>> Enviando contrasenya al servidor: "+contrasenya.getContrasenyaIntroducida());
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		System.out.println("\nCLIENTE >>> METODOS DE ENCRIPTACION\n"
				+ "\t1: Encriptacion ASCII\n"
				+ "\t2: Encriptacion MD5 \n");
		System.out.print("Introduce el metodo de encriptacion que quieras usar: ");
		String tipoEncriptacion = sc.nextLine();
		switch(tipoEncriptacion) {
			case "1":
				System.out.println("CLIENTE >>> Metodo de encriptacion seleccionado: ASCII");
				break;
			case "2":
				System.out.println("CLIENTE >>> Metodo de encriptacion seleccionado: MD5");
				break;
			default:
				System.err.println("ERROR! Parece ser que no has indicado un metodo de encriptacion valido :(");
		} // end-switch
		pw.print(tipoEncriptacion+"\n");
		pw.flush();
		
		// leemos el objeto contraseña recibido por el servidor una vez se ha encriptado
		contrasenya = (Contrasenya) inObjeto.readObject();
		System.out.println("CLIENTE >>> Contrasenya encriptada recibida del servidor: "+contrasenya.getContrasenyaEncriptada());
		
		sc.close();
		inObjeto.close();
		outObjeto.close();
		socket.close();
	} // end-main
}
