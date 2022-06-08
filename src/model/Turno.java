package model;

import java.time.LocalDate;

public class Turno {

    private Cajero cajero;
    private Cliente cliente;
    private LocalDate fecha;
    private int tiempoAtencion; // en minutos

    public Turno(
            Cajero cajero,
            Cliente cliente
    ) {
        this.cajero = cajero;
        this.cliente = cliente;
        this.fecha = LocalDate.now();
    }

    public Turno(
            Cajero cajero,
            Cliente cliente,
            LocalDate fecha
    ) {
        this.cajero = cajero;
        this.cliente = cliente;
        this.fecha = fecha;
    }

    public void setTiempoAtencion(int tiempoAtencion) {
        this.tiempoAtencion = tiempoAtencion;
    }

    public Cajero getCajero() {
        return this.cajero;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public int getTiempoAtencion() {
        return this.tiempoAtencion;
    }

}
