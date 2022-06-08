package view;

import controller.CajeroController;
import model.Repository;
import model.menu.IMenuCall;
import model.menu.Menu;
import model.menu.MenuItem;
import model.utilitarios.ListBuilder;

import java.util.Scanner;

public class CajeroView {

    private CajeroController controller;
    private Scanner in;

    public CajeroView() {
        this.controller = new CajeroController();
        this.in = new Scanner(System.in);
        this.run();
    }

    public void run() {
        System.out.println("");
        Menu menu = new Menu(
            new ListBuilder<MenuItem>()
                .add(new MenuItem("Mostrar clientes atendidos por cajero", listar))
                .add(new MenuItem("Ordenar por numero de personas atendidas", ordenarCajeros))
        .build(), "Reportes Cajeros");

        menu.iniciar();
    }

    public IMenuCall listar = () -> this.controller.obtenerCajeros().forEach(System.out::println);

    public IMenuCall ordenarCajeros = () -> this.controller.ordenar();

}
