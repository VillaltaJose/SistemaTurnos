package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Repository {

    private static Repository instance = null;

    public List<Cliente> clientes;
    public List<Cajero> cajeros;
    public Queue<Turno> turnos;
    public List<Turno> citasAgendadas;

    private Repository() {
        this.clientes = new ArrayList<Cliente>();
        this.cajeros = new ArrayList<Cajero>();
        this.turnos = new LinkedList<Turno>();
        this.citasAgendadas = new ArrayList<Turno>();
    }

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }

        return instance;
    }

}
