package model;

/**
 * Excepción personalizada para alertar cuando un RUT no cumple
 * con el formato o el dígito verificador correcto.
 */

public class RutInvalidoException extends Exception {
    public RutInvalidoException(String mensaje) {
        super(mensaje);
    }
}
