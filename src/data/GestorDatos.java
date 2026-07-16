package data; //validacion del rut y lectura de archivos txt

import model.Guia;
import model.RutInvalidoException;
import model.Transporte;
import model.CentroTuristico;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorDatos {

    public ArrayList<Guia> cargarGuias(String rutaGuias) {
        ArrayList<Guia> listaGuias = new ArrayList<>();
        try (Scanner lector = new Scanner(new File(rutaGuias))) {
            while (lector.hasNextLine()) {
                String[] datos = lector.nextLine().split(";");
                if (datos.length == 4) {
                    try {
                        // Creación segura: Valida el RUT en tiempo de carga[cite: 1]
                        listaGuias.add(new Guia(
                                datos[0].trim(), // RUT
                                datos[1].trim(), // Nombre
                                datos[2].trim(), // Profesión
                                datos[3].trim()  // Tipo
                        ));
                    } catch (RutInvalidoException e) {
                        System.err.println("Ignorando guía inválido: " + e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error al leer archivo de guías: " + e.getMessage());
        }
        return listaGuias;
    }

    public ArrayList<Transporte> cargarTransportes(String rutaTransporte) {
        ArrayList<Transporte> lista = new ArrayList<>();
        try (Scanner lector = new Scanner(new File(rutaTransporte))) {
            while (lector.hasNextLine()) {
                String[] datos = lector.nextLine().split(";");
                if (datos.length == 4) {
                    lista.add(new Transporte(
                            datos[0].trim(), // Chofer
                            datos[1].trim(), // Patente
                            datos[2].trim(), // Vehículo
                            datos[3].trim()  // Tipo
                    ));
                }
            }
        } catch (Exception e) {
            System.err.println("Error al leer archivo de transportes: " + e.getMessage());
        }
        return lista;
    }

    public ArrayList<CentroTuristico> cargarToursCompletos(String rutaTours, ArrayList<Guia> guias, ArrayList<Transporte> transportes) {
        ArrayList<CentroTuristico> listaTours = new ArrayList<>();
        try (Scanner lector = new Scanner(new File(rutaTours))) {
            int index = 0;
            while (lector.hasNextLine()) {
                String[] datos = lector.nextLine().split(";");
                if (datos.length == 3) {
                    String actividad = datos[0].trim();
                    String tipo = datos[1].trim();
                    int precio = Integer.parseInt(datos[2].trim());

                    Guia g = (index < guias.size()) ? guias.get(index) : null;
                    Transporte t = (index < transportes.size()) ? transportes.get(index) : null;

                    listaTours.add(new CentroTuristico(actividad, tipo, precio, g, t));
                    index++;
                }
            }
        } catch (Exception e) {
            System.err.println("Error al leer archivo de tours: " + e.getMessage());
        }
        return listaTours;
    }
}
