package ui;

import data.GestorDatos;
import data.GestorEntidades;
import model.CentroTuristico;
import model.Guia;
import model.Transporte;
import model.ExcursionCultural;
import model.PaseoLacustre;
import model.RutaGastronomica;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GestorEntidades gestor = new GestorEntidades();
        GestorDatos cargador = new GestorDatos();

        // PASO 3: Carga automática de archivos al iniciar el programa
        ArrayList<Guia> guiasCargados = cargador.cargarGuias("resources/Guias.txt");
        ArrayList<Transporte> transportesCargados = cargador.cargarTransportes("resources/Transporte.txt");
        ArrayList<CentroTuristico> toursCargados = cargador.cargarToursCompletos("resources/Tours.txt", guiasCargados, transportesCargados);

        // Agregamos los tours cargados desde el archivo de texto a nuestro catálogo polimórfico
        for (CentroTuristico ct : toursCargados) {
            gestor.agregarEntidad(ct);
        }

        // Informar al usuario que la base de datos se cargó exitosamente
        JOptionPane.showMessageDialog(null,
                "Base de datos de Llanquihue Tour inicializada con éxito.\n" +
                        "Se cargaron: \n" +
                        "• " + guiasCargados.size() + " Guías turísticos.\n" +
                        "• " + transportesCargados.size() + " Transportes.\n" +
                        "• " + toursCargados.size() + " Centros turísticos base.",
                "Inicio del Sistema", JOptionPane.INFORMATION_MESSAGE);

        String[] opciones = {"Crear Excursión Cultural", "Crear Paseo Lacustre", "Crear Ruta Gastronómica", "Ver Catálogo Visual", "Salir"};
        int seleccion;

        do {
            seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción para operar el catálogo:",
                    "Llanquihue Tour - Sistema Administrativo",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    optionsAdapt(opciones),
                    opciones[0]
            );

            // AQUÍ ESTÁ EL SWITCH CASE QUE HACE FUNCIONAR LOS BOTONES
            switch (seleccion) {
                case 0: // Registrar Cultural
                    try {
                        String nomC = JOptionPane.showInputDialog("Nombre del Tour Cultural:");
                        if (nomC == null || nomC.trim().isEmpty()) break; // Cancela si está vacío o es nulo

                        String lugC = JOptionPane.showInputDialog("Lugar Histórico:");
                        if (lugC == null || lugC.trim().isEmpty()) break;

                        String hrC = JOptionPane.showInputDialog("Duración (en horas):");
                        if (hrC == null || hrC.trim().isEmpty()) break;

                        int duracion = Integer.parseInt(hrC.trim());
                        gestor.agregarEntidad(new ExcursionCultural(lugC, nomC, duracion));
                        JOptionPane.showMessageDialog(null, "¡Excursión Cultural añadida exitosamente!");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Error: La duración debe ser un número entero válido.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 1: // Registrar Lacustre
                    try {
                        String nomL = JOptionPane.showInputDialog("Nombre del Paseo Lacustre:");
                        if (nomL == null || nomL.trim().isEmpty()) break;

                        String embL = JOptionPane.showInputDialog("Tipo de Embarcación:");
                        if (embL == null || embL.trim().isEmpty()) break;

                        String hrL = JOptionPane.showInputDialog("Duración (en horas):");
                        if (hrL == null || hrL.trim().isEmpty()) break;

                        int duracion = Integer.parseInt(hrL.trim());
                        gestor.agregarEntidad(new PaseoLacustre(embL, nomL, duracion));
                        JOptionPane.showMessageDialog(null, "¡Paseo Lacustre añadido exitosamente!");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Error: La duración debe ser un número entero válido.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 2: // Registrar Gastronómica
                    try {
                        String nomG = JOptionPane.showInputDialog("Nombre de la Ruta Gastronómica:");
                        if (nomG == null || nomG.trim().isEmpty()) break;

                        String parG = JOptionPane.showInputDialog("Cantidad de Paradas Culinarias:");
                        if (parG == null || parG.trim().isEmpty()) break;

                        String hrG = JOptionPane.showInputDialog("Duración (en horas):");
                        if (hrG == null || hrG.trim().isEmpty()) break;

                        int paradas = Integer.parseInt(parG.trim());
                        int duracion = Integer.parseInt(hrG.trim());

                        gestor.agregarEntidad(new RutaGastronomica(paradas, nomG, duracion));
                        JOptionPane.showMessageDialog(null, "¡Ruta Gastronómica añadida exitosamente!");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Error: Los campos numéricos deben contener valores enteros válidos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 3: // Ver Reporte con instanceof
                    String reporte = gestor.obtenerReporteGrafico();
                    JOptionPane.showMessageDialog(null, reporte, "Catálogo de Servicios", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }

        } while (seleccion != 4 && seleccion != -1);

        JOptionPane.showMessageDialog(null, "Cerrando sistema de Llanquihue Tour.");
    }

    private static Object[] optionsAdapt(String[] arr){
        return arr;
    }
}