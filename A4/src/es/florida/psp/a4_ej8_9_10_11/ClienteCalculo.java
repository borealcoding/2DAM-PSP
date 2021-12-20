package es.florida.psp.a4_ej8_9_10_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClienteCalculo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("CLIENTE >>> Arranca cliente");
		System.out.println("CLIENTE >>> Conexion al servidor");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce el host: ");
		String host = sc.nextLine();
		
		InetSocketAddress direccion = new InetSocketAddress(host, 9876);
		Socket socket = new Socket();
		socket.connect(direccion);
		System.out.println("CLIENTE >>> Preparado canal para recibir resultado");
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader bfr = new BufferedReader(isr);
		System.out.println("CLIENTE >>> Envio de datos para el calculo");
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		System.out.print("Introduce el tipo de operacion matematica (+, -, *, /): ");
		pw.print(sc.nextLine()+"\n");
		System.out.print("Primer numero: ");
		pw.print(sc.nextLine()+"\n");
		System.out.print("Segundo numero: ");
		pw.print(sc.nextLine()+"\n");
		pw.flush();
		String resultado = bfr.readLine();
		System.out.println("CLIENTE >>> Recibe resultado: " + resultado);
	} // end-main
} // end-class
