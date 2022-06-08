package controller;

import model.Cajero;
import model.Cliente;
import model.Repository;

import java.util.List;

public class CajeroController {

    public CajeroController() {

    }

    public List<Cajero> obtenerCajeros() {
        return Repository.getInstance().cajeros;
    }

    public void ordenar() {
        Repository.getInstance().cajeros = Repository.getInstance().cajeros.stream()
            .sorted((c1, c2) -> Integer.compare(c2.getNroTurnos(), c1.getNroTurnos()))
            .toList();
    }

    public Cajero obtenerCajero(long id) {
        return Repository.getInstance().cajeros.stream().filter(c -> c.getId() == id).findAny().orElse(null);
    }

    public Cajero obtenerCajero(String nombre) {
        return Repository.getInstance().cajeros.stream().filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .findAny().orElse(null);
    }

}
