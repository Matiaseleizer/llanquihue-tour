package ui;

import data.GestorEntidades;
import model.ExcursionCultural;
import model.PaseoLacustre;
import model.RutaGastronomica;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        GestorEntidades gestor = new GestorEntidades();
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
                    opciones,
                    opciones[0]
            );

            switch (seleccion) {
                case 0: // Registrar Cultural
                    String nomC = JOptionPane.showInputDialog("Nombre del Tour Cultural:");
                    String lugC = JOptionPane.showInputDialog("Lugar Histórico:");
                    String hrC = JOptionPane.showInputDialog("Duración (en horas):");
                    if (nomC != null && lugC != null && hrC != null) {
                        gestor.agregarEntidad(new ExcursionCultural(lugC, nomC, Integer.parseInt(hrC)));
                        JOptionPane.showMessageDialog(null, "¡Excursión Cultural añadida!");
                    }
                    break;

                case 1: // Registrar Lacustre
                    String nomL = JOptionPane.showInputDialog("Nombre del Paseo Lacustre:");
                    String embL = JOptionPane.showInputDialog("Tipo de Embarcación:");
                    String hrL = JOptionPane.showInputDialog("Duración (en horas):");
                    if (nomL != null && embL != null && hrL != null) {
                        gestor.agregarEntidad(new PaseoLacustre(embL, nomL, Integer.parseInt(hrL)));
                        JOptionPane.showMessageDialog(null, "¡Paseo Lacustre añadido!");
                    }
                    break;

                case 2: // Registrar Gastronómica
                    String nomG = JOptionPane.showInputDialog("Nombre de la Ruta Gastronómica:");
                    String parG = JOptionPane.showInputDialog("Cantidad de Paradas Culinarias:");
                    String hrG = JOptionPane.showInputDialog("Duración (en horas):");
                    if (nomG != null && parG != null && hrG != null) {
                        gestor.agregarEntidad(new RutaGastronomica(Integer.parseInt(parG), nomG, Integer.parseInt(hrG)));
                        JOptionPane.showMessageDialog(null, "¡Ruta Gastronómica añadida!");
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

    }
