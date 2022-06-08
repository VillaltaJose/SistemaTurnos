package model;

import java.util.ArrayList;
import java.util.List;

public class Cajero extends Persona {

    private List<Turno> turnos;

    public Cajero() {
        super();
        this.turnos = new ArrayList<Turno>();
    }

    public Cajero(
            long id,
            String nombre,
            String apellido
    ) {
        super(id, nombre, apellido);
        this.turnos = new ArrayList<Turno>();
    }

    public void agregarTurno(Turno turno) {
        this.turnos.add(turno);
    }

    public List<Turno> getTurnos() {
        return this.turnos;
    }

    public int getNroTurnos() {
        return this.turnos.size();
    }

    public static Cajero fromPersona(Persona persona) {
        return new Cajero(
                persona.getId(),
                persona.getNombre(),
                persona.getApellido()
        );
    }

    public static List<Cajero> generarCajeros(int cantidad) {
        List<Persona> personas = Persona.generar(cantidad);
        List<Cajero> cajeros = new ArrayList<Cajero>();

        personas.forEach(p -> cajeros.add(Cajero.fromPersona(p)));

        return cajeros;
    }

    @Override
    public String toString() {
        return "Cajero{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", turnos_atendidos='" + getNroTurnos() + '\'' +
                '}';
    }

}
