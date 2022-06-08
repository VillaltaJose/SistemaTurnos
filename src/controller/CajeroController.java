package controller;

import model.Cajero;
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

}
