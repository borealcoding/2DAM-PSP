/**
 * @author Eduardo Rua Chamorro | 2º DAM - Florida Universitaria
 * @version 1.0 - 30/09/2021
 * Descripcion: Escribe el codigo necesario para calcular el factorial del numero 15, en menos de 5 instrucciones.
 */
public class AE1_4Factorial {
    public static void main(String[] args) {
        long factorial = 1;
        for(int i = 15; i>=1; i--)
            factorial *= i;
        System.out.print("El factorial de 15 es: "+factorial);
    } // end-main
} // end-class
