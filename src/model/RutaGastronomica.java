package model;

public class RutaGastronomica extends ServicioTuristico{
    private int numeroDeParadas;

    //CONSTRUCTORES

    public RutaGastronomica(int numeroDeParadas) {
        this.numeroDeParadas = numeroDeParadas;
    }

    public RutaGastronomica(int numeroDeParadas, String nombre, int duracionHoras) {
        super(nombre, duracionHoras);
        this.numeroDeParadas = numeroDeParadas;
    }

    //GETTER & SETTER


    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    public void setNumeroDeParadas(int numeroDeParadas) {
        this.numeroDeParadas = numeroDeParadas;
    }

    //TO STRING


    @Override
    public String toString() {
        return "RutaGastronomica{" +
                "numeroDeParadas='" + numeroDeParadas + '\'' +
                ", nombre='" + nombre + '\'' +
                ", duracionHoras=" + duracionHoras +
                '}';
    }

    @Override
    public void mostrarResumen() {
        System.out.println("[RESUMEN GASTRONÓMICO] Tour: " + getNombre() + " | Cantidad de Paradas: " + numeroDeParadas);
    }
}
