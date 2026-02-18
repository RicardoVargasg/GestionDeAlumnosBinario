import java.util.List;

public class Main {
    public static void main(String[] args) {

        GestionAlumnos gestor = new GestionAlumnos();

        List<Alumno> alumnos = gestor.leerFichero("alumnos.dat");

        var mapa = gestor.agruparNotas(alumnos);

        System.out.println("Nota media: ");
        for (String nombre : mapa.keySet()) {
            double media = gestor.calcularMedia(mapa.get(nombre));
            System.out.println(nombre + ": " + media);
        }

        System.out.println("\nAlumnos ordenador por nota media:");
        for (String nombre : gestor.ordenarPorMedia(mapa)) {
            System.out.println(nombre);
        }

        System.out.println("\nAlumnos aprobados:");
        for (String nombre : gestor.alumnosAprobados(mapa)) {
            System.out.println(nombre);
        }

        System.out.println("\nMejor Alumno:");
        System.out.println(gestor.mejorAlumno(mapa));
    }
}
