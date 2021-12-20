package es.florida.psp.a4_ej3_4_5_6_7;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Persona implements Serializable {
	String nombre, edad;

	public Persona() {
		super();
	} // end-constructor (without params)
	
	public Persona(String nombre, String edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	} // end-constructor (with params)

	public void setNombre(String nombre) {
		this.nombre = nombre;
	} // end-setNombre
	
	public String getNombre() {
		return nombre;
	} // end-getNombre

	public void setEdad(String edad) {
		this.edad = edad;
	} // end-setEdad
	
	public String getEdad() {
		return edad;
	} // end-getEdad

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	} // end-toString	
} // end-class
