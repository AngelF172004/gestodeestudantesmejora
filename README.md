Métodos
Paradigmas de programación

Jorge Eduardo Vázquez Villagrán                     
Moran Hernández Ángel Fernando                                                 
Daniel Enrique Cortes Santos

ESCUELA SUPERIOR DE COMPUTO
¿De qué trata la práctica?
Consiste en cambiar el código de las 3 practicas anteriores para adaptarlas al uso de los métodos de Java (Tipo Static).
Los métodos son un conjunto de instrucciones que se pueden ejecutar mediante su nombre. Los métodos pueden aceptar datos o parámetros, mismos que usan para devolver un valor.
Ya que realizan tareas específicas con nombres propios, cambian la estructura de los códigos, se explicarán los cambios realizados más adelante.
Un método tipo Static es aquel que pertenece a una clase y no a un objeto, por lo cual solo existe una instancia del método independientemente de cuántos objetos de la clase se creen.

¿Cómo se implementó?
Primera práctica:
Se creo una clase que muestra un menú interactivo. Agrega, muestra, busca, elimina y guarda contactos. Carga desde un archivo y los guarda antes de salir.
Se creo una clase contacto con nombre, teléfono y correo, que se sobrescribe.
La clase de GestorContactos tiene una lista de contactos, una función AgregarContacto. MostrarContacto. BuscarContacto (Por nombre). EliminarContacto (Por nombre). GuardarContacto. Y CargarContacto.
Segunda práctica:
Se movieron las funciones de gestión hacia una clase llamada Métodos.
RegistrarEstudiante: Maneja la entrada de datos y creación de estudiantes.
MostrarEstudiantes: Muestra la lista de estudiantes registrados.
BuscarEstudiante: Permite buscar un estudiante por matrícula.
EliminarEstudiante: Elimina estudiantes del arreglo y actualiza la información.
Main ahora delega la lógica a los métodos.
Scanner ahora funciona como parámetro.
Tercera práctica:
Se movieron los métodos aleatorio y pistas a una clase llamada Métodos.
Ya que los métodos están en otra clase, se llaman con Métodos.aleatorio() y Métodos.pistas().
Ahora JuegoAdivinanza solo se encarga de la lógica, mientras que Métodos tiene las funciones auxiliares.

Instrucciones para ejecutar el programa:
Para ejecutar el programa en Visual Studio Code es importante tener la extensión de Java (Java Extension Pack).
Una vez hecho, tienes que abrir el archivo que tiene el código fuente.
Y con la instrucción para ejecutar (Ctrl + Shift + B) se abrirá una terminar donde funciona el programa.

Problemas encontrados:
Ningún problema encontrado.

Solución a los problemas:
Ninguna solución necesitada.

Enlace al GitHub:
https://github.com/AngelF172004/Practicaunomejorada

https://github.com/AngelF172004/gestodeestudantesmejora

https://github.com/AngelF172004/juegoAdivinanzamejorado


Enlace al Microsoft Planner:





Archivo fuente:
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<Integer> edades = new ArrayList<>();
        ArrayList<Double> notas = new ArrayList<>();
        
        int opcion;
        do {
            System.out.println("\n--- Sistema de Registro de Estudiantes ---");
            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Mostrar Estudiantes");
            System.out.println("3. Buscar Estudiante");
            System.out.println("4. Eliminar Estudiante");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    nombres.add(scanner.nextLine());
                    System.out.print("Edad: ");
                    edades.add(scanner.nextInt());
                    System.out.print("Nota: ");
                    notas.add(scanner.nextDouble());
                    scanner.nextLine();
                    System.out.println("Estudiante agregado.");
                    break;
                case 2:
                    if (nombres.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        for (int i = 0; i < nombres.size(); i++) {
                            System.out.println(nombres.get(i) + " - " + edades.get(i) + " años - Nota: " + notas.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre a buscar: ");
                    String nombreBuscado = scanner.nextLine();
                    int index = nombres.indexOf(nombreBuscado);
                    if (index != -1) {
                        System.out.println(nombres.get(index) + " - " + edades.get(index) + " años - Nota: " + notas.get(index));
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    int idx = nombres.indexOf(nombreEliminar);
                    if (idx != -1) {
                        nombres.remove(idx);
                        edades.remove(idx);
                        notas.remove(idx);
                        System.out.println("Estudiante eliminado.");
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}

Archivo mejorado: 
import java.util.Scanner;

public class SistemaRegistroEstudiantes {
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

class Estudiante {
    String nombre;
    int edad;
    String matricula;
    String carrera;

    public Estudiante(String nombre, int edad, String matricula, String carrera) {
        this.nombre = nombre;
        this.edad = edad;
        this.matricula = matricula;
        this.carrera = carrera;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Carrera: " + carrera);
        System.out.println("-----------------------------");
    }
}

class Metodos {
    // Método para registrar un estudiante y actualizar el contador
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

    // Método para eliminar un estudiante por su matrícula y actualizar el contador
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
Capturas del codigo: 
![image](https://github.com/user-attachments/assets/38398c58-fa4c-4fa3-8e2a-691f616008a5)
![image](https://github.com/user-attachments/assets/879c0a23-a82d-4446-bde4-d93a84ccfd5b)


Conclision: Apesar de que no se nota una diferencia en la ejecuacion dentro del cidigo segmentado pudimos apreciar de que era mas intuitivo si es que alguen llegara a modificar el codigo para mejorarlo ya podria saber donde se encunetra cada funcion del codigo, al igual que para esta paersona seria mas facil agregar o quitar cosas depenediendo del lo que desee hacer 

