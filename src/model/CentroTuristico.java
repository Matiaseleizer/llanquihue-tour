package model;

public class CentroTuristico {

    //ATRIBUTOS
    private String actividad;
    private String tipo;
    private int precio;

    //CONSTRUCTOR VACIO
    public CentroTuristico(String[] actividad, String[] tipo, int precio) {}

    //CONSTRUCTOR
    public CentroTuristico(String actividad, String tipo, int precio) {
        this.actividad = actividad;
        this.tipo = tipo;
        this.precio = precio;
    }

    //GETTER & SETTER
    public String getActividad() {

        return actividad;
    }

    public void setActividad(String actividad) {

        this.actividad = actividad;
    }

    public String getTipo() {

        return tipo;
    }

    public void setTipo(String tipo) {

        this.tipo = tipo;
    }

    public int getPrecio() {

        return precio;
    }

    public void setPrecio(int precio) {

        this.precio = precio;
    }

    //TO STRING

    @Override
    public String toString() {
        return "CentroTuristico{" +
                "actividad='" + actividad + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                '}';
    }
}
