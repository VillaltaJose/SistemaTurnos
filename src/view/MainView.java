package view;

import controller.MainController;
import model.Cajero;
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
                    .add(new MenuItem("Generar turnos", generarTurnos))
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

    private final IMenuCall generarTurnos = () -> {
        System.out.println("Generando turnos, espere por favor...");
        this.controller.generarTurnos();
        System.out.println("Turnos generados exitosamente!");
    };

    private final IMenuCall menuReportes = () -> {
        Menu menu = new Menu(
                new ListBuilder<MenuItem>()
                        .add(new MenuItem("Clientes", () -> new ClienteView().run()))
                        .add(new MenuItem("Cajeros", () -> new CajeroView().run()))
                        .build(), "Reportes");

        menu.iniciar();
    };

}
