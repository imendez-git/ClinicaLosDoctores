package com.controladores;

import com.conexion.Conexion;
import java.sql.*;
import com.controladores.UsuariosLogin;
import javax.swing.JOptionPane;

public class daoLogin extends Conexion {

    String sql;
    ResultSet rs;
    int control = 0;

    public int acceder(UsuariosLogin us) throws Exception {
        try {
            PreparedStatement pst;
            this.conectar();
            String cap = "";
            sql = "select * from Usuarios where nombreUsuario=? && clave=?";
            pst = this.getCon().prepareStatement(this.sql);
            pst.setString(1, us.getNombreUsuario());
            pst.setString(2, us.getContraseña());
            rs = pst.executeQuery();
            while (rs.next()) {
                cap = rs.getString("idRol");

            }
            if (cap.equals("1")) {
                control = 1;
            }
            if (cap.equals("2")) {

                control = 2;
            }
            if ((!cap.equals("1")) && (!cap.equals("2"))) {
                JOptionPane.showMessageDialog(null, "Datos incorrectos");
            }
        } catch (SQLException ex) {
            return -1;
        } finally {
            this.desconectar();
            switch (control) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                default:
                    return -1;
            }
        }

    }
    
}
