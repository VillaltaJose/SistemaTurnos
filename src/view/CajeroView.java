package view;

import controller.CajeroController;
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
                .add(new MenuItem("Listar cajeros", listar))
                .add(new MenuItem("Mostrar clientes atendidos por cajero", listarClientesPorCajero))
                .add(new MenuItem("Ordenar por numero de personas atendidas", ordenarCajeros))
                .add(new MenuItem("Buscar cajero", buscarCajeroNombre))
        .build(), "Reportes Cajeros");

        menu.iniciar();
    }

    public IMenuCall listar = () -> this.controller.obtenerCajeros().forEach(System.out::println);

    public IMenuCall ordenarCajeros = () -> this.controller.ordenar();

    public IMenuCall listarClientesPorCajero = () -> {
        System.out.print("Ingrese el ID del cajero a consultar > ");
        long id = this.in.nextLong();

        this.controller.obtenerCajero(id).getTurnos().forEach(t -> System.out.println(t.getCliente()));
    };

    public IMenuCall buscarCajeroNombre = () -> {
        System.out.print("Ingrese el nombre del cajero a consultar > ");
        String nombre = this.in.next();

        this.controller.obtenerCajero(nombre).getTurnos().forEach(t -> System.out.println(t.getCliente()));
    };

}
