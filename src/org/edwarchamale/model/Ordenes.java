package org.edwarchamale.model;
/**
 *
 * @author Edwar
 */
public class Ordenes {
    // Variables para agregar
    private int idOrden;
    private int id_cliente_fk;
    private int id_editorial_fk;
    private String fechaHora;
    private double total;
    // Variables para la vista
    private int id_orden;
    private String nombreCompleto;
    private String tituloLibro;
    private String fechaHoraCompra;
    private double totalCompra;

    // Constructor vacio
    public Ordenes() {
    }

    // Constructor lleno
    public Ordenes(int idOrden, int id_cliente_fk, int id_editorial_fk, String fechaHora, double total) {
        this.idOrden = idOrden;
        this.id_cliente_fk = id_cliente_fk;
        this.id_editorial_fk = id_editorial_fk;
        this.fechaHora = fechaHora;
        this.total = total;
    }

    // Constructor para la vista
    public Ordenes(int id_orden, String nombreCompleto, String tituloLibro, String fechaHoraCompra, double totalCompra) {
        this.id_orden = id_orden;
        this.nombreCompleto = nombreCompleto;
        this.tituloLibro = tituloLibro;
        this.fechaHoraCompra = fechaHoraCompra;
        this.totalCompra = totalCompra;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getId_cliente_fk() {
        return id_cliente_fk;
    }

    public void setId_cliente_fk(int id_cliente_fk) {
        this.id_cliente_fk = id_cliente_fk;
    }

    public int getId_editorial_fk() {
        return id_editorial_fk;
    }

    public void setId_editorial_fk(int id_editorial_fk) {
        this.id_editorial_fk = id_editorial_fk;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public String getFechaHoraCompra() {
        return fechaHoraCompra;
    }

    public void setFechaHoraCompra(String fechaHoraCompra) {
        this.fechaHoraCompra = fechaHoraCompra;
    }

    // Vista
    public String VistaOrdenes(){
        return "Id orden: " + id_orden + " " +
               "Nombre completo: " + nombreCompleto + " " + 
               "Titulo del libro: " + tituloLibro + " " +
               "Fecha y hora de la compra: " + fechaHoraCompra + " " +
               "Total de la compra: " + totalCompra;
    }
}
