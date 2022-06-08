/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import model.Cliente;
import model.menu.Menu;
import model.menu.MenuItem;
import model.utilitarios.ListBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josevillalta
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Menu menu = new Menu(new ListBuilder<MenuItem>()
            .add(new MenuItem("Imprimir mensaje", () -> System.out.println("Mensaje")))
            .add(new MenuItem("Imprimir mensaje 2", () -> System.out.println("nuevo mensaje")))
        .build());

        menu.iniciar();

    }
    
}
