import java.util.Scanner;

/**
 * Clase utilitaria Entrada.
 *
 * Centraliza la lectura de números por consola. Antes, si el usuario
 * escribía letras donde se esperaba un número, el programa se caía con
 * InputMismatchException. Ahora se vuelve a preguntar hasta que el dato
 * sea válido.
 *
 * Se lee SIEMPRE con nextLine() para no dejar saltos de línea
 * pendientes en el Scanner (error clásico al mezclar nextInt y nextLine).
 */
public class Entrada {

    // Constructor privado: es una clase de métodos estáticos, no se instancia
    private Entrada() {
    }

    /** Pide un número entero y repite la pregunta mientras no sea válido. */
    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine().trim();
            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.println("  Entrada inválida: escribe un número entero.");
            }
        }
    }

    /** Pide un número decimal (acepta coma o punto: 3,5 o 3.5). */
    public static double leerDouble(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(texto);
            } catch (NumberFormatException e) {
                System.out.println("  Entrada inválida: escribe un número (ej: 3.5).");
            }
        }
    }
}
