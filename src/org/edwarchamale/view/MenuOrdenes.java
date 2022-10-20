package org.edwarchamale.view;

import org.edwarchamale.controller.OrdenesController;
import java.util.Scanner;

/**
 *
 * @author Edwar
 */
public class MenuOrdenes {
    Scanner sc = new Scanner(System.in);

    public void menuOrdenes() {
        OrdenesController oController = new OrdenesController();
        MenuPrincipal mPrincipal = new MenuPrincipal();
        System.out.println("****************");
        System.out.println("* Menu ordenes *");
        System.out.println("****************");
        System.out.println("1.- Listar ordenes");
        System.out.println("2.- Buscar ordenes");
        System.out.println("3.- Agregar ordenes");
        System.out.println("4.- Actualizar ordenes");
        System.out.println("5.- Eliminar ordenes");
        System.out.println("6.- Regresar al menu principal");
        System.out.println("Elija la opcion que desea");
        int opc = sc.nextInt();
        switch (opc) {
            case 1:
                oController.listarOrdenes();
                this.menuOrdenes();
                break;
            case 2:
                oController.buscarOrdenes();
                this.menuOrdenes();
                break;
            case 3:
                oController.agregarOrdenes();
                this.menuOrdenes();
                break;
            case 4:
                oController.actualizarOrdenes();
                this.menuOrdenes();
                break;
            case 5:
                oController.eliminarOrdenes();
                this.menuOrdenes();
                break;
            case 6:
                mPrincipal.menu();
                break;
            default:
                System.out.println("Opcion no validad");
        }// fin de switch #1
    }
}
