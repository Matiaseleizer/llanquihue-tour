package model;

public class ExcursionCultural extends ServicioTuristico{
    private String lugarHistorico;

    //CONSTRUCTORES
    public ExcursionCultural(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
    }

    public ExcursionCultural(String lugarHistorico, String nombre, int duracionHoras) {
        super(nombre, duracionHoras);
        this.lugarHistorico = lugarHistorico;
    }

    //GETTER & SETTER

    public String getLugarHistorico() {
        return lugarHistorico;
    }

    public void setLugarHistorico(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
    }

    //TO STRNG

    @Override
    public String toString() {
        return "ExcursionCultural{" +
                "lugarHistorico='" + lugarHistorico + '\'' +
                ", nombre='" + nombre + '\'' +
                ", duracionHoras=" + duracionHoras +
                '}';
    }

    @Override
    public void mostrarResumen(){
        System.out.println("[RESUMEN CULTURAL] Tour: " + getNombre() + " | Lugar Histórico: " + lugarHistorico);
    }
}
