import java.io.*;
import java.util.*;

public class GestionAlumnos {

    public List<Alumno> leerFichero(String ruta) {
        List<Alumno> lista = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {

            while (true) {
                try {
                    Alumno a = (Alumno) ois.readObject();
                    lista.add(a);
                } catch (EOFException e) {
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return lista;
    }

    public Map<String, List<Double>> agruparNotas(List<Alumno> lista) {
        Map<String, List<Double>> mapa = new HashMap<>();

        for (Alumno a : lista) {
            mapa.putIfAbsent(a.getNombre(), new ArrayList<>());
            mapa.get(a.getNombre()).add(a.getNota());
        }

        return mapa;
    }

    public double calcularMedia(List<Double> notas) {
        double suma = 0;
        for (double n : notas) suma += n;
        return suma / notas.size();
    }

    public List<String> alumnosAprobados(Map<String, List<Double>> mapa) {
        List<String> aprobados = new ArrayList<>();

        for (String nombre : mapa.keySet()) {
            if (calcularMedia(mapa.get(nombre)) >= 5) {
                aprobados.add(nombre);
            }
        }

        return aprobados;
    }

    public List<String> ordenarPorMedia(Map<String, List<Double>> mapa) {
        List<String> lista = new ArrayList<>(mapa.keySet());

        lista.sort((a, b) -> {
            double mediaA = calcularMedia(mapa.get(a));
            double mediaB = calcularMedia(mapa.get(b));
            return Double.compare(mediaB, mediaA);
        });

        return lista;
    }

    public String mejorAlumno(Map<String, List<Double>> mapa) {
        return ordenarPorMedia(mapa).get(0);
    }
}
