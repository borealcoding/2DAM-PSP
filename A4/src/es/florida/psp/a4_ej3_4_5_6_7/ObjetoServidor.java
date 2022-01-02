package es.florida.psp.a4_ej3_4_5_6_7;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ObjetoServidor {
	public static void main(String[] arg) throws IOException, ClassNotFoundException, InterruptedException {
		int numeroPuerto = 5000;
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		System.err.println("SERVIDOR >> Escuchando...");
		Socket cliente = servidor.accept();
		ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
		// 	propiedades del objeto Persona: nombre, edad
		Persona p = new Persona();
		outObjeto.writeObject(p);
		System.err.println("SERVIDOR >> Envio a cliente: " + p.getNombre() + " - " + p.getEdad());
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
		Persona pMod = (Persona) inObjeto.readObject();
		Thread.sleep(2000);
		System.err.println("SERVIDOR >> Recibo de cliente: " + pMod.getNombre()+ " - " +
		pMod.getEdad());
		outObjeto.close();
		inObjeto.close ();
		cliente.close ();
		servidor.close();
	} // end-main
} // end-class
