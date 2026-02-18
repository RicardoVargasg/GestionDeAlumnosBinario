import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GenerarFichero {
    public static void main(String[] args) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("alumnos.dat"))) {

            oos.writeObject(new Alumno("Juan", 7.5));
            oos.writeObject(new Alumno("Ana", 8.2));
            oos.writeObject(new Alumno("Luis", 4.9));
            oos.writeObject(new Alumno("María", 9.1));
            oos.writeObject(new Alumno("Juan", 6.8));

            System.out.println("Fichero alumnos.dat generado correctamente.");

        } catch (IOException e) {
            System.out.println("Error escribiendo el fichero: " + e.getMessage());
        }
    }
}
