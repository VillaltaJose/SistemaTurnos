package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cliente extends Persona {

    public Cliente() {
        super();
    }

    public Cliente(
            long id,
            String nombre,
            String apellido
    ) {
        super(id, nombre, apellido);
    }

    public static Cliente fromPersona(Persona persona) {
        return new Cliente(
                persona.getId(),
                persona.getNombre(),
                persona.getApellido()
        );
    }

    public static List<Cliente> generarClientes(int cantidad) {
        List<Persona> personas = Persona.generar(cantidad);
        List<Cliente> clientes = new ArrayList<Cliente>();

        personas.forEach(p -> clientes.add(Cliente.fromPersona(p)));

        return clientes;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                '}';
    }

}
