package ui;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import data.GestorDatos;
import model.CentroTuristico;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        GestorDatos gestor = new GestorDatos();
        //CARGA LA LISTA DEL ARCHIVO TXT
        ArrayList<CentroTuristico> misTours = gestor.cargarTours("resources/Tours.txt");

        System.out.println("--- CATÁLOGO COMPLETO ---");
        for (CentroTuristico t : misTours) {
            System.out.println(t.toString());
        }

        System.out.println("\n--- FILTRADO: TOURS ---");
        for (CentroTuristico t : misTours) {

            // FILTRO DE ACTIVIDAD
            if ("Relajacion".equalsIgnoreCase(t.getTipo())&& t.getPrecio() > 1000) {
                System.out.println("Encontrado: " + t.getActividad() + ", Tipo: " + t.getTipo() + ", Precio: " + t.getPrecio());
            }
        }

    }
}