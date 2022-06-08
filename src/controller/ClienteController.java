package controller;

import model.Cliente;
import model.Repository;

import java.util.List;

public class ClienteController {

    public ClienteController() { }

    public List<Cliente> obtenerClientes() {
        return Repository.getInstance().clientes;
    }

    public void ordenarNombre() {
        Repository.getInstance().clientes = Repository.getInstance().clientes.stream()
                .sorted((c1, c2) -> c1.getNombre().compareToIgnoreCase(c2.getNombre()))
                .toList();
    }

    public void ordenarApellido() {
        Repository.getInstance().clientes = Repository.getInstance().clientes.stream()
                .sorted((c1, c2) -> c1.getApellido().compareToIgnoreCase(c2.getApellido()))
                .toList();
    }

    public void ordenarTiempoEspera() {
        Repository.getInstance().clientes = Repository.getInstance().clientes.stream()
                .sorted((c1, c2) -> Integer.compare(c1.getTiempoEspera(), c2.getTiempoEspera()))
                .toList();
    }

    public Cliente obtenerCliente(long id) {
        return Repository.getInstance().clientes.stream().filter(c -> c.getId() == id).findFirst().get();
    }

}
