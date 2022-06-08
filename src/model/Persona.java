package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Persona {

    public long id;
    public String nombre;
    public String apellido;

    public Persona() { }

    public Persona(long id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Persona> generar(int cantidad) {
        List<String> nombres = obtenerNombresJson();
        List<String> apellidos = obtenerApellidosJson();

        Random rand = new Random();

        List<Persona> personas = new ArrayList<Persona>();

        for (int i = 0; i < cantidad; i++) {
            personas.add(new Persona(i + 1,
                    nombres.get(rand.nextInt(nombres.size())),
                    apellidos.get(rand.nextInt(apellidos.size()))
            ));
        }

        return personas;
    }

    private List<String> obtenerNombresJson() {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("src/names.json"));

            List<String> nombres = gson.fromJson(reader, new TypeToken<List<String>>() {}.getType());

            reader.close();

            return nombres;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<String>();
        }
    }

    private List<String> obtenerApellidosJson() {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("src/lastnames.json"));

            List<String> nombres = gson.fromJson(reader, new TypeToken<List<String>>() {}.getType());

            reader.close();

            return nombres;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<String>();
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

}
