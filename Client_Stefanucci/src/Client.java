
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alessandro Stefanucci
 */
public class Client {
    
    String nome;
    String colore;
    Socket socket;
    
    
    public Client(String nome){
        this.nome = nome;
        
    }
    
    public Client(String nome, String colore){
        this.nome = nome;
        this.colore = colore;
        
    }
    
    public void connetti(String nomeServer, int portaServer) {

        try {
            socket = new Socket(nomeServer, portaServer);
            System.out.println("1) Connessione con il server avvenuta");
        } catch (ConnectException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore nella connessione col server");
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore nella risoluzione del nome del server");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore nello stabilimento della connessione con il server");

        }
    }
    
    
    public void scrivi(){
    
    
    }
    
    public void leggi(){
    
    
    }

    public void chiudi() {

        if (socket != null) {
            try {
                socket.close();
                System.out.println("2) Chiusura del DataSocket avvenuta con successo");
            } catch (IOException e) {
                System.err.println("Errore nella chiusura del socket");
            }
        }else{
            System.err.println("Il socket non può essere chiuso in quanto non è stato istanziato");
        }
    }
    
}
