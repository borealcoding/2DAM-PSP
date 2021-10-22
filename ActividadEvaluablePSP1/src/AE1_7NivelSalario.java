/**
 * @author Eduardo Rua Chamorro | 2º DAM - Florida Universitaria
 * @version 1.0 - 30/09/2021
 * Descripcion: Escribe un metodo que pida por teclado el nombre y los anos de experiencia como desarrollador de software y muestre el nivel y el salario en base al siguiente criterio:
    a. Si lleva menos de 1 ano --> Desarrollador Junior L1 - “15000-18000€"
    b. Si lleva entre 1 y 2 anos --> Desarrollador Junior L2 - “18000-22000€"
    c. Si lleva entre 3 y 5 aÃ±os --> Desarrollador Senior L1 - “ 22000-28000€"
    d. Si lleva entre 5 y 8 aÃ±os --> Desarrollador Senior L2 - “ 28000-36000€"
    e. Si lleva mas de 8 anos --> Analista / Arquitecto. Salario a convenir en base a rol
 */
// librerias importadas
    import java.util.Scanner;
public class AE1_7NivelSalario {
    public static void getNivelSalario() {
        // declaraciones
        Scanner sc = new Scanner(System.in);
        String nombre; int anosExp;

        System.out.print("Como te llamas?: ");
        nombre = sc.nextLine();
        System.out.print("Cuantos aÃ±os de experiencia tienes como desarrollador?: ");
        anosExp = sc.nextInt();
        if(anosExp < 1) {
            System.out.println(nombre+" - Desarrollador Junior L1 - 15000-18000€");
        } else if(anosExp > 0 && anosExp < 3) {
            System.out.println(nombre+" - Desarrollador Junior L2 - 18000-22000€");
        } else if(anosExp > 2 && anosExp < 6) {
            System.out.println(nombre+" - Desarrollador Senior L1 - 22000-28000€");
        } else if(anosExp > 4 && anosExp < 9) {
            System.out.println(nombre+" - Desarrollador Senior L2 - 28000-36000€");
        } else if(anosExp > 8) {
            System.out.println(nombre+" - Analista / Arquitecto. Salario a convenir en base a rol");
        } else {
            System.out.println("ERROR! No se ha indicado ningun numero");
        } // end-if
        sc.close();
    } // end-getNivelSalario

    public static void main(String[] args) {
        getNivelSalario();
    }
} // end-class
