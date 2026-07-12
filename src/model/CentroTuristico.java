package model;

public class CentroTuristico extends ServicioTuristico {

    //ATRIBUTOS
    private String nombre;
    private String tipo;
    private int precio;
    private Guia guia;
    private Transporte transporte;

    //CONSTRUCTOR VACIO
    public CentroTuristico(String nombre, int tipo, Guia precio, Transporte guia) {}

    //CONSTRUCTOR
    public CentroTuristico(String nombre, String tipo, int precio, Guia guia, Transporte transporte) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.guia = guia;
        this.transporte = transporte;
    }

    //GETTER & SETTER
    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
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
    public Guia getGuia() {
        return guia;
    }
    public void setGuia(Guia guia) {
        this.guia = guia;
    }
    public Transporte getTransporte() {
        return transporte;
    }
    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    //TO STRING


    @Override
    public String toString() {
        return "CentroTuristico{" +
                "actividad='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                ", guia=" + guia +
                ", transporte=" + transporte +
                '}';
    }

    @Override
    public void mostrarResumen() {
        System.out.println("[CENTRO TURÍSTICO] " + getNombre() + " | Tipo: " + getTipo());
    }
  }

