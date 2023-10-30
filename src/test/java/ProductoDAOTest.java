
import com.fedecafe.com.fedecafe.inventario.Producto;
import com.fedecafe.com.fedecafe.inventario.ProductoDAO;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author pcdev
 */
public class ProductoDAOTest {
    
    private ProductoDAO productoDAO;

    @BeforeEach
    public void setUp() {
        productoDAO = new ProductoDAO();
    }

    @Test
    public void testInsertarProducto() throws SQLException {
        Producto producto = new Producto("ProductoTest", 1000000, 15, 10.0);
        productoDAO.insertarProducto(producto);

        List<Producto> productos = productoDAO.obtenerTodosLosProductos();
        assertTrue(productos.contains(producto));
    }

    @Test
    public void testObtenerTodosLosProductos() {
        // Realiza la inserción de algunos productos en la base de datos antes de la prueba
        //...

        List<Producto> productos = productoDAO.obtenerTodosLosProductos();
        assertNotNull(productos);
        // Realiza aserciones sobre la lista de productos obtenidos
        // Por ejemplo, verifica si la lista no está vacía o contiene ciertos elementos
    }

    @Test
    public void testActualizarProducto() throws SQLException {
        // Realiza la inserción de un producto en la base de datos antes de la prueba
        //...

        Producto producto = new Producto("ProductoActualizado", 1000000, 20, 15.0);
        productoDAO.insertarProducto(producto);

        // Actualiza el producto en la base de datos
        producto.setCantidad(30);
        producto.setPrecio(25.0);
        productoDAO.actualizarProducto(producto);

        // Obtiene el producto actualizado de la base de datos
        Producto productoActualizado = productoDAO.obtenerProductoPorCodigo(1000000);
        assertNotNull(productoActualizado);
        assertEquals(30, productoActualizado.getCantidad());
        assertEquals(25.0, productoActualizado.getPrecio());
    }

    @Test
    public void testEliminarProducto() {
        // Realiza la inserción de un producto en la base de datos antes de la prueba
        //...

        // Elimina el producto de la base de datos
        productoDAO.eliminarProducto(1000000);

        // Verifica que el producto ha sido eliminado
        Producto productoEliminado = productoDAO.obtenerProductoPorCodigo(1000000);
        assertNull(productoEliminado);
    }
}
