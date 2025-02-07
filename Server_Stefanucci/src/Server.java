
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
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
    
    ServerSocket serverSocket = null;
    Socket clientSocket = null;
    int porta;
    
    public Server(int porta){
        
        this.porta=porta;
        try {
            serverSocket = new ServerSocket(porta);
            System.out.println("1) Server in ascolto sulla porta "+porta);
        } catch (BindException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore, porta già occupata");
        } catch (IllegalArgumentException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Errore, porta non esistente");
        }catch (SecurityException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore, la porta è protetta, non si hanno i permessi per accedere");
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

        OutputStream os;
        PrintWriter streamOut = null;
        String messaggioOut;

        try {
            os = clientSocket.getOutputStream();
        } catch (IOException e) {
            System.err.println("Errore nella creazione dell'OutputStream");
        }

    }
    
    public void leggi(){

        InputStream is;
        Scanner streamIn = null;
        String messaggioIn;

    }
    
    public void chiudi(){
        if(clientSocket != null){
            try {
                clientSocket.close();
                System.out.println("3) Chiusura del DataSocket (client) avvenuta con successo");
            } catch (IOException e) {
                System.err.println("Errore nella chiusura del clientSocket");
            }
        }else{
            System.err.println("Il clientSocket non può essere chiuso in quanto non è stato istanziato");
        }
    
    }
    
    public void termina(){
        if(serverSocket != null){
            try {
                serverSocket.close();
                System.out.println("4) Chiusura del DataSocket (server) avvenuta con successo, il server non accetta più connessioni");
            } catch (IOException e) {
                System.err.println("Errore nella chiusura del serverSocket");
            }
        }else{
            System.err.println("Il serverSocket non può essere chiuso in quanto non è stato istanziato");
        }
    
    }
    
}
