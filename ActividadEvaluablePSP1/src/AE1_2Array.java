/**
 * @author Eduardo Rua Chamorro | 2º DAM - Florida Universitaria
 * @version 1.0 - 30/09/2021
 * Descripcion: Crea un array de elementos que contenga el nombre de 6 companeros de clase y...
    a. Haz que se escriban por la consola en lineas consecutivas.
    b. Haz lo mismo, pero empleando un objeto de tipo lista.
 */
// librerias importadas
    import java.util.ArrayList;
    import java.util.Scanner;
public class AE1_2Array {
    // declaraciones generales
    public static Scanner sc = new Scanner(System.in);

    public static void arrayConsecutivo() {
        // declaraciones
        String [] companeros = new String[6];
        for(int i = 0; i<companeros.length;i++) {
            System.out.print("Inserta 6 companeros (te quedan "+(6-i)+"): ");
            companeros[i] = sc.nextLine();
        } // end-for
        System.out.println("\n --- Lista completa! ---");
        for(int i = 0; i<companeros.length;i++) {
            System.out.println(" - "+companeros[i]);
        } // end-for
    } // end-arrayConsecutivo()
    
    public static void listaCompaneros() {
        // declaraciones
        ArrayList<String> listaCompaneros = new ArrayList<String>();
        for(int i = 0; i<6;i++) {
            System.out.print("Inserta 6 companeros (te quedan "+(6-i)+"): ");
            listaCompaneros.add(sc.nextLine());
        } // end-for
        System.out.println("\n --- Lista completa! ---");
        for(String lista: listaCompaneros) {
            System.out.println(" - "+lista);
        } // end-for
    } // end-listaCompaneros()

    public static void main(String[] args) {
        // DESCOMENTAR/COMENTAR METODOS PARA PROBARLOS INDIVIDUALMENTE
        // array de lineas consecutivas con los 6 companeros
        arrayConsecutivo();
        // el mismo procedimiento, pero con un arrayList
        listaCompaneros();
    } // end-main
} // end-class
