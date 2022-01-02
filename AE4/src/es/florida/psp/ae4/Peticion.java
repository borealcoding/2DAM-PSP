package es.florida.psp.ae4;
/*
 * @author Eduardo Rua Chamorro | 2. DAM - Florida Universitaria
 * @version AE4.0 - PSP
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Peticion implements Runnable {
	// declaraciones
	BufferedReader bfr;
	PrintWriter pw;
	Socket socket;
	
	public Peticion(Socket socket){
		this.socket = socket;
	} // end-constructor
	
	public String encriptacionASCII(String contrasenya) {
        char array[] = contrasenya.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0 && array[i] <= 31 && array[i] == 127) {
                array[i] = '*';
            } else {
                array[i] = (char) (array[i] + (char) 1);
            } // end-if
        } // end-for
        return String.valueOf(array);
    } // end-encriptacionASCII
	
	public static String encriptacionMD5(String contrasenya) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(contrasenya.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            } // end-while
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } // end-try-catch
    } // end-encriptacionMD5
	
	public void run() {
		try {
			// creacion del objeto Contrasenya, para luego ser enviado al cliente
			ObjectOutput outObjeto = new ObjectOutputStream(socket.getOutputStream());
			Contrasenya contrasenya = new Contrasenya();
			outObjeto.writeObject(contrasenya);
			
			// recoge la contraseña introducida por el cliente mediante teclado
			ObjectInputStream inObjeto = new ObjectInputStream(socket.getInputStream());
			Contrasenya pMod = (Contrasenya) inObjeto.readObject();
			System.err.println("SERVIDOR >>> Contrasenya recibida del cliente: "+pMod.getContrasenyaIntroducida());
			
			// pregunta al cliente el metodo de encriptacion que desea utilizar para encriptar su contraseña
			System.err.println("SERVIDOR >>> Seleccion del metodo de encriptacion: ");
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			bfr = new BufferedReader(isr);
			OutputStream os = socket.getOutputStream();
			
			// recibe el metodo de encriptacion seleccionado por el cliente
			pw = new PrintWriter(os);
			int tipoEncriptacion = Integer.parseInt(bfr.readLine());
			System.err.println("SERVIDOR >>> Recibe la opcion para encriptar la contrasenya con el metodo elegido");
			System.err.println("SERVIDOR >>> Encriptando...");
			String contrasenyaIntroducida = pMod.getContrasenyaIntroducida();
			String contrasenyaEncriptada = "";
			
			// ejecuta la encriptacion de la contraseña
			if(tipoEncriptacion == 2) {
				contrasenyaEncriptada = encriptacionMD5(contrasenyaIntroducida);
			} // end-if
			if(tipoEncriptacion == 1) {
				contrasenyaEncriptada = encriptacionASCII(contrasenyaIntroducida);
			} // end-if
			
			System.err.println("SERVIDOR >>> Devuelve contrasenya encriptada: "+contrasenyaEncriptada);
			pw.write(contrasenyaEncriptada.toString()+"\n");
			contrasenya = new Contrasenya(contrasenyaIntroducida, contrasenyaEncriptada);
			System.err.println("SERVIDOR >>> Envio a cliente: "+contrasenyaEncriptada);
			outObjeto.writeObject(contrasenya); 
			
			pw.flush();
			outObjeto.close();
			inObjeto.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("SERVIDOR >>> ERROR :(");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end-try-catch
	} // end-run
} // end-class
