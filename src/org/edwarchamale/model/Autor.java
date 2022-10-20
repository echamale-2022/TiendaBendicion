package org.edwarchamale.model;

/**
 *
 * @author Edwar
 */
public class Autor {
    // Variables para agregar
    private int idAutor;
    private String nombresAutor;
    private String apellidosAutor;
    // Variables para la vista
    private int id_autor;
    private String nombreAutor;

    // Constructor vacio
    public Autor() {
    }

    // Constructor lleno
    public Autor(int idAutor, String nombresAutor, String apellidosAutor) {
        this.idAutor = idAutor;
        this.nombresAutor = nombresAutor;
        this.apellidosAutor = apellidosAutor;
    }

    // Constructor para la vista
    public Autor(int id_autor, String nombreAutor) {
        this.id_autor = id_autor;
        this.nombreAutor = nombreAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombresAutor() {
        return nombresAutor;
    }

    public void setNombresAutor(String nombresAutor) {
        this.nombresAutor = nombresAutor;
    }

    public String getApellidosAutor() {
        return apellidosAutor;
    }

    public void setApellidosAutor(String apellidosAutor) {
        this.apellidosAutor = apellidosAutor;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    // Vista
    public String VistaAutores() {
        return "Id autor: " + id_autor + " " +
                "Nombre del autor: " + nombreAutor;
    }
}
