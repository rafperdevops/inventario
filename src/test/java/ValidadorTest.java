/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.fedecafe.com.fedecafe.inventario.Validador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author koto
 */
public class ValidadorTest {
    @Test
    public void testEsCodigoValido(){
        //Prueba un código válido
        assertTrue(Validador.esCodigoValido("123456"));
        //Prueba un código inválido
        assertFalse(Validador.esCodigoValido("sdfsdf"));
    }
    
    @Test
    public void testEsNombreValido(){
        assertTrue(Validador.esNombreValido("Producto A")); // Nombre válido
        assertFalse(Validador.esNombreValido(""));           // Nombre no válido (vacío)
    }
    
    @Test
    public void testEsCantidadValida(){
        assertTrue(Validador.esCantidadValida(10));  // Cantidad válida
        assertFalse(Validador.esCantidadValida(-5)); // Cantidad no válida (negativa)
    }
    
    @Test
    public void testEsPrecioValido(){
        assertTrue(Validador.esPrecioValido(20.5));  // Precio válido
        assertFalse(Validador.esPrecioValido(-5.0)); // Precio no válido (negativo)
    }
    
    @Test
    public void testValidarRangoPrecio(){
        assertTrue(Validador.validarPrecioEnRango(10.0, 5.0, 15.0));  // Precio dentro del rango
        assertFalse(Validador.validarPrecioEnRango(20.0, 5.0, 15.0)); // Precio fuera del rango
    }
}
