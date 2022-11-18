/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.Modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
	
    private final String base ="iloveny";
    private final String user = "iloveny_dev";
    private final String password = "eFgq5kq";
    private final String url = "jdbc:postgresql://10.4.3.195:5432/"+base;
    private Connection con = null;
    
    /**
     * Establece la conexion con la base de datos.
     * @return Un objeto tipo connection
     */
    public  Connection conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    /**
     * Cierra la conexion con la base de datos.
     */
    public void desconectar(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }    
}