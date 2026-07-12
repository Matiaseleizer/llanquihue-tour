package model;

public abstract class ServicioTuristico implements Registrable {
    protected String nombre;
    protected int duracionHoras;

    //CONSTRUCTOR VACIO
    public ServicioTuristico() {}

    //CONSTRUCTOR
    public ServicioTuristico(String nombre, int duracionHoras) {
        this.nombre = nombre;
    }

    //GETTER & SETTER

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracionHoras;
    }

    public void setDuracion(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    //TO STRING

    @Override
    public String toString() {
        return "ServicioTuristico{" +
                "nombre='" + nombre + '\'' +
                ", duracion=" + duracionHoras +
                '}';
    }
}
