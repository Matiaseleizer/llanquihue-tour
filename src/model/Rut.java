package model;


//Clase utilitaria encargada de la validación, limpieza y formateo del RUT chileno.
public class Rut {
    private String valor;

//Constructor que valida y sanitiza el RUT ingresado.
    public Rut(String rutRaw) throws RutInvalidoException {
        if (rutRaw == null || rutRaw.trim().isEmpty()) {
            throw new RutInvalidoException("El RUT no puede estar vacío.");
        }
        String rutLimpio = rutRaw.replace(".", "").replace("-", "").trim().toUpperCase();
        if (!validarRut(rutLimpio)) {
            throw new RutInvalidoException("El RUT '" + rutRaw + "' no es válido o su dígito verificador es incorrecto.");
        }
        this.valor = formatear(rutLimpio);
    }

    //Aplica el algoritmo matemático del Módulo 11 para verificar el dígito verificador.
    private boolean validarRut(String rut) {
        try {
            int rutNumerico = Integer.parseInt(rut.substring(0, rut.length() - 1));
            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutNumerico != 0; rutNumerico /= 10) {
                s = (s + rutNumerico % 10 * (9 - m++ % 6)) % 11;
            }
            char dvCalculado = (char) (s != 0 ? s + 47 : 75);
            return dv == dvCalculado;
        } catch (Exception e) {
            return false;
        }
    }
//Da formato estándar al RUT agregando el guion antes del dígito verificador.
    private String formatear(String rut) {
        String cuerpo = rut.substring(0, rut.length() - 1);
        String dv = rut.substring(rut.length() - 1);
        return cuerpo + "-" + dv;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor;
    }
}