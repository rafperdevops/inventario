package com.fedecafe.com.fedecafe.inventario;

/**
 *
 * @author koto
 */
public class Validador {
    public static boolean esCodigoValido(String codigo) {
        // Validar que el código sea un número
        try {
            Integer.parseInt(codigo);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean esNombreValido(String nombre) {
        // Validar que el nombre no esté vacío
        return !nombre.isEmpty();
    }

    public static boolean esCantidadValida(int cantidad) {
        // Validar que la cantidad sea un número positivo
        return cantidad >= 0;
    }

    public static boolean esPrecioValido(double precio) {
        // Validar que el precio sea un número positivo
        return precio >= 0;
    }
    
    public static boolean validarPrecioEnRango(double precio, double rangoMin, double rangoMax) {
        return (precio >= rangoMin) && (precio <= rangoMax);
    }
}
