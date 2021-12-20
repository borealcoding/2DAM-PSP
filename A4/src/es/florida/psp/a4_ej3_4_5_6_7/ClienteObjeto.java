package es.florida.psp.a4_ej3_4_5_6_7;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteObjeto {
	public static void main(String[] arg) throws UnknownHostException, IOException,
		ClassNotFoundException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce el host: ");
		String host = sc.nextLine();
		int puerto = 5000;
		System.out.println("CLIENTE >> Arranca cliente");
		Socket cliente = new Socket(host,puerto);
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
		Persona p = (Persona) inObjeto.readObject();
		Thread.sleep(1000);
		System.out.println("CLIENTE >> Recibo del servidor: "+p.getNombre() + " - " +
		p.getEdad());
		p.setNombre("Eduardo Rua");
		p.setEdad("23");
		ObjectOutputStream pMod = new ObjectOutputStream(cliente.getOutputStream());
		pMod.writeObject(p);
		Thread.sleep(1000);
		System.out.println("CLIENTE >> Envio al servidor: "+p.getNombre() + " - " +
		p.getEdad());
		inObjeto.close();
		pMod.close();
		cliente.close();
	} // end-main
} // end-class
