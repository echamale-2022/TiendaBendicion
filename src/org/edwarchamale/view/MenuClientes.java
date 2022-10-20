package org.edwarchamale.view;

import org.edwarchamale.controller.ClientesController;
import java.util.Scanner;

public class MenuClientes {
    ClientesController cController = new ClientesController();
    Scanner sc = new Scanner(System.in);

    public void menuClientes() {
        MenuPrincipal mPrincipal = new MenuPrincipal();
        System.out.println("*****************");
        System.out.println("* Menu clientes *");
        System.out.println("*****************");
        System.out.println("1.- Listar clientes");
        System.out.println("2.- Buscar clientes");
        System.out.println("3.- Agregar clientes");
        System.out.println("4.- Actualizar clientes");
        System.out.println("5.- Eliminar clientes");
        System.out.println("6.- Regresar al menu principal");
        System.out.println("Elija la opcion que desea");
        int opc = sc.nextInt();
        switch (opc) {
            case 1:
                cController.listarClientes();
                this.menuClientes();
                break;
            case 2:
                cController.buscarClientes();
                this.menuClientes();
                break;
            case 3:
                cController.agregarClientes();
                this.menuClientes();
                break;
            case 4:
                cController.actualizarClientes();
                this.menuClientes();
                break;
            case 5:
                cController.eliminarCliente();
                this.menuClientes();
                break;
            case 6:
                mPrincipal.menu();
                break;
            default:
                System.out.println("Opcion no validad");
        }// fin de switch #1
    }
}
