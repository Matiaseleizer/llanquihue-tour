package data;

import model.CentroTuristico;
import model.Guia;
import model.Transporte;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorDatos {

    public ArrayList<CentroTuristico> cargarTours(String rutaTours, String rutaGuias, String rutaTransporte) {
        ArrayList<CentroTuristico> listaTours = new ArrayList<>();
        try {
            Scanner lectorTours = new Scanner(new File(rutaTours));
            Scanner lectorGuias = new Scanner(new File(rutaGuias));
            Scanner lectorTransporte = new Scanner(new File(rutaTransporte));

            while (lectorTours.hasNextLine() && lectorGuias.hasNextLine() && lectorTransporte.hasNextLine()) {
                // SEPARACION DE LOS DATOS LEYENDO LOS TRES ARCHIVOS
                String[] datosTour = lectorTours.nextLine().split(";");
                String[] datosGuias = lectorGuias.nextLine().split(";");
                String[] datosTransporte = lectorTransporte.nextLine().split(";");

                if (datosTour.length == 3 && datosGuias.length == 3 && datosTransporte.length == 4) {

                    // OBJETO GUIA
                    Guia guia = new Guia(
                            datosGuias[0].trim(),
                            datosGuias[1].trim(),
                            datosGuias[2].trim()
                    );

                    // OBJETO TRANSPORTE
                    Transporte transporte = new Transporte(
                            datosTransporte[0].trim(),
                            datosTransporte[1].trim(),
                            datosTransporte[2].trim(),
                            datosTransporte[3].trim()
                    );

                    // DATOS DEL CENTRO TURISTICO
                    String actividad = datosTour[0].trim();
                    String tipo = datosTour[1].trim();
                    int precio = Integer.parseInt(datosTour[2].trim());

                    // CREAR TOUR COMPLETO Y AGREGAR A LA LISTA
                    CentroTuristico tourCompleto = new CentroTuristico(actividad, tipo, precio, guia, transporte);
                    listaTours.add(tourCompleto);
                }
            }
            lectorTours.close();
            lectorGuias.close();
            lectorTransporte.close();

        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        }
        return listaTours;
    }
}
