package model;

import java.util.List;

public class Cajero extends Persona {

    private List<Turno> turnos;

    public void agregarTurno(Turno turno) {
        this.turnos.add(turno);
    }

}
