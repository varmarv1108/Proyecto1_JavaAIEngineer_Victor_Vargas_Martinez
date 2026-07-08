import java.util.Scanner;

public class Validador {
    public static int leerEntero(Scanner sc, String mensaje) {

        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;
            } else {
                System.out.println("Eso no es un numero entero. Intenta de nuevo.");
                sc.nextLine();
            }
        }
    }

    public static boolean horaValida(int hora) {
        return hora >= 8 && hora <= 17;
    }

    public static boolean nombreValido(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    public static boolean servicioValido(int servicio) {
        return servicio == 1 || servicio == 2 || servicio == 3;
    }

    public static boolean horaOcupada(int[] horas, int contador, int hora) {
        for (int i = 0; i < contador; i++) {
            if (horas[i] == hora) {
                return true;            // Hora ocupada
            }
        }
        return false;                   // Hora disponible
    }

    public static String obtenerNombreServicio(int codigoServicio) {
        switch (codigoServicio) {
            case 1:
                return "Corte de cabello";

            case 2:
                return "Tinte";

            case 3:
                return "Manicure";

            default:
                return "Servicio desconocido";
        }
    }

    public static int obtenerPrecioServicio(int codigoServicio) {
        switch (codigoServicio) {
            case 1:
                return 25000;
                
            case 2:
                return 60000;
            
            case 3:
                return 30000;
        
            default:
                return 0;
        }
    }
}
