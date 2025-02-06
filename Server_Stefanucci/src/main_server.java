/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Alessandro Stefanucci
 */
public class main_server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Server s = new Server(2000);
        s.attendi();
        s.chiudi();
        s.termina();
    }
    
}
