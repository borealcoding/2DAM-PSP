package es.florida.psp.a4_ej8_9_10_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Peticion implements Runnable {
	BufferedReader bfr;
	PrintWriter pw;
	Socket socket;
	
	public Peticion(Socket socket){
		this.socket = socket;
	} // end-constructor
	
	public int extraerNumero(String linea) {
		int numero;
		try { numero = Integer.parseInt(linea); }
		catch (NumberFormatException e) { numero = 0; }
		if (numero >= 100000000) { numero = 0; }
		return numero;
	} // end-extraerNumero
	
	public int calcular(String op, String n1, String n2) {
		int resultado = 0;
		char simbolo = op.charAt(0);
		int num1 = extraerNumero(n1);
		int num2 = extraerNumero(n2);
		if (simbolo == '+') { resultado = num1 + num2; }
		return resultado;
	} // end-calcular
	
	public void run() {
		try {
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			bfr = new BufferedReader(isr);
			OutputStream os = socket.getOutputStream();
			pw = new PrintWriter(os);
			String operacion = bfr.readLine();
			System.err.println("SERVIDOR >>> Lee datos para la operacion");
			String nombreCliente = bfr.readLine();
			String num1 = bfr.readLine();
			String num2 = bfr.readLine();
			System.err.println("SERVIDOR >>> Realiza la operacion");
			Integer result = calcular(operacion, num1, num2);
			System.err.println("SERVIDOR >>> Devuelve resultado");
			pw.write(result.toString() + "\n");
			pw.flush();
			System.err.println("SERVIDOR >>> Espera nueva peticion de "+nombreCliente);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("SERVIDOR >>> Error.");
		} // end-try-catch
	} // end-run
} // end-class
