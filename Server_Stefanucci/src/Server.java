
import java.io.*;
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

    private BufferedReader in;
    private BufferedWriter out;

    
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
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            System.out.println("2) Connessione con il client avvenuta, DataSocket creato");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore nella connessione con il client");
        }
        
        return clientSocket;
    }
    
    public void invia(String messaggio){

        try {
            out.write(messaggio);
            out.newLine();
            out.flush();
        } catch (IOException e) {
            System.err.println("Errore nella scrittura");
        }

    }
    
    public String leggi(){

        try {
            return in.readLine();
        } catch (IOException e) {
            System.err.println("Errore nella lettura");
            return null;
        }

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
