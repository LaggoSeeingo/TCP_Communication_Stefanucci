/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Alessandro Stefanucci
 */
public class main_client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Client c = new Client("HostName");
        c.connetti("localhost",2000);
        c.scrivi("yo bro");
        String risposta = c.leggi();
        System.out.println("Risposta del server: " + risposta);
        c.chiudi();
    }
    
}
