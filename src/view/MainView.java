package view;

import controller.MainController;
import model.menu.IMenuCall;
import model.menu.Menu;
import model.menu.MenuItem;
import model.utilitarios.ListBuilder;

import java.util.Scanner;

public class MainView {

    private MainController controller;
    private Scanner in;

    public MainView() {
        this.controller = new MainController();
        this.in = new Scanner(System.in);
        this.run();
    }

    public void run() {
        Menu menu = new Menu(
            new ListBuilder<MenuItem>()
                    .add(new MenuItem("Generar clientes", generarClientes))
                    .add(new MenuItem("Generar cajeros", generarCajeros))
                    .add(new MenuItem("Turnos", TurnoView::new))
                    .add(new MenuItem("Reportes", menuReportes))
        .build(), "Menu principal");

        menu.iniciar();
    }

    private final IMenuCall generarClientes = () -> {
        System.out.print("Ingrese el numero de clientes a generar > ");
        int cantidad = this.in.nextInt();
        this.controller.generarClientes(cantidad);
    };

    private final IMenuCall generarCajeros = () -> {
        System.out.print("Ingrese el numero de cajeros a generar > ");
        int cantidad = this.in.nextInt();
        this.controller.generarCajeros(cantidad);
    };

    private final IMenuCall menuReportes = () -> {
        Menu menu = new Menu(
                new ListBuilder<MenuItem>()
                        .add(new MenuItem("Clientes", ClienteView::new))
                        .add(new MenuItem("Cajeros", CajeroView::new))
                        .build(), "Reportes");

        menu.iniciar();
    };

}
