/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import model.Cliente;

/**
 *
 * @author josevillalta
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Cliente cliente = new Cliente(1, "", "");

        cliente.generar(20).forEach(System.out::println);

    }
    
}
