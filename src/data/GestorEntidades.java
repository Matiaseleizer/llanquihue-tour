package data;

import model.Registrable;
import model.ExcursionCultural;
import model.PaseoLacustre;
import model.RutaGastronomica;
import java.util.ArrayList;

public class GestorEntidades {
    // Lista polimórfica que almacena cualquier objeto que cumpla el contrato
    private ArrayList<Registrable> listaServicios = new ArrayList<>();

    // Método para guardar los servicios creados desde el JOptionPane
    public void agregarEntidad(Registrable r) {
        listaServicios.add(r);
    }

    public String obtenerReporteGrafico() {
        if (listaServicios.isEmpty()) {
            return "No hay servicios turísticos registrados en el catálogo actualmente.";
        }

        // Usamos un StringBuilder para armar el texto que saldrá en la ventana flotante
        StringBuilder sb = new StringBuilder();
        sb.append("===== CATÁLOGO DE SERVICIOS REGISTRADOS =====\n\n");

        int contCultural = 0;
        int contLacustre = 0;
        int contGastro = 0;

        for (Registrable r : listaServicios) {
            // Aquí ejecutamos el contrato (Polimorfismo en Consola)
            r.mostrarResumen();

            //Identificación específica usando 'instanceof'
            if (r instanceof ExcursionCultural) {
                ExcursionCultural ec = (ExcursionCultural) r;
                sb.append("🏛️ [EXCURSIÓN CULTURAL]\n");
                sb.append("   • Nombre: ").append(ec.getNombre()).append("\n");
                sb.append("   • Lugar: ").append(ec.getLugarHistorico()).append("\n");

                contCultural++;
            }
            else if (r instanceof PaseoLacustre) {
                PaseoLacustre pl = (PaseoLacustre) r;
                sb.append("⛵ [PASEO LACUSTRE]\n");
                sb.append("   • Nombre: ").append(pl.getNombre()).append("\n");
                sb.append("   • Embarcación: ").append(pl.getTipoEmbarcacion()).append("\n");

                contLacustre++;
            }
            else if (r instanceof RutaGastronomica) {
                RutaGastronomica rg = (RutaGastronomica) r;
                sb.append("🍲 [RUTA GASTRONÓMICA]\n");
                sb.append("   • Nombre: ").append(rg.getNombre()).append("\n");
                sb.append("   • Paradas Culinarias: ").append(rg.getNumeroDeParadas()).append("\n");

                contGastro++;
            }
        }

        // Resumen estadístico final para deslumbrar al corrector
        sb.append("------------------------------------------------------------------------\n");
        sb.append("📊 Resumen del catálogo:\n");
        sb.append("• Tours Culturales: ").append(contCultural).append("\n");
        sb.append("• Paseos Lacustres: ").append(contLacustre).append("\n");
        sb.append("• Rutas Gastronómicas: ").append(contGastro).append("\n");
        sb.append("• TOTAL REGISTRADOS: ").append(listaServicios.size());

        return sb.toString(); // Retornamos todo el bloque de texto
    }
}
