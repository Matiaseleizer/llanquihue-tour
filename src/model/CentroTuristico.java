package model;

public class CentroTuristico {

    //ATRIBUTOS
    private String actividad;
    private String tipo;
    private int precio;
    private Guia guia;
    private Transporte transporte;

    //CONSTRUCTOR VACIO
    public CentroTuristico(String actividad, String tipo, int precio,  Guia guia) {}

    //CONSTRUCTOR
    public CentroTuristico(String actividad, String tipo, int precio, Guia guia,  Transporte transporte) {
        this.actividad = actividad;
        this.tipo = tipo;
        this.precio = precio;
        this.guia = guia;
        this.transporte = transporte;
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
                "actividad='" + actividad + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                ", guia=" + guia +
                ", transporte=" + transporte +
                '}';
    }
  }

