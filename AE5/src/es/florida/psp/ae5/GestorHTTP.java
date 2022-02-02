/*
 * @author Eduardo Ruá Chamorro
 * @version AE5 - 30/01/2022
 * @description Gestor de peticiones GET y POST.
 * */
package es.florida.psp.ae5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class GestorHTTP implements HttpHandler {
	// DECLARACIONES GLOBALES
	int temperaturaActual = 15, temperaturaTermostato = 15;

	/* FUNCION ENCARGADA DE REGULAR LA TEMPERATURA. 
	 * NOS ASEGURAMOS DE QUE ESTA NO SUPERE EL MAXIMO DEL TERMOSTATO.*/
	private void regularTemperatura() {
		// DECLARACIONES
		int termostato = temperaturaTermostato;
		try {
			while (temperaturaActual != termostato) {
				if (temperaturaActual > termostato) {
					temperaturaActual--;
					System.out.println(temperaturaActual);
				} else if (temperaturaActual < termostato) {
					temperaturaActual++;
					System.out.println(temperaturaActual);
				} // end-if
				Thread.sleep(5000);
			} // end-while
			// CUANDO LLEGUE A SU LÍMITE, NOS SALTARÁ UN AVISO POR CONSOLA
			System.err.println("TEMPERATURA FIJADA ALCANZADA!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // end-try-catch
	} // end-regularTemperatura()

	// -----> MANEJADOR
	public void handle(HttpExchange httpExchange) {
		// DECLARACIONES
		String requestParamValue = null;
		try {
			if ("GET".equals(httpExchange.getRequestMethod())) {
				requestParamValue = handleGetRequest(httpExchange);
				handleGETResponse(httpExchange, requestParamValue);
			} else if ("POST".equals(httpExchange.getRequestMethod())) {
				requestParamValue = handlePostRequest(httpExchange);
				handlePOSTResponse(httpExchange, Integer.parseInt(requestParamValue));
			} // end-if
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} // end-try
	} // end-handle

	// -----> RESPUESTA GET
	private void handleGETResponse(HttpExchange httpExchange, String requestParamValue) {
		// DECLARACIONES
		OutputStream outputStream = httpExchange.getResponseBody();
		String htmlResponse = "<!DOCTYPE html>"
				+ "<html lang=\"es\">"
				+ "<head>"
				+ "    <meta charset=\"UTF-8\">"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
				+ "    <meta name=\"author\" content=\"Eduardo Rua Chamorro\">"
				+ "    <style>"
				+ "			body {"
				+ "				margin: 0;"
				+ "  			padding: 0;"
				+ "  			display: flex;"
				+ "  			justify-content: center;"
				+ "  			align-items: center;"
				+ "  			font-family: \"Helvetica Neue\", Helvetica, Arial, sans-serif;"
				+ "  			font-size: 14px;"
				+ "  			line-height: 1.42857143;"
				+ "  			color: #000;"
				+ "  			background-color: #fff;"
				+ "  			background-image: url(\"https://images5.alphacoders.com/569/thumb-1920-569815.jpg\");}"
				+ "			section#content {"
				+ "				margin-top: 20px;"
				+ "  			padding: 20px;"
				+ "  			width: 28em;"
				+ "  			height: auto;"
				+ "  			display: flex;"
				+ "  			flex-direction: column;"
				+ "  			align-items: center;"
				+ "  			justify-content: center;"
				+ "				text-align: center;"
				+ "  			background-color: #a7a6ee9a;"
				+ "  			background-image: none;"
				+ "  			border-radius: 4px;"
				+ "  			box-shadow: rgba(50, 50, 93, 0.25) 0px 6px 12px -2px, rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;"
				+ "  			transition: all 0.3s cubic-bezier(0.25, 0.8, 0.25, 1);}"
				+ "	   </style>"
				+ "    <title>AE5 - HTTP</title>"
				+ "</head>"
				+ "<body>"
				+ "    <section id=\"content\">"
				+ "        <h1>Peticiones HTTP para regular el termostato del reino!</h1>"
				+ "        <h2>Temperatura Actual:&nbsp;</strong>"+temperaturaActual+"</h2>"
				+ "		   <h2><strong>Termostato:&nbsp;</strong>"+temperaturaTermostato+"</h2>"
				+ "    </section>"
				+ "</body>"
				+ "</html>";
		try {
			httpExchange.sendResponseHeaders(200, htmlResponse.length());
			outputStream.write(htmlResponse.getBytes());
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		} // end-try-catch
	} // end-handleGETResponse

	// -----> PETICION GET
	private String handleGetRequest(HttpExchange httpExchange) {
		return httpExchange.getRequestURI().toString().split("\\?")[1];
	} // end-handleGetRequest

	// -----> RESPUESTA POST
	private void handlePOSTResponse(HttpExchange httpExchange, int requestParamValue) {
		// DECLARACIONES
		OutputStream outputStream = httpExchange.getResponseBody();
		String htmlResponse = "";
		try {
			if (requestParamValue != -7000) {
				temperaturaTermostato = requestParamValue;
				htmlResponse = "Fijando temperatura que podra alcanzar el termostato..."
						+ "\nTemperatura obtenida: " + requestParamValue;
				System.out.println(htmlResponse);
			} // end-if
			httpExchange.sendResponseHeaders(200, htmlResponse.length());
			outputStream.write(htmlResponse.getBytes());
			outputStream.flush();
			outputStream.close();
			regularTemperatura();
		} catch (IOException e) {
			e.printStackTrace();
		} // end-try-catch
	} // end-handlePOSTResponse

	// -----> PETICION POST
	private String handlePostRequest(HttpExchange httpExchange) {
		// DECLARACIONES
		InputStream inputStream = httpExchange.getRequestBody();
		InputStreamReader isr = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(isr);
		String linea, setTemperatura, temp = handleGetRequest(httpExchange);
		String postRequest = "";
		temp = temp.split("=")[1];
		try {
			while ((linea = br.readLine()) != null) {
				postRequest += linea + "\n";
			} // end-while
			setTemperatura = postRequest.split("=")[0];
			if (setTemperatura.equals("setTemperatura")) {
				temp = postRequest.split("=")[1];
			} // end-if

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} // end-try-catch
		return temp;
	} // end-handlePostRequest
} // end-class
