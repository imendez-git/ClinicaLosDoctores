
package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Fecha 30/09/2021 
 * CopyRight ITCA-FEPADE Version 1.0
 *
 * @author Jhonny Wilson
 *
 */
public class Conexion {

    Connection con;

    public Connection getCon() {
        return con;
    }

    public boolean conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinicaLosDoctores",
                    "root", "");
            return true;

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Conectar" + e.getMessage(), "Error", 0);
            return false;
        }
    }

    public boolean desconectar() {
        try {
            if (con != null) {
                if (con.isClosed() == false) {
                    con.close();
                }
            }
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Desconectar" + e.getMessage(), "Error", 0);
            return false;
        }
    }
}
