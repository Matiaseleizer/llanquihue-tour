package model;

public class Guia {
    //ATRIBUTOS
    private String nombre;
    private String profesion;
    private String tipo;

    public Guia() {}

    //CONSTRUCTOR
    public Guia(String nombre,  String profesion, String tipo) {
        this.nombre = nombre;
        this.profesion = profesion;
        this.tipo = tipo;
    }

    //GETTER & SETTER

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Guia{" +
                "nombre='" + nombre + '\'' +
                ", profesion='" + profesion + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
