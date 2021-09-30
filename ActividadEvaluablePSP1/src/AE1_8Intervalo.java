/**
 * @author Eduardo Rua Chamorro | 2∫ DAM - Florida Universitaria
 * @version 1.0 - 30/09/2021
 * Descripcion: Escribe un metodo que pida por teclado 2 numeros como extremos de un intervalo. Luego imprime por pantalla todos los numeros entre ese intervalo, indicando junto al numero si es un numero primo o no. Al terminar de mostrar los numeros por pantalla, debe mostrar un mensaje indicando el tiempo consumido en la ejecucion del metodo.
 */
// librer√≠as importadas
    import java.util.Scanner;
public class AE1_8Intervalo {
    public static boolean esPrimo(int p_numPrimo) {
        if(p_numPrimo == 0 || p_numPrimo == 1 || p_numPrimo == 4) {
            return false;
        } // end-if
        for (int div = 2; div < p_numPrimo / 2; div++) {
            if(p_numPrimo % div == 0) {
                return false;
            } // end-if
        } // end-for
        return true;
    } // end-esPrimo()

    public static void getProcessTime() {
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();
        double totalTime = (double) ((endTime-startTime));
        // comprobamos el tiempo consumido en la ejecucion de este metodo
        System.out.print("Tiempo consumido (en milisegundos): "+totalTime);
    }

    public static void getIntervalo() {
        // declaraciones
        Scanner sc = new Scanner(System.in);
        int primerNum = 0; int ultimoNum = 0;
        // introducimos ambos extremos
        System.out.print("Introduce el primer numero: ");
        primerNum = sc.nextInt();
        System.out.print("Introduce el ultimo numero: ");
        ultimoNum = sc.nextInt();
        // recorremos los numeros que hay entre dichos extremos, y llamamos a la funcion esPrimo para comprobar cual es primo o no.
        for(int i = primerNum+1; i<ultimoNum; i++) {
            if(esPrimo(i)) {
                System.out.println(i+" - es primo");
            } else {
                System.out.println(i+" - no es primo");
            } // end-if
        } // end-for
        sc.close();
    } // end-getIntervalo()

    public static void main(String[] args) {
        System.out.println("Vamos a comprobar si los numeros entre ambos extremos son primos o no!");
        getIntervalo();
        getProcessTime();
    }
}
