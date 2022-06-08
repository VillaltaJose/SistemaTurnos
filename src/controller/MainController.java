package controller;

import model.Cajero;
import model.Cliente;
import model.Repository;

public class MainController {

    public MainController() { }

    public void generarClientes(int cantidad) {
        Repository.getInstance().clientes = Cliente.generarClientes(cantidad);
    }

    public void generarCajeros(int cantidad) {
        Repository.getInstance().cajeros = Cajero.generarCajeros(cantidad);
    }

}
