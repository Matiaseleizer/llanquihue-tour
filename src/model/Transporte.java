package model;

public class Transporte {
    //ATRIBUTOS
    private String nombre;
    private String patente;
    private String vehiculo;
    private String tipo;

    public Transporte() {}

    //CONSTRUCTOR
    public Transporte(String nombre, String patente, String vehiculo, String tipo) {
        this.nombre = nombre;
        this.patente = patente;
        this.vehiculo = vehiculo;
        this.tipo = tipo;
    }
    //GETTER & SETTER


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Transporte{" +
                "nombre='" + nombre + '\'' +
                ", patente='" + patente + '\'' +
                ", vehiculo='" + vehiculo + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
