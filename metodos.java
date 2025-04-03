import java.util.Scanner;

public class Metodos {
    // Método para registrar un estudiante
    public static int registrarEstudiante(Scanner scanner, Estudiante[] estudiantes, int numEstudiantes) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Carrera: ");
        String carrera = scanner.nextLine();

        estudiantes[numEstudiantes] = new Estudiante(nombre, edad, matricula, carrera);
        numEstudiantes++;
        System.out.println("Estudiante registrado con éxito.");
        return numEstudiantes;
    }

    // Método para mostrar la lista de estudiantes
    public static void mostrarEstudiantes(Estudiante[] estudiantes, int numEstudiantes) {
        if (numEstudiantes == 0) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            System.out.println("\n--- Lista de Estudiantes ---");
            for (int i = 0; i < numEstudiantes; i++) {
                estudiantes[i].mostrarDatos();
            }
        }
    }

    // Método para buscar un estudiante por su matrícula
    public static void buscarEstudiante(Scanner scanner, Estudiante[] estudiantes, int numEstudiantes) {
        System.out.print("Ingrese la matrícula a buscar: ");
        String matriculaBuscar = scanner.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < numEstudiantes; i++) {
            if (estudiantes[i].matricula.equals(matriculaBuscar)) {
                estudiantes[i].mostrarDatos();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Estudiante no encontrado.");
        }
    }

    // Método para eliminar un estudiante por su matrícula
    public static int eliminarEstudiante(Scanner scanner, Estudiante[] estudiantes, int numEstudiantes) {
        System.out.print("Ingrese la matrícula del estudiante a eliminar: ");
        String matriculaEliminar = scanner.nextLine();
        boolean eliminado = false;

        for (int i = 0; i < numEstudiantes; i++) {
            if (estudiantes[i].matricula.equals(matriculaEliminar)) {
                for (int j = i; j < numEstudiantes - 1; j++) {
                    estudiantes[j] = estudiantes[j + 1];
                }
                numEstudiantes--;
                eliminado = true;
                System.out.println("Estudiante eliminado con éxito.");
                break;
            }
        }

        if (!eliminado) {
            System.out.println("Estudiante no encontrado.");
        }
        return numEstudiantes;
    }
}

