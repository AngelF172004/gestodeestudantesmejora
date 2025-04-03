import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estudiante[] estudiantes = new Estudiante[100];
        int numEstudiantes = 0;
        int opcion;

        do {
            System.out.println("\n\n\n--- Sistema de Registro de Estudiantes ---");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Buscar estudiante por matrícula");
            System.out.println("4. Eliminar estudiante");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    numEstudiantes = Metodos.registrarEstudiante(scanner, estudiantes, numEstudiantes);
                    break;
                case 2:
                    Metodos.mostrarEstudiantes(estudiantes, numEstudiantes);
                    break;
                case 3:
                    Metodos.buscarEstudiante(scanner, estudiantes, numEstudiantes);
                    break;
                case 4:
                    numEstudiantes = Metodos.eliminarEstudiante(scanner, estudiantes, numEstudiantes);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}

