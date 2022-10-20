package org.edwarchamale.view;

import org.edwarchamale.controller.AutoresController;
import java.util.Scanner;

/**
 *
 * @author Edwar
 */
public class MenuAutores {
    Scanner sc = new Scanner(System.in);

    public void menuAutores() {
        AutoresController aController = new AutoresController();
        MenuPrincipal mPrincipal = new MenuPrincipal();
        System.out.println("****************");
        System.out.println("* Menu autores *");
        System.out.println("****************");
        System.out.println("1.- Listar autores");
        System.out.println("2.- Buscar autores");
        System.out.println("3.- Agregar autores");
        System.out.println("4.- Actualizar autores");
        System.out.println("5.- Eliminar autores");
        System.out.println("6.- Regresar al menu principal");
        System.out.println("Elija la opcion que desea");
        int opc = sc.nextInt();
        switch (opc) {
            case 1:
                aController.listarAutores();
                this.menuAutores();
                break;
            case 2:
                aController.buscarAutores();
                this.menuAutores();
                break;
            case 3:
                aController.agregarAutores();
                this.menuAutores();
                break;
            case 4:
                aController.actualizarAutores();
                this.menuAutores();
                break;
            case 5:
                aController.eliminarAutores();
                this.menuAutores();
                break;
            case 6:
                mPrincipal.menu();
                break;
            default:
                System.out.println("Opcion no validad");
        }// fin de switch #1
    }
}
