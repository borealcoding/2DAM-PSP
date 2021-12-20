package es.florida.psp.a4_ej8_9_10_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCalculo {
	public static int extraerNumero(String linea) {
		int numero;
		try {
			numero = Integer.parseInt(linea);
		} catch (NumberFormatException e) {
			numero = 0;
		}
		if (numero >= 100000000) { numero = 0; }
		return numero;
	} // end-extraerNumero
	
	public static int calcular(String op, String n1, String n2) {
		int resultado = 0;
		char simbolo = op.charAt(0);
		int num1 = extraerNumero(n1);
		int num2 = extraerNumero(n2);
		if (simbolo == '+') {
			resultado = num1 + num2;
		} // end-if
		if (simbolo == '-') {
			resultado = num1 - num2;
		} // end-if
		if (simbolo == '*') {
			resultado = num1 * num2;
		} // end-if
		if (simbolo == '/') {
			resultado = num1 / num2;
		} // end-if
		return resultado;
	} // end-calcular
	
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
			String linea = bf.readLine();
			String num1 = bf.readLine();
			String num2 = bf.readLine();
			System.err.println("SERVIDOR >>> Realiza la operacion");
			Integer result = calcular(linea, num1, num2);
			System.err.println("SERVIDOR >>> Devuelve resultado");
			OutputStream os = conexion.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write(result.toString() + "\n");
			pw.flush();
			System.err.println("SERVIDOR >>> Espera nueva peticion");
		}
	} // end-main
} // end-class
