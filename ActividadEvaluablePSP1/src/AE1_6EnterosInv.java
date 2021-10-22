/**
 * @author Eduardo Rua Chamorro | 2º DAM - Florida Universitaria
 * @version 1.0 - 30/09/2021
 * Descripcion: Escribe un metodo que pida 5 numeros enteros (sin validacion de momento), los muestre por consola en orden inverso y devuelva la suma de todos los numeros proporcionados
 */
// librerias importadas
    import java.util.Scanner;
public class AE1_6EnterosInv {
    public static void setNumerosEnteros() {
        // declaraciones
        Scanner sc = new Scanner(System.in);
        int sumaNumeros = 0;
        int [] arrNumeros = new int[5];
        for(int i = 0; i<5; i++) {
            System.out.print("Introduce un numero entero ("+(5-i)+" restantes): ");
            arrNumeros[i] += sc.nextInt();
        } // end-for
        System.out.println("Array invertido: ");
        for (int i = 4; i>=0; i--) {
            System.out.println(arrNumeros[i]+" ");
            sumaNumeros += arrNumeros[i];
        }
        System.out.println("Suma total de los valores del array: "+sumaNumeros);
        sc.close();
    } // end-setNumerosEnteros

    public static void main(String[] args) {
        setNumerosEnteros();
    } // end-main
} // end-class
