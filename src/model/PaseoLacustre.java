package model;

public class PaseoLacustre extends ServicioTuristico{
    private String tipoEmbarcacion;

    //CONSTRUCTORES
    public PaseoLacustre(String tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }
    public PaseoLacustre(String tipoEmbarcacion, String nombre, int duracionHoras) {
        super(nombre, duracionHoras);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    //GETTER & SETTER

    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    //TO STRING

    @Override
    public String toString() {
        return "PaseoLacustre{" +
                "tipoEmbarcacion='" + tipoEmbarcacion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", duracionHoras=" + duracionHoras +
                '}';
    }

    @Override
    public void mostrarResumen() {
        System.out.println("[RESUMEN LACUSTRE] Tour: " + getNombre() + " | Embarcación: " + tipoEmbarcacion);
    }
}
