package es.florida.psp.ae4;
// importacion de librerias
import java.io.Serializable;

@SuppressWarnings("serial")
public class Contrasenya implements Serializable {
	// declaraciones
	String contrasenyaIntroducida, contrasenyaEncriptada;
	
	/* Metodo: constructor Contrasenya()
	 * Descripcion: En principio estara vacio por si no indicamos ninguna contrase�a
	 * */
	public Contrasenya() {
		super();
	} // end-constructor
	
	/* Metodo: constructor Contrasenya(String, String)
	 * Descripcion: Constructor que recogera la contrase�a en texto plano, y la encriptada para utilizarla despues.
	 * */
	public Contrasenya(String contrasenyaIntroducida, String contrasenyaEncriptada) {
		this.contrasenyaIntroducida = contrasenyaIntroducida;
		this.contrasenyaEncriptada = contrasenyaEncriptada;
	} // end-constructor (string, string)
	
	/* Metodo: setter setContrasenyaIntroducida
	 * Descripcion: Establece la contrase�a introducida por el cliente en texto plano
	 * */
	public void setContrasenyaIntroducida(String contrasenyaIntroducida) {
		this.contrasenyaIntroducida = contrasenyaIntroducida;
	} // end-setContrasenyaIntroducida
	
	/* Metodo: getter getContrasenyaIntroducida
	 * Descripcion: Obtiene la contrase�a introducida en texto plano
	 * */
	public String getContrasenyaIntroducida() {
		return contrasenyaIntroducida;
	} // end-getContrasenyaIntroducida

	/* Metodo: setter setContrasenyaEncriptada
	 * Descripcion: Establece la contrase�a encriptada con el metodo de encriptacion seleccionado
	 * */
	public void setContrasenyaEncriptada(String contrasenyaEncriptada) {
		this.contrasenyaEncriptada = contrasenyaEncriptada;
	} // end-setContrasenyaEncriptada

	/* Metodo: getter getContrasenyaEncriptada
	 * Descripcion: Obtiene la contrase�a generada despues de la encriptacion
	 * */
	public String getContrasenyaEncriptada() {
		return contrasenyaEncriptada;
	} // end-getContrasenyaEncriptada
} // end-class
