package org.edwarchamale.controller;

import org.edwarchamale.model.Libros;
import org.edwarchamale.dao.Conexion;
import java.util.Scanner;
import java.sql.*;

/**
 *
 * @author Edwar
 */
public class LibrosController {
    Scanner sc = new Scanner(System.in);

    public void listarLibros() {
        try {
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("CALL sp_listarLibros()");
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                Libros libros = new Libros();
                libros.setIdEditorialV(resultado.getInt(1));
                libros.setTituloLibroV(resultado.getString(2));
                libros.setNombreCompleto(resultado.getString(3));
                libros.setPrecioLibro(resultado.getDouble(4));
                System.out.println(libros.VistaLibros());
            }
            resultado.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void buscarLibros() {
        System.out.println("Ingrese la editorial del libro a buscar");
        int idEditorial = sc.nextInt();
        try {
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("CALL sp_buscarLibros(?)");
            ps.setInt(1, idEditorial);
            ps.execute();
            ResultSet resultado = ps.executeQuery();
            if (!resultado.isBeforeFirst()) {
                while (!resultado.next()) {
                    Libros libros = new Libros();
                    libros.setIdEditorialV(resultado.getInt(1));
                    libros.setTituloLibroV(resultado.getString(2));
                    libros.setNombreCompleto(resultado.getString(3));
                    libros.setPrecioLibro(resultado.getDouble(4));
                    System.out.println(libros.VistaLibros());
                }
            } else {
                while (resultado.next()) {
                    Libros libros = new Libros();
                    libros.setIdEditorialV(resultado.getInt(1));
                    libros.setTituloLibroV(resultado.getString(2));
                    libros.setNombreCompleto(resultado.getString(3));
                    libros.setPrecioLibro(resultado.getDouble(4));
                    System.out.println(libros.VistaLibros());
                }
            }
            resultado.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void agregarLibros() {
        ObtenerDatos oDatos = new ObtenerDatos();
        System.out.println("Ingrese la editorial del libro");
        int idEditorial = sc.nextInt();
        System.out.println("Ingrese el titulo del libro");
        String tituloLibro = oDatos.tituloLibro();
        System.out.println("Ingrese el id del autor del libro");
        int idAutor = sc.nextInt();
        System.out.println("Ingrese el precio del libro");
        double precio = sc.nextDouble();
        try {
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("CALL sp_agregarLibros(?, ?, ?, ?)");
            ps.setInt(1, idEditorial);
            ps.setString(2, tituloLibro);
            ps.setInt(3, idAutor);
            ps.setDouble(4, precio);
            ps.execute();
            System.out.println("Libro agregado exitosamente");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void actualizarLibros() {
        ObtenerDatos oDatos = new ObtenerDatos();
        System.out.println("Ingrese la editorial del libro a actualizar");
        int idEditorial = sc.nextInt();
        System.out.println("Ingrese el nuevo titulo del libro");
        String tituloLibro = oDatos.tituloLibro();
        System.out.println("Ingrese el nuevo id del autor del libro");
        int idAutor = sc.nextInt();
        System.out.println("Ingrese el nuevo precio del libro");
        double precio = sc.nextDouble();
        try {
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("CALL sp_actualizarLibros");
            ps.setInt(1, idEditorial);
            ps.setString(2, tituloLibro);
            ps.setInt(3, idAutor);
            ps.setDouble(4, precio);
            ps.execute();
            System.out.println("Libro actualizado exitosamente");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void eliminarLibros() {
        System.out.println("Ingrese la editorial del libro a eliminar");
        int idEditorial = sc.nextInt();
        try {
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("CALL sp_eliminarLibros(?)");
            ps.setInt(1, idEditorial);
            ps.execute();
            System.out.println("Libro eliminado exitosamente");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
