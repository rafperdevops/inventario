/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fedecafe.com.fedecafe.inventario;

/**
 *
 * @author pcdev
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    public boolean insertarProducto(Producto producto) throws SQLException {
        try (Connection con = ConexionBD.conectarBD();
                PreparedStatement stmt = con.prepareStatement(
                        "INSERT INTO productos (nombre, codigo, cantidad, precio) VALUES (?, ?, ?, ?)")) {
            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getCodigo());
            stmt.setInt(3, producto.getCantidad());
            stmt.setDouble(4, producto.getPrecio());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Producto> obtenerTodosLosProductos() {
        List<Producto> productos = new ArrayList<>();
        try (Connection con = ConexionBD.conectarBD();
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM productos");
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Producto producto = new Producto(
                        rs.getString("nombre"),
                        rs.getInt("codigo"),
                        rs.getInt("cantidad"),
                        rs.getDouble("precio"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    public boolean actualizarProducto(Producto producto) throws SQLException {
        try (Connection con = ConexionBD.conectarBD();
                PreparedStatement stmt = con.prepareStatement(
                        "UPDATE productos SET nombre = ?, cantidad = ?, precio = ? WHERE codigo = ?")) {
            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getCantidad());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setInt(4, producto.getCodigo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarProducto(int codigo) {
        try (Connection con = ConexionBD.conectarBD();
                PreparedStatement stmt = con.prepareStatement("DELETE FROM productos WHERE codigo = ?")) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Producto obtenerProductoPorCodigo(int codigo) {
        Producto producto = null;
        try (Connection con = ConexionBD.conectarBD();
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM productos WHERE codigo=?")) {
            stmt.setInt(1, codigo);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    producto = new Producto(
                            rs.getString("nombre"),
                            rs.getInt("codigo"),
                            rs.getInt("cantidad"),
                            rs.getDouble("precio"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return producto;
    }
}
