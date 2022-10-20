package org.edwarchamale.dao;
import java.sql.Connection;
import java.sql.*;
/**
 *
 * @author Edwar
 */
public class Conexion {
    private Connection conexion;
    private static Conexion instancia;
    
    private Conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/TiendaBendicion?useSSL=false",
                        "root",
                        "m7zhktr7");
        } catch(ClassNotFoundException | SQLException |
                InstantiationException | IllegalAccessException e){
                e.getMessage();
        }
    }
    public static Conexion getInstance(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }
    
    public Connection getConexion(){
        return conexion;
    }
    
    public void setConexion(Connection conexion){
        this.conexion = conexion;
    }
}
