package org.edwarchamale.model;

import javax.sound.sampled.SourceDataLine;

/**
 *
 * @author Edwar
 */
public class Libros {
    // Variables para agregar
    private int idEditorial;
    private String tituloLibro;
    private int id_autor_fk;
    private double precio;
    // Variables para la vista
    private int idEditorialV;
    private String tituloLibroV;
    private String nombreCompleto;
    private double precioLibro;

    // Constructor vacio
    public Libros() {
    }

    // Constructor lleno
    public Libros(int idEditorial, String tituloLibro, int id_autor_fk, double precio) {
        this.idEditorial = idEditorial;
        this.tituloLibro = tituloLibro;
        this.id_autor_fk = id_autor_fk;
        this.precio = precio;
    }

    // Constructor para la vista
    public Libros(int idEditorialV, String tituloLibroV, String nombreCompleto, double precioLibro) {
        this.idEditorialV = idEditorialV;
        this.tituloLibroV = tituloLibroV;
        this.nombreCompleto = nombreCompleto;
        this.precioLibro = precioLibro;
    }

    // Getters and Setters
    public double getPrecioLibro() {
        return precioLibro;
    }

    public void setPrecioLibro(double precioLibro) {
        this.precioLibro = precioLibro;
    }

    public int getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(int idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public int getId_autor_fk() {
        return id_autor_fk;
    }

    public void setId_autor_fk(int id_autor_fk) {
        this.id_autor_fk = id_autor_fk;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdEditorialV() {
        return idEditorialV;
    }

    public void setIdEditorialV(int idEditorialV) {
        this.idEditorialV = idEditorialV;
    }

    public String getTituloLibroV() {
        return tituloLibroV;
    }

    public void setTituloLibroV(String tituloLibroV) {
        this.tituloLibroV = tituloLibroV;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
    // Vista
    public String VistaLibros(){
        return "Id editorial: " + idEditorialV + " " +
               "Titulo del libro: " + tituloLibroV + " " +
               "Nombre del autor: " + nombreCompleto + " " +
               "Precio del libro: " + precioLibro; 
    }
}
