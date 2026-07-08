import java.util.Scanner;

public class Operaciones {
    // Constante para cupo máximo.
    private static final int CUPO_MAXINO = 10;
    // Arreglos de clientes, horas y servicios.
    private static String[] clientes = new String[CUPO_MAXINO];
    private static int[] horas = new int[CUPO_MAXINO];
    private static int[] servicios = new int[CUPO_MAXINO];

    private static int contador = 0;

    public static void agendar(Scanner sc) {
        // Verificar si hay cupo disponible
        if (contador >= CUPO_MAXINO) {
            System.out.println("No hay cupo disponible. La agenda esta llena");
            return;
        }

        // Solicitar y validar nombre
        //sc.nextLine();
        System.out.print("Nombre del cliente: ");
        String nombre = sc.nextLine();

        if (!Validador.nombreValido(nombre)) {
            System.out.println("El nombre no puede estar en vacío");
            return;
        }

        // Solicitar y validar la hora.
        System.out.println("Hora (8 a 17): ");
        while (!sc.hasNextInt()) {
            System.out.print("Ingresa un número válido: ");
            sc.next();
        }
        int hora = sc.nextInt();

        if (!Validador.horaValida(hora)) {
            System.out.println("Hora inválida. Debes estar entre 8 y 17.");
            return;
        }

        // Verificar si la hora ya está ocupada
        if (Validador.horaOcupada(horas, contador, hora)) {
            System.out.println("La hora " + hora + ":00 ya esta ocupada.");
            return;
        }

        // Solicitar y validar el servicio
        System.out.println("Código de servicio: 1: Corte - $25,000, 2: Tinte - $60,000, 3: Manicure - $30,000");
        while (!sc.hasNextInt()) {
            System.out.print("Ingresa un número válido: ");
            sc.next();
        }
        int servicio = sc.nextInt();

        if (!Validador.servicioValido(servicio)) {
            System.out.println("Servicio inválido. Debe ser, 1, 2 o 3");
            return;
        }

        // Guardar la reserva (todo validado)
        clientes[contador] = nombre;
        horas[contador] = hora;
        servicios[contador] = servicio;
        contador++;

        System.out.println("Resrva agenda con éxito!");
        System.out.println("Cliente:  " + nombre);
        System.out.println("Hora:     " + hora);
        System.out.println("servicio: " + Validador.obtenerNombreServicio(servicio));
        System.out.println("Precio:   " + Validador.obtenerPrecioServicio(servicio));
    }

    // Listar todas las reservas agendadas.
    public static void listar() {
        if (contador == 0) {
            System.out.println("Aun no hay reservas..");
            return;
        }

        System.out.println("Lista de reservas");
        for (int i = 0; i < contador; i++) {
            int numReserva = i + 1;
            String nombre = clientes[i];
            int hora = horas[i];
            String servicio = Validador.obtenerNombreServicio(servicios[i]);
            int precio = Validador.obtenerPrecioServicio(servicios[i]);

            System.out.println(numReserva + ". " + nombre + " | " + hora + ":00 | " + servicio + " | $" + precio);
        }
        System.out.println("Total: " + contador + " reserva(s)");
    }

    /**
     * Cancela una reserva por su número (desplazando elementos para tapar el hueco).
     */
    public static void cancelar(Scanner sc) {
        if (contador == 0) {
            System.out.println("No hay reservas para cancelar.");
            return;
        }

        System.out.print("Número de reserva a cancelar: ");
        while (!sc.hasNextInt()) {
            System.out.print("Ingresa un número válido");
            sc.next();
        }
        int numReserva = sc.nextInt();

        if (numReserva < 1 || numReserva > contador) {
            System.out.println("Número de reserva inválido. Debe estar entre 1 y " + contador + ".");
            return;
        }

        int indice = numReserva - 1; 

        System.out.println("Cancelando reserva de " + clientes[indice] + " a las " + horas[indice] + ":00");

        // Desplazar elementos hacia la izquierda
        for (int i = indice; i < contador - 1; i++) {
            clientes[i] = clientes[i + 1];
            horas[i] = horas[i + 1];
            servicios[i] = servicios[i +1];
        }

        clientes[contador - 1] = null;
        horas[contador - 1] = 0;
        servicios[contador - 1] = 0;

        contador--;

        System.out.println("Reserva cancelada con éxito.");
    }

    /**
     * Muestra el reporte del día con total de citas y dinero facturado.
     */
    public static void reporte() {
        System.out.println("REPORTE DEL DÍA");

        int totalCitas = contador;
        int totalFacturado = 0;

        // Calcular el total facturado
        for (int i = 0; i < contador; i++) {
            totalFacturado += Validador.obtenerPrecioServicio(servicios[i]);
        }
        
        System.out.println(" Total de citas agendadas: " + totalCitas);
        System.out.println(" Dinero facturado:       $ " + totalFacturado);

        // Mostrar desglose por servicio
        if (contador > 0) {
            System.out.println("\nDesglose por servicio");
            int corte = 0, tinte = 0, manicure = 0;

            for (int i = 0; i < contador; i++) {
                switch (servicios[i]) {
                    case 1: 
                        corte++;
                        break;
                    case 2:
                        tinte++;
                        break;
                    case 3:
                        manicure++;
                        break;
                }
            }
            System.out.println("Corte de caballero:  " + corte + " cita(s).");
            System.out.println("Tinte:               " + tinte + " cita(s)");
            System.out.println("Manicure:            " + manicure + " cita(s)");
        }
    }
}
