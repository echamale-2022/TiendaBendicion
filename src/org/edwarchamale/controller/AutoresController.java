package org.edwarchamale.controller;
import org.edwarchamale.model.Autor;
import org.edwarchamale.dao.Conexion;
import java.sql.*;
import java.util.Scanner;
public class AutoresController {
    Scanner sc = new Scanner(System.in);
    public void listarAutores() {
        try {
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("CALL sp_listarAutores()");
            ResultSet resultado = ps.executeQuery();
                while (resultado.next()) {
                    Autor autor = new Autor();
                    autor.setId_autor(resultado.getInt(1));
                    autor.setNombreAutor(resultado.getString(2));
                    System.out.println(autor.VistaAutores());
                }
                resultado.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public void buscarAutores() {
        System.out.println("Ingrese el id del autor a buscar");
        int idAutor = sc.nextInt();
            try {
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_buscarAutores(?)");
                ps.setInt(1, idAutor);
                ps.execute();
                ResultSet resultado = ps.executeQuery();
                    if(!resultado.isBeforeFirst()){
                        while (!resultado.next()) {
                            Autor autor = new Autor();
                            autor.setId_autor(resultado.getInt(1));
                            autor.setNombreAutor(resultado.getString(2));
                            System.out.println(autor.VistaAutores());
                        }
                    } else {
                        while (resultado.next()) {
                            Autor autor = new Autor();
                            autor.setId_autor(resultado.getInt(1));
                            autor.setNombreAutor(resultado.getString(2));
                            System.out.println(autor.VistaAutores());
                        }
                    }
                    resultado.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
    }
    public void agregarAutores(){
        ObtenerDatos oDatos = new ObtenerDatos();
        System.out.println("Ingrese los nombres del autor");
        String nombres = oDatos.nombres();
        System.out.println("Ingrese los apellidos del autor");
        String apellidos = oDatos.apellidos();
            try {
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_agregarAutores(?, ?)");
                ps.setString(1, nombres);
                ps.setString(2, apellidos);
                ps.execute();
                System.out.println("Autor agregado exitosamente");
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
    }
    public void actualizarAutores() {
        ObtenerDatos oDatos = new ObtenerDatos();
        System.out.println("Ingrese el id del autor a actualizar");
        int idAutor = sc.nextInt();
        System.out.println("Ingrese los nuevos nombres del autor");
        String nombres = oDatos.nombres();
        System.out.println("Ingrese los nuevos apellidos del autor");
        String apellidos = oDatos.apellidos();
            try {
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_actualizarAutores(?, ?, ?)");
                ps.setInt(1, idAutor);
                ps.setString(2, nombres);
                ps.setString(3, apellidos);
                ps.execute();
                System.out.println("Autor actualizado exitosamente");
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
    }
    public void eliminarAutores() {
        System.out.println("Ingrese el id del autor a eliminar");
        int idAutor = sc.nextInt();
            try {
                PreparedStatement ps = Conexion.getInstance().getConexion()
                        .prepareCall("CALL sp_eliminarAutores(?)");
                ps.setInt(1, idAutor);
                ps.execute();
                System.out.println("Autor eliminado exitosamente");
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
    }    
}
