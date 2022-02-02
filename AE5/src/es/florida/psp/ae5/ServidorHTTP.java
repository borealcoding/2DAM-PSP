/*
 * @author Eduardo Ruá Chamorro
 * @version AE5 - 30/01/2022
 * @description Servidor HTTP
 * */
package es.florida.psp.ae5;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

public class ServidorHTTP {
	public static void main(String[] args) throws IOException, InterruptedException {
		String host = "localhost"; int puerto = 7777;
		InetSocketAddress direccionTCPIP = new InetSocketAddress(host, puerto);
		int backlog = 0;
		HttpServer servidor = HttpServer.create(direccionTCPIP, backlog);
		GestorHTTP gestorHTTP = new GestorHTTP();
		String rutaRespuesta = "/estufa";
		servidor.createContext(rutaRespuesta, gestorHTTP);
		// ThreadPoolExecutor se encargará del multihilo
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
		servidor.setExecutor(threadPoolExecutor);
		servidor.start();
		System.out.println("> ARRANCANDO SERVIDOR ...");
		Thread.sleep(1500);
		System.out.println("SERVIDOR HTTP ARRANCADO EN EL PUERTO " + puerto);
	} // end-main
} // end-class
