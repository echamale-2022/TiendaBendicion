package org.edwarchamale.view;

import org.edwarchamale.controller.LibrosController;
import java.util.Scanner;

/**
 *
 * @author Edwar
 */
public class MenuLibros {
    Scanner sc = new Scanner(System.in);

    public void menuLibros() {
        LibrosController lController = new LibrosController();
        MenuPrincipal mPrincipal = new MenuPrincipal();
        System.out.println("***************");
        System.out.println("* Menu libros *");
        System.out.println("***************");
        System.out.println("1.- Listar libros");
        System.out.println("2.- Buscar libros");
        System.out.println("3.- Agregar libros");
        System.out.println("4.- Actualizar libros");
        System.out.println("5.- Eliminar libros");
        System.out.println("6.- Regresar al menu principal");
        System.out.println("Elija la opcion que desea");
        int opc = sc.nextInt();
        switch (opc) {
            case 1:
                lController.listarLibros();
                this.menuLibros();
                break;
            case 2:
                lController.buscarLibros();
                this.menuLibros();
                break;
            case 3:
                lController.agregarLibros();
                this.menuLibros();
                break;
            case 4:
                lController.actualizarLibros();
                this.menuLibros();
                break;
            case 5:
                lController.eliminarLibros();
                this.menuLibros();
                break;
            case 6:
                mPrincipal.menu();
                break;
            default:
                System.out.println("Opcion no validad");
        }// fin de switch #1
    }
}
