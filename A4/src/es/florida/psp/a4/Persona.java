package es.florida.psp.a4;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Persona implements Serializable {
	String nombre, colorPelo, colorOjos, altura, edad;

	public Persona() {
		super();
	} // end-constructor (without params)
	
	public Persona(String nombre, String colorPelo, String colorOjos, String altura, String edad) {
		super();
		this.nombre = nombre;
		this.colorPelo = colorPelo;
		this.colorOjos = colorOjos;
		this.altura = altura;
		this.edad = edad;
	} // end-constructor (with params)

	public void setNombre(String nombre) {
		this.nombre = nombre;
	} // end-setNombre
	
	public String getNombre() {
		return nombre;
	} // end-getNombre

	public void setColorPelo(String colorPelo) {
		this.colorPelo = colorPelo;
	} // end-setColorPelo

	public String getColorPelo() {
		return colorPelo;
	} // end-getColorPelo

	public void setColorOjos(String colorOjos) {
		this.colorOjos = colorOjos;
	} // end-setColorOjos
	
	public String getColorOjos() {
		return colorOjos;
	} // end-getColorOjos
	
	public void setAltura(String altura) {
		this.altura = altura;
	} // end-setAltura

	public String getAltura() {
		return altura;
	} // end-getAltura

	public void setEdad(String edad) {
		this.edad = edad;
	} // end-setEdad
	
	public String getEdad() {
		return edad;
	} // end-getEdad

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", colorPelo=" + colorPelo + ", colorOjos=" + colorOjos + ", altura="
				+ altura + ", edad=" + edad + "]";
	} // end-toString
	
} // end-class
