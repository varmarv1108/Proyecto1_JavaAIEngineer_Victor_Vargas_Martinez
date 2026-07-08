import java.util.Scanner;

public class Menu {
    /**
     * Muestra el menú principal con las 5 opciones numeradas.
     */
    public static void mostrarMenu() {

        System.out.println("╔════════════════════════════════╗");
        System.out.println("║        GESTOR DE RESERVAS      ║");
        System.out.println("║ 1. Agendar una reserva         ║");
        System.out.println("║ 2. Listar todas las resesrvas  ║");
        System.out.println("║ 3. Cancelar una resrva         ║");
        System.out.println("║ 4. Ver el reporte de reservas  ║");
        System.out.println("║ 5. Salir                       ║");
        System.out.println("╚════════════════════════════════╝");
    }

    public static int leerOpcion(Scanner sc) {
        return Validador.leerEntero(sc, "Elige una opcion: ");
    }
}
