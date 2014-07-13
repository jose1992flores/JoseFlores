/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JoséLuis
 */
public class Conexionbd {

    public static Object GetInstancia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Connection conectar = null; 
    private PreparedStatement sentencia = null;
    private ResultSet resultado = null;
    private static Conexionbd instancia; 
    
    public static Conexionbd getInstancia()
    {
       if(instancia == null )
       {
       instancia = new Conexionbd();    
       }
        return instancia;
    }
    private static String usuario;

    /**
     * Get the value of usuario
     *
     * @return the value of usuario
     */
    public static String getUsuario() {
        return usuario;
    }

    /**
     * Set the value of usuario
     *
     * @param usuario new value of usuario
     */
    public static void setUsuario(String usuario) {
        Conexionbd.usuario = usuario;
    }

    private static String pasword;

    /**
     * Get the value of pasword
     *
     * @return the value of pasword
     */
    public static String getPasword() {
        return pasword;
    }

    /**
     * Set the value of pasword
     *
     * @param pasword new value of pasword
     */
    public static void setPasword(String pasword) {
        Conexionbd.pasword = pasword;
    }

    private static String cadenaConexion;

    /**
     * Get the value of cadenaConexion
     *
     * @return the value of cadenaConexion
     */
    public static String getCadenaConexion() {
        return cadenaConexion;
    }

    /**
     * Set the value of cadenaConexion
     *
     * @param cadenaConexion new value of cadenaConexion
     */
    public static void setCadenaConexion(String cadenaConexion) {
        Conexionbd.cadenaConexion = cadenaConexion;
    }

    public void conectar()
    {
        try {
            conectar = DriverManager.getConnection(cadenaConexion, usuario ,pasword );
        } catch (SQLException ex) {
            Logger.getLogger(Conexionbd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void desconectar()
    {
        try {
            conectar.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexionbd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ejecutar(String cadenaSql)throws SQLException
    {
        try {
            sentencia = conectar.prepareStatement(cadenaSql);
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public void Conectar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
