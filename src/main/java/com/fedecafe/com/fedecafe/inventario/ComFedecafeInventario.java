package com.fedecafe.com.fedecafe.inventario;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pcdev
 */
public class ComFedecafeInventario {

    public static void main(String[] args) {
        ProductoDAO productoDAO = new ProductoDAO();
        Scanner scanner = new Scanner(System.in);
        String nombre;
        int codigo;
        int cantidad;
        double precio;
        while (true) {
            System.out.println("Menú de Opciones:");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Actualizar Producto");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el código del producto: ");
                    codigo = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ingrese el nombre del producto: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese la cantidad disponible en stock: ");
                    cantidad = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ingrese el precio unitario: ");
                    precio = Double.parseDouble(scanner.nextLine());

                    Producto nuevoProducto = new Producto(nombre, codigo, cantidad, precio);

                    try {
                        if (productoDAO.insertarProducto(nuevoProducto)) {
                            System.out.println("Producto agregado al inventario.");

                        } else {
                            System.out.println("Producto NO guardado.");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(ComFedecafeInventario.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;

                case 2:
                    System.out.println("Inventario de Productos:");
                    List<Producto> inventario = productoDAO.obtenerTodosLosProductos();
                    for (Producto producto : inventario) {
                        System.out.println("Nombre: " + producto.getNombre());
                        System.out.println("Código: " + producto.getCodigo());
                        System.out.println("Cantidad en Stock: " + producto.getCantidad());
                        System.out.println("Precio Unitario: " + producto.getPrecio());
                        System.out.println("-------------------");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el código del producto: ");
                    codigo = Integer.parseInt(scanner.nextLine());

                    try {
                        Producto p = productoDAO.obtenerProductoPorCodigo(codigo);

                        if (p != null) {
                            System.out.print("Ingrese el nombre del producto: ");
                            nombre = scanner.nextLine();
                            System.out.print("Ingrese la cantidad disponible en stock: ");
                            cantidad = Integer.parseInt(scanner.nextLine());
                            System.out.print("Ingrese el precio unitario: ");
                            precio = Double.parseDouble(scanner.nextLine());
                            Producto productoEditar = new Producto(nombre, codigo, cantidad, precio);
                            if (productoDAO.actualizarProducto(productoEditar)) {
                                System.out.println("Producto modificado.");

                            } else {
                                System.out.println("Producto NO guardado.");
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(ComFedecafeInventario.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                case 4:
                    // Lógica para eliminar un producto
                    break;
                case 5:
                    System.out.println("Saliendo del sistema.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

}
