package view;

import controller.TurnoController;
import model.menu.IMenuCall;
import model.menu.Menu;
import model.menu.MenuItem;
import model.utilitarios.ListBuilder;

import java.time.LocalDate;
import java.util.Scanner;

public class TurnoView {

    private TurnoController controller;
    private Scanner in;

    public TurnoView() {
        this.controller = new TurnoController();
        this.in = new Scanner(System.in);
        this.run();
    }

    public void run() {
        System.out.println("");
        Menu menu = new Menu(
                new ListBuilder<MenuItem>()
                        .add(new MenuItem("Generar turnos", generar))
                        .add(new MenuItem("Agendar cita", agendarCita))
                        .build(), "Turnos");

        menu.iniciar();
    }

    private final IMenuCall generar = () -> {
        System.out.println("Generando turnos, espere por favor...");
        this.controller.generarTurnos();
        System.out.println("Turnos generados exitosamente!");
    };

    private final IMenuCall agendarCita = () -> {
        System.out.print("Codigo del CAJERO > ");
        long codigoCajero = this.in.nextLong();
        System.out.print("Codigo del CLIENTE > ");
        long codigoCliente = this.in.nextLong();
        LocalDate fecha = LocalDate.now();
        System.out.println("Fecha del turno CLIENTE > " + fecha);

        this.controller.agendarCita(codigoCajero, codigoCajero, fecha);
    };

}
