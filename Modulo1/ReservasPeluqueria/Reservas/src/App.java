import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            // Mostrar el menú
            Menu.mostrarMenu();
            // Leer la opción del usuario
            opcion = Menu.leerOpcion(sc);
            // Procesar la opción usando switch
            switch (opcion) {
                case 1:
                    System.out.println("\n--- AGENDAR RESERVA ---");
                    Operaciones.agendar(sc);
                    break;
                case 2:
                    System.out.println("\n--- LISTAR RESERVAS ---");
                    Operaciones.listar();
                    break;
                case 3:
                    System.out.println("\n--- CANCELAR RESERVA ---");
                    Operaciones.cancelar(sc);
                    break;
                case 4:
                    System.out.println("\n--- REPORTE DEL DÍA ---");
                    Operaciones.reporte();
                    break;
                case 5:
                    System.out.println("Gracias por usar el gestor. Hasta pronto.");
                    break;
                default:
                    System.out.println("Opcion no valida. Elige entre 1 y 5.");
            }
        }
        sc.close(); 
    }
}
