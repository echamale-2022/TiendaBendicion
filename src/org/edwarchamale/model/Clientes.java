package org.edwarchamale.model;

/**
 *
 * @author Edwar
 */
public class Clientes {
    // Variables para agregar
    private int idCliente;
    private String nombresCliente;
    private String apellidosCliente;
    private int telefono;
    private String email;
    // Variables para las vistas
    private int idClientes;
    private String nombreCompleto;
    private int no_telefono;
    private String correo;

    // Constructor vacio
    public Clientes() {

    }

    // Constructor lleno
    public Clientes(int idCliente, String nombresCliente, String apellidosCliente, int telefono, String email) {
        this.idCliente = idCliente;
        this.nombresCliente = nombresCliente;
        this.apellidosCliente = apellidosCliente;
        this.telefono = telefono;
        this.email = email;
    }

    // Constructor para la vista
    public Clientes(int idClientes, String nombreCompleto, int no_telefono, String correo) {
        this.idClientes = idClientes;
        this.nombreCompleto = nombreCompleto;
        this.no_telefono = no_telefono;
        this.correo = correo;
    }

    // Getters and Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombresCliente() {
        return nombresCliente;
    }

    public void setNombresCliente(String nombresCliente) {
        this.nombresCliente = nombresCliente;
    }

    public String getApellidosCliente() {
        return apellidosCliente;
    }

    public void setApellidosCliente(String apellidosCliente) {
        this.apellidosCliente = apellidosCliente;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getNo_telefono() {
        return no_telefono;
    }

    public void setNo_telefono(int no_telefono) {
        this.no_telefono = no_telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Vista
    public String VistaClientes() {
        return "Id cliente: " + idClientes + " " +
                "Nombre completo: " + nombreCompleto + " " +
                "No. telefono: " + no_telefono + " " +
                "Email: " + correo;
    }
}
