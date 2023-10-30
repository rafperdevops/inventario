/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fedecafe.com.fedecafe.inventario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pcdev
 */
public class ConexionBD {

    public static Connection conectarBD() {
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/inventario"; // Reemplaza con la URL de tu base de datos
            String usuario = "rperez";// Reemplaza con tu usuario
            String password = "123456"; // Reemplaza con tu contraseña
            con = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
