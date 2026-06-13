package data;

import model.CentroTuristico;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorDatos {

    public ArrayList<CentroTuristico> cargarTours(String rutaArchivo) {
        ArrayList<CentroTuristico> lista = new ArrayList<>();
        try {
            File archivo = new File(rutaArchivo);
            Scanner lector = new Scanner(archivo);

            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                // SEPARACION DE LOS DATOS
                String[] partes = linea.split(";");

                if (partes.length == 3) {
                    String actividad = partes[0].trim();
                    String tipo = partes[1].trim();
                    int precio = Integer.parseInt(partes[2]);

                    lista.add(new CentroTuristico(actividad, tipo, precio));
                }
            }
            lector.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return lista;
    }
}
