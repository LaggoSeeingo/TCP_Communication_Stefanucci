
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
public class Server {
    
    ServerSocket serverSocket;
    Socket clientSocket;
    int porta;
    
    public Server(int porta){
        
        this.porta=porta;
        try {
            serverSocket = new ServerSocket(porta);
            System.out.println("1) Server in ascolto sulla porta "+porta);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore del server nella fase di ascolto");
        }
        
    }
    
    public Socket attendi(){
    
        try {
            clientSocket = serverSocket.accept();
            System.out.println("2) Connessione con il client avvenuta, DataSocket creato");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore nella connessione con il client");
        }
        
        return clientSocket;
    }
    
    public void invia(){
    
    
    }
    
    public void leggi(){
    
    
    }
    
    public void chiudi(){
    
    
    }
    
    public void termina(){
    
    
    }
    
}
