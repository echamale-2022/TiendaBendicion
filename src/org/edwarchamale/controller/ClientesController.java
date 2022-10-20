package org.edwarchamale.controller;

import org.edwarchamale.model.Clientes;
import org.edwarchamale.dao.Conexion;
import java.util.Scanner;
import java.sql.*;

/**
 *
 * @author Edwar
 */
public class ClientesController {
    Scanner sc = new Scanner(System.in);

    public void listarClientes() {
        try {
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("CALL sp_listaClientes");
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                Clientes cli = new Clientes();
                cli.setIdClientes(resultado.getInt(1));
                cli.setNombreCompleto(resultado.getString(2));
                cli.setNo_telefono(resultado.getInt(3));
                cli.setCorreo(resultado.getString(4));
                System.out.println(cli.VistaClientes());
            }
            resultado.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void buscarClientes() {
        System.out.println("Ingrese el id del cliente a buscar");
        int idCliente = sc.nextInt();
        try {
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("CALL sp_buscarClientes(?)");
            ps.setInt(1, idCliente);
            ps.execute();
            ResultSet resultado = ps.executeQuery();
            if (!resultado.isBeforeFirst()) {
                while (!resultado.next()) {
                    Clientes cli = new Clientes();
                    cli.setIdClientes(resultado.getInt(1));
                    cli.setNombreCompleto(resultado.getString(2));
                    cli.setNo_telefono(resultado.getInt(3));
                    cli.setCorreo(resultado.getString(4));
                    System.out.println(cli.VistaClientes());
                }
            } else {
                while (resultado.next()) {
                    Clientes cli = new Clientes();
                    cli.setIdClientes(resultado.getInt(1));
                    cli.setNombreCompleto(resultado.getString(2));
                    cli.setNo_telefono(resultado.getInt(3));
                    cli.setCorreo(resultado.getString(4));
                    System.out.println(cli.VistaClientes());
                }
                resultado.close();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void agregarClientes() {
        ObtenerDatos oDatos = new ObtenerDatos();
        System.out.println("Ingrese sus nombres");
        String nombres = oDatos.nombres();
        System.out.println("Ingrese sus apellidos");
        String apellidos = oDatos.apellidos();
        System.out.println("Ingrese su numero de telefono");
        int telefono = sc.nextInt();
        System.out.println("Ingrese su email");
        String email = oDatos.email();
        try {
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("CALL sp_agregarClientes(?, ?, ?, ?)");
            ps.setString(1, nombres);
            ps.setString(2, apellidos);
            ps.setInt(3, telefono);
            ps.setString(4, email);
            ps.execute();
            System.out.println("Cliente agregado exitosamente");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void actualizarClientes() {
        ObtenerDatos oDatos = new ObtenerDatos();
        System.out.println("Ingrese el id del cliente a actualizar");
        int idCliente = sc.nextInt();
        System.out.println("Ingrese sus nuevos nombres");
        String nombres = oDatos.nombres();
        System.out.println("Ingrese sus nuevos apellidos");
        String apellidos = oDatos.apellidos();
        System.out.println("Ingrese su nuevo numero de telefono");
        int telefono = sc.nextInt();
        System.out.println("Ingrese su nuevo email");
        String email = oDatos.email();
        try {
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("CALL sp_actualizarClientes(?, ?, ?, ?, ?)");
            ps.setInt(1, idCliente);
            ps.setString(2, nombres);
            ps.setString(3, apellidos);
            ps.setInt(4, telefono);
            ps.setString(5, email);
            ps.execute();
            System.out.println("Cliente actualizado exitosamente");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void eliminarCliente() {
        System.out.println("Ingrese el id del cliente a eliminar");
        int idCliente = sc.nextInt();
        try {
            PreparedStatement ps = Conexion.getInstance().getConexion()
                    .prepareCall("CALL sp_eliminarClientes(?)");
            ps.setInt(1, idCliente);
            ps.execute();
            System.out.println("Cliente eliminado exitosamente");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
