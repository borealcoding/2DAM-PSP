/**
 * @author Eduardo Rua Chamorro | 2º DAM - Florida Universitaria
 * @version 1.0 - 30/09/2021
 * Descripcion: Escribe un metodo que acepte un array o una lista de elementos y devuelva el mayor de ellos.
 */
public class AE1_5ArrayMayor {
    public static void getArrayMayor() {
        // declaraciones
        int [] arrNumeros = {4,29,10,5,45,99,2,34,12};
        int valorMayor = 0;
        for(int i = 0; i< arrNumeros.length;i++) {
            if (arrNumeros[i]>valorMayor) {
                valorMayor = arrNumeros[i];
            } // end-if
        } // end-for
        System.out.print("El mayor de los valores del array es: "+valorMayor);
    } // end-getArrayMayor

    public static void main(String[] args) {
        getArrayMayor();
    } // end-main
} // end-class
