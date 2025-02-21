/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

        int numero = 0;
        int i = 0;
        // Scelta del numero di client da accettare per la simulazione

        System.out.println("Da quanti client vuoi accettare la connessione? ");


        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );


        try {
            numero = Integer.parseInt(br.readLine());
            System.out.println("Ok, procediamo");
        } catch (IOException e) {
            System.err.println("Errore nell'inserimento del numero ");
        }


        while(i<numero){

            System.out.println("\n");
            System.out.println("Client num."+i);

            s.attendi();
            String messaggio = s.leggi();
            System.out.println("Messaggio del client: " + messaggio);
            s.invia("yo man");
            s.chiudi();
            i++;
        }

        System.out.println("\n");
        s.termina();
    }
    
}
