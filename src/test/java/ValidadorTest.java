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
        
    }
    
    @Test
    public void testEsCantidadValida(){
        
    }
    
    @Test
    public void testEsPrecioValido(){
        
    }
    
    @Test
    public void testValidarRangoPrecio(){
        
    }
}
