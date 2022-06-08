package view;

import controller.ClienteController;
import model.Cliente;
import model.menu.IMenuCall;
import model.menu.Menu;
import model.menu.MenuItem;
import model.utilitarios.ListBuilder;

import java.util.Scanner;

public class ClienteView {

    private ClienteController controller;
    private Scanner in;

    public ClienteView() {
        this.controller = new ClienteController();
        this.in = new Scanner(System.in);
        this.run();
    }

    public void run() {
        System.out.println("");
        Menu menu = new Menu(
                new ListBuilder<MenuItem>()
                        .add(new MenuItem("Listar clientes", listar))
                        .add(new MenuItem("Ordenar por nombre", ordenarNombre))
                        .add(new MenuItem("Ordenar por apellido", ordenarApellido))
                        .add(new MenuItem("Ordenar por tiempo de espera", ordenarTiempoEspera))
                        .add(new MenuItem("Consultar cliente por ID", consultarId))
                        .build(), "Reportes clientes");

        menu.iniciar();
    }

    public IMenuCall listar = () -> this.controller.obtenerClientes().forEach(System.out::println);

    public IMenuCall ordenarNombre = () -> this.controller.ordenarNombre();

    public IMenuCall ordenarApellido = () -> this.controller.ordenarApellido();

    public IMenuCall ordenarTiempoEspera = () -> this.controller.ordenarTiempoEspera();

    public IMenuCall consultarId = () -> {
        System.out.print("Ingrese el ID del cliente a buscar > ");
        long id = this.in.nextLong();

        Cliente cliente = this.controller.obtenerCliente(id);

        if (cliente != null) System.out.println(cliente);
    };

}
