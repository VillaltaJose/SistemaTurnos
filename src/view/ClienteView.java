package view;

import controller.MainController;
import model.Repository;
import model.menu.Menu;
import model.menu.MenuItem;
import model.utilitarios.ListBuilder;

import java.util.Scanner;

public class ClienteView {

    private MainController controller;
    private Scanner in;

    public ClienteView() {
        this.controller = new MainController();
        this.in = new Scanner(System.in);
        this.run();
    }

    public void run() {
        System.out.println("");
        Menu menu = new Menu(
                new ListBuilder<MenuItem>()
                        .add(new MenuItem("Ordenar por numero de personas atendidas", () -> {}))
                        .build(), "Menu principal");

        menu.iniciar();
    }

    public void ordenarCajeros() {

    }

}
