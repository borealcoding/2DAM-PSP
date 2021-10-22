/**
 * @author Eduardo Rua Chamorro | 2º DAM - Florida Universitaria
 * @version 1.0 - 30/09/2021
 * Descripcion: Escribe un metodo que sume los numeros pares hasta el numero que acepta como parametro y devuelva el resultado de la suma.
 */
public class AE1_3SumaPares {
    public static void sumaPares(int p_limitePares) {
        // declaraciones
        int limitePares = p_limitePares;
        int sumaPares = 0;
        for (int i = 1  ; i <= limitePares; i++) {
            if(i % 2 == 0) {
                sumaPares += i;
            } // end-if
        } // end-for
        System.out.print("Suma de los pares hasta el par num "+limitePares+": "+sumaPares);
    } // end-sumaPares()

    public static void main(String[] args) {
        // introduce el numero limite hasta el que se sumaran los numeros pares
        sumaPares(10);
    } // end-main
} // end-class
