public class Estudiante {
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
