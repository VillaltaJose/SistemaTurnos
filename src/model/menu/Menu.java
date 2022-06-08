package model.menu;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private List<MenuItem> opciones;
    private Scanner in;
    private String nombreMenu;

    public Menu(List<MenuItem> opciones) {
        this.opciones = opciones;
        this.in = new Scanner(System.in);
        this.nombreMenu = "Menu de opciones";
    }

    public Menu(List<MenuItem> opciones, String nombreMenu) {
        this.opciones = opciones;
        this.in = new Scanner(System.in);
        this.nombreMenu = nombreMenu;
    }

    public void agregar(MenuItem opcion) {
        this.opciones.add(opcion);
    }

    public void iniciar() {
        int opt;

        do {
            System.out.println("========= " + this.nombreMenu.toUpperCase() + " =========");
            for (int i = 0; i < this.opciones.size(); i++) {
                System.out.println((i + 1) + "- " + this.opciones.get(i).getMensaje());
            }
            System.out.println("0- Salir");

            System.out.print("Seleccione una opción > ");
            opt = this.in.nextInt();

            if (opt > 0 && this.opciones.size() >= opt && this.opciones.get(opt - 1) != null) {
                this.opciones.get(opt - 1).ejecutar();
            } else if (opt != 0) {
                System.out.println("[ERROR]: Debe seleccionar una opción válida");
            }

            System.out.println();

        } while(opt != 0);

        System.out.println(this.nombreMenu + " cerrado");
    }

}
