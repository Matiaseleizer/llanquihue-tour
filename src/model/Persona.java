package model;


// Composición: Una persona TIENE un Rut
public abstract class Persona {
    private String nombre;
    private Rut rut;

    public Persona(String nombre, String rutRaw) throws RutInvalidoException {
        this.nombre = nombre;
        this.rut = new Rut(rutRaw); //validación del paso 1
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rut getRut() {
        return rut;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | RUT: " + rut;
    }
}
