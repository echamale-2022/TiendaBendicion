package org.edwarchamale.controller;

import org.edwarchamale.model.Ordenes;
import org.edwarchamale.dao.Conexion;
import java.util.Scanner;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrdenesController {
    Scanner sc = new Scanner(System.in);
    
    public void listarOrdenes() {
        try {
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("CALL sp_listarOrdenes()");
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                Ordenes ordenes = new Ordenes();
                ordenes.setId_orden(resultado.getInt(1));
                ordenes.setNombreCompleto(resultado.getString(2));
                ordenes.setTituloLibro(resultado.getString(3));
                ordenes.setFechaHoraCompra(resultado.getString(4));
                ordenes.setTotalCompra(resultado.getDouble(5));
                System.out.println(ordenes.VistaOrdenes());
            }
            resultado.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void buscarOrdenes() {
        System.out.println("Ingrese el id de la orden a buscar");
        int idOrden = sc.nextInt();
        try {
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("CALL sp_buscarOrdenes(?)");
            ps.setInt(1, idOrden);
            ps.execute();
            ResultSet resultado = ps.executeQuery();
            if (!resultado.isBeforeFirst()) {
                while (!resultado.next()) {
                    Ordenes ordenes = new Ordenes();
                    ordenes.setId_orden(resultado.getInt(1));
                    ordenes.setNombreCompleto(resultado.getString(2));
                    ordenes.setTituloLibro(resultado.getString(3));
                    ordenes.setFechaHoraCompra(resultado.getString(4));
                    ordenes.setTotalCompra(resultado.getDouble(5));
                    System.out.println(ordenes.VistaOrdenes());
                }
            } else {
                while (resultado.next()) {
                    Ordenes ordenes = new Ordenes();
                    ordenes.setId_orden(resultado.getInt(1));
                    ordenes.setNombreCompleto(resultado.getString(2));
                    ordenes.setTituloLibro(resultado.getString(3));
                    ordenes.setFechaHoraCompra(resultado.getString(4));
                    ordenes.setTotalCompra(resultado.getDouble(5));
                    System.out.println(ordenes.VistaOrdenes());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void agregarOrdenes() {
        LocalDateTime horaFechaLocal = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println("Ingrese el id del cliente");
        int idCliente = sc.nextInt();
        System.out.println("Ingrese el id de la editorial del libro");
        int idEditorial = sc.nextInt();
        System.out.println("Ingrese el total de la compra");
        double total = sc.nextDouble();
        String fechaHora = horaFechaLocal.format(formato);
        try {
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("CALL sp_agregarOrdenes(?, ?, ?, ?)");
            ps.setInt(1, idCliente);
            ps.setInt(2, idEditorial);
            ps.setString(3, fechaHora);
            ps.setDouble(4, total);
            ps.execute();
            System.out.println("Orden agregada exitosamente");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void actualizarOrdenes() {
        LocalDateTime horaFechaLocal = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println("Ingrese el id de la orden a actualizar");
        int idOrden = sc.nextInt();
        System.out.println("Ingrese el nuevo id del cliente");
        int idCliente = sc.nextInt();
        System.out.println("Ingrese el nuevo id de la editorial del libro");
        int idEditorial = sc.nextInt();
        System.out.println("Ingrese el nuevo total de la compra");
        double total = sc.nextDouble();
        String fechaHora = horaFechaLocal.format(formato);
        try {
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("CALL sp_actualizarOrdenes(?, ?, ?, ?, ?)");
            ps.setInt(1, idOrden);
            ps.setInt(2, idCliente);
            ps.setInt(3, idEditorial);
            ps.setString(4, fechaHora);
            ps.setDouble(5, total);
            ps.execute();
            System.out.println("Orden actualizada exitosamente");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void eliminarOrdenes() {
        System.out.println("Ingrese el id de la orden a eliminar");
        int idOrden = sc.nextInt();
        try {
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("CALL sp_eliminarOrdenes(?)");
            ps.setInt(1, idOrden);
            ps.execute();
            System.out.println("Orden eliminada exitosamente");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
