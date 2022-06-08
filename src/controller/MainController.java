package controller;

import model.Cajero;
import model.Cliente;
import model.Repository;
import model.Turno;

import java.util.concurrent.TimeUnit;

public class MainController {

    public MainController() { }

    public void generarClientes(int cantidad) {
        Repository.getInstance().clientes = Cliente.generarClientes(cantidad);
    }

    public void generarCajeros(int cantidad) {
        Repository.getInstance().cajeros = Cajero.generarCajeros(cantidad);
    }

    private int getRandomBetween(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }

    private int getRandomCajero() {
        return this.getRandomBetween(0, Repository.getInstance().cajeros.size() - 1);
    }

    private int getRandomCliente() {
        return this.getRandomBetween(0, Repository.getInstance().clientes.size() - 1);
    }

    public void generarTurnos() {
        try {
            TimeUnit.SECONDS.sleep(this.getRandomBetween(2, 4));
        } catch (InterruptedException ex) { }

        int cantidad = this.getRandomBetween(10, 40);

        for (int i = 0; i < cantidad; i++) {
            int indexCajero = this.getRandomCajero();
            // Colocamos el tiempo de espera al cliente
            Repository.getInstance().clientes.get(this.getRandomCliente()).setTiempoEspera(this.getRandomBetween(5, 150));

            Turno turno = new Turno(
                    Repository.getInstance().cajeros.get(indexCajero),
                    Repository.getInstance().clientes.get(this.getRandomCliente())
            );
            turno.setTiempoAtencion(this.getRandomBetween(5, 100));

            Repository.getInstance().turnos.add(turno);
            Repository.getInstance().cajeros.get(indexCajero).getTurnos().add(turno);

        }
    }

}
