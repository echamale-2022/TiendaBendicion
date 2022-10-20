package org.edwarchamale.view;

import java.util.Scanner;

/**
 *
 * @author Edwar
 */
public class MenuPrincipal {
    Scanner sc = new Scanner(System.in);

    public void menu() {
        MenuClientes mClientes = new MenuClientes();
        MenuAutores mAutores = new MenuAutores();
        MenuLibros mLibros = new MenuLibros();
        MenuOrdenes mOrdenes = new MenuOrdenes();
        System.out.println("******************");
        System.out.println("* Menu principal *");
        System.out.println("******************");
        System.out.println("1.- Menu clientes");
        System.out.println("2.- Menu autores");
        System.out.println("3.- Menu libros");
        System.out.println("4.- Menu ordenes");
        System.out.println("5.- Salir del sistema");
        System.out.println("Elija la opcion que desea");
        int opc = sc.nextInt();
        switch (opc) {
            case 1:
                mClientes.menuClientes();
                break;
            case 2:
                mAutores.menuAutores();
                break;
            case 3:
                mLibros.menuLibros();
                break;
            case 4:
                mOrdenes.menuOrdenes();
                break;
            case 5:
                System.out.println("Gracias por usar el sistema");
                System.exit(0);
                break;
            default:
                System.out.println("Opcion no validad");
        }
    }
}
