public class CasilleroAmazon {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        GestionarCasillero gestor = new GestionarCasillero(3, 3); // matriz de 3x3
        int opcion;

        do {
            System.out.println("\n===== MENÚ AMAZON CASILLEROS =====");
            System.out.println("1. Registrar paquete");
            System.out.println("2. Consultar casilleros disponibles");
            System.out.println("3. Mostrar información de casilleros");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID del paquete: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese destinatario: ");
                    String destinatario = sc.nextLine();
                    System.out.print("Ingrese fecha de ingreso: ");
                    String fecha = sc.nextLine();
                    gestor.registrarPaquete(id, destinatario, fecha);
                    break;

                case 2:
                    gestor.consultarDisponibles();
                    break;

                case 3:
                    gestor.mostrarInformacion();
                    break;

                case 4:
                    System.out.println("Cerrando aplicación...");
                    break;

                default:
                    System.out.println("Opción inválida, intente nuevamente.");
            }
        } while (opcion != 4);

        sc.close();
    }
}
