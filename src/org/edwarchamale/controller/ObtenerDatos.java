package org.edwarchamale.controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 *
 * @author Edwar
 */
public class ObtenerDatos {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public String nombres(){
        String nombres = null;
        try {
            nombres = bf.readLine();
        } catch (Exception ioe) {
            System.out.println("¡Error! de ioe");
            System.exit(0);
        }
        return nombres;
    }
    public String apellidos(){
        String apellidos = null;
        try {
            apellidos = bf.readLine();
        } catch (Exception ioe) {
            System.out.println("¡Error! de ioe");
            System.exit(0);
        }
        return apellidos;
    }
    public String email(){
        String email = null;
        try {
            email = bf.readLine();
        } catch (Exception ioe) {
            System.out.println("¡Error! de ioe");
            System.exit(0);
        }
        return email;
    }
    public String tituloLibro(){
        String tituloLibro = null;
        try {
            tituloLibro = bf.readLine();
        } catch (Exception ioe) {
            System.out.println("¡Error! de ioe");
            System.exit(0);
        }
        return tituloLibro;
    }
}
