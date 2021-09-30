import java.util.Scanner;

public class EjerciciosT1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// declaraciones
		Scanner sc = new Scanner(System.in);
		float numUser1, numUser2;
		int num1 = 2, num2 = 3, sumaAlm = 0, numMonth;
		String name;
		/*
		// 1. Realiza un programa que a partir de dos números (introducidos en el código) muestre su suma por pantalla
		System.out.println("El resultado de "+num1+" + "+num2+" es "+(num1+num2));
		sc.close();
		
		*/
		/*
		// 2. Programa Java que lea un nombre desde teclado y muestre por pantalla un mensaje tipo  “Hola xxxxx”.
		System.out.print("Escribe tu nombre: ");
		name = sc.nextLine();
		System.out.println("Hola "+name);
		sc.close();
		*/
		// 3. Realiza un programa que lea dos números desde teclado y muestre la suma por pantalla.
		/*
		System.out.print("Introduce el 1er numero: ");
		numUser1 = sc.nextFloat();
		System.out.print("Introduce el 2o numero: ");
		numUser2 = sc.nextFloat();
		
		System.out.println("El resultado de "+numUser1+" + "+numUser2+" es "+(numUser1+numUser2));
		sc.close();
		*/
		//4. Programa que lea dos números desde teclado y muestre el menor y el mayor en pantalla. Si son iguales deberá mostrar un mensaje indicándolo.
		/*
		System.out.print("Introduce el 1er numero: ");
		numUser1 = sc.nextFloat();
		System.out.print("Introduce el 2o numero: ");
		numUser2 = sc.nextFloat();
		
		if(numUser1>numUser2) {
			System.out.println("Numeros introducidos: "+numUser1+", "+numUser2+". Y el MAYOR de los dos es el "+numUser1);
		} else if(numUser1==numUser2) {
			System.out.println("Numeros introducidos: "+numUser1+", "+numUser2+". Y los dos son IGUALES");
		} else {
			System.out.println("Numeros introducidos: "+numUser1+", "+numUser2+". Y el MAYOR de los dos es el "+numUser2);
		}
		*/
		// 5. Realiza un programa que lea dos números desde teclado en un bucle repetitivo. El bucle deberá finalizar cuando los números leídos sean iguales
		/*
		do {
			System.out.print("Introduce el 1er numero: ");
			numUser1 = sc.nextFloat();
			System.out.print("Introduce el 2o numero: ");
			numUser2 = sc.nextFloat();
			
			if(numUser1!=numUser2) System.out.println("DEBEN SER IGUALES");
		} while(numUser1!=numUser2);
		*/
		// 6.  Realiza un programa que lea cinco números desde teclado y muestre la suma por pantalla. Sugerencia: utilizar una estructura de bucle
		/*for(int i = 0; i!=5; i++) {
			System.out.print("Introduce un numero a sumar (max. 5): ");
			sumaAlm += sc.nextInt();
		}
		System.out.println("Suma de todos los numeros introducidos: "+sumaAlm);*/
		// 7. Resolver el ejercicio anterior empleando otra estructura de bucle.
		/*int i = 0;
		while(i!=5) {
			System.out.print("Introduce un numero a sumar (max. 5): ");
			sumaAlm += sc.nextInt();
			i++;
		}
		System.out.println("Suma de todos los numeros introducidos: "+sumaAlm);*/
		/* 8. Desarrolla un programa que lea por teclado un número del 1 al 12 e indique por pantalla a
		qué mes del año en texto corresponde. Sugerencia: utilizar una estructura de programación
		if … else. */
		/*if (numMonth == 1) System.out.println("Mes elegido (" + numMonth + "): Enero");
		else if (numMonth == 2) System.out.println("Mes elegido (" + numMonth + "): Febrero");
		else if (numMonth == 3) System.out.println("Mes elegido (" + numMonth + "): Marzo");
		else if (numMonth == 4) System.out.println("Mes elegido (" + numMonth + "): Abril");
		else if (numMonth == 5) System.out.println("Mes elegido (" + numMonth + "): Mayo");
		else if (numMonth == 6) System.out.println("Mes elegido (" + numMonth + "): Junio");
		else if (numMonth == 7) System.out.println("Mes elegido (" + numMonth + "): Julio");
		else if (numMonth == 8) System.out.println("Mes elegido (" + numMonth + "): Agosto");
		else if (numMonth == 9) System.out.println("Mes elegido (" + numMonth + "): Septiembre");
		else if (numMonth == 10) System.out.println("Mes elegido (" + numMonth + "): Octubre");
		else if (numMonth == 11) System.out.println("Mes elegido (" + numMonth + "): Noviembre");
		else if (numMonth == 12) System.out.println("Mes elegido (" + numMonth + "): Diciembre");
		sc.close();*/
		// 9. Resolver el ejercicio anterior empleando otra estructura condicional.
		/*System.out.print("Introduce el num del mes del año que quieras: ");
		numMonth = sc.nextInt();
		switch(numMonth) {
			case 1:
				System.out.println("Mes elegido (" + numMonth + "): Enero");
				break;
			case 2:
				System.out.println("Mes elegido (" + numMonth + "): Febrero");
				break;
			case 3:
				System.out.println("Mes elegido (" + numMonth + "): Marzo");
				break;
			case 4:
				System.out.println("Mes elegido (" + numMonth + "): Abril");
				break;
			case 5:
				System.out.println("Mes elegido (" + numMonth + "): Mayo");
				break;
			case 6:
				System.out.println("Mes elegido (" + numMonth + "): Junio");
				break;
			case 7:
				System.out.println("Mes elegido (" + numMonth + "): Julio");
				break;
			case 8:
				System.out.println("Mes elegido (" + numMonth + "): Agosto");
				break;
			case 9:
				System.out.println("Mes elegido (" + numMonth + "): Septiembre");
				break;
			case 10:
				System.out.println("Mes elegido (" + numMonth + "): Octubre");
				break;
			case 11:
				System.out.println("Mes elegido (" + numMonth + "): Noviembre");
				break;
			case 12:
				System.out.println("Mes elegido (" + numMonth + "): Diciembre");
				break;
			default:
				System.out.println("Mes elegido INCORRECTO");
		}
		sc.close();*/
		/*10. Realiza una modificación del ejercicio anterior para que implemente un control de la 			entrada por teclado (admitir sólo números del 1 al 12).*/
		/*do {
			System.out.print("Introduce el num del mes del año que quieras: ");
			numMonth = sc.nextInt();
		} while(numMonth <= 0 || numMonth > 12);
		if (numMonth == 1) System.out.println("Mes elegido (" + numMonth + "): Enero");
		else if (numMonth == 2) System.out.println("Mes elegido (" + numMonth + "): Febrero");
		else if (numMonth == 3) System.out.println("Mes elegido (" + numMonth + "): Marzo");
		else if (numMonth == 4) System.out.println("Mes elegido (" + numMonth + "): Abril");
		else if (numMonth == 5) System.out.println("Mes elegido (" + numMonth + "): Mayo");
		else if (numMonth == 6) System.out.println("Mes elegido (" + numMonth + "): Junio");
		else if (numMonth == 7) System.out.println("Mes elegido (" + numMonth + "): Julio");
		else if (numMonth == 8) System.out.println("Mes elegido (" + numMonth + "): Agosto");
		else if (numMonth == 9) System.out.println("Mes elegido (" + numMonth + "): Septiembre");
		else if (numMonth == 10) System.out.println("Mes elegido (" + numMonth + "): Octubre");
		else if (numMonth == 11) System.out.println("Mes elegido (" + numMonth + "): Noviembre");
		else if (numMonth == 12) System.out.println("Mes elegido (" + numMonth + "): Diciembre");
		sc.close();*/
		// 11. Implementa un programa que dado un DNI (sin letra) por teclado devuelva el DNI con la letra correcta.
		char caracteres[] = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		int numDni, posLetra;
		String dni;
		System.out.print("Dime tu dni (sin letra): "); // recogemos el num del dni
		numDni = sc.nextInt();
		posLetra = numDni%23; // calculamos directamente el num introducido, para saber en que posicion del array se encuentra la letra
		dni = String.valueOf(numDni)+caracteres[posLetra]; // 1. convertimos el num del dni a String, y lo concatenamos directamente con la letra
		// también se puede hacer con Integer.toString(int);
		System.out.println("Tu DNI (con letra) es: "+dni+". Numero: "+numDni+" | Letra: "+caracteres[posLetra]);
		/* 12. Realiza un programa en Java que dadas 10 notas introducidas por teclado (valores de 0 a 10), las agrupe en suspensos, aprobados, notables, sobresalientes y matrícula, y muestre por pantalla cuantas notas hay en cada grupo. */

	} // end-main
} // end-class
