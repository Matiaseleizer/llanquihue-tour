package model;



public class Guia extends Persona {
    private String profesion;
    private String tipo;

    // CONSTRUCTOR
    public Guia(String rutRaw, String nombre, String profesion, String tipo) throws RutInvalidoException {
        super(nombre, rutRaw); // Pasa datos a Persona, validando el RUT
        this.profesion = profesion;
        this.tipo = tipo;
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
        return "[GUÍA] " + super.toString() + " | Profesión: " + profesion + " | Tipo: " + tipo;
    }
}
