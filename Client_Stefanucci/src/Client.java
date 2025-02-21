
import java.io.*;
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
    String colore = "\u001B[36m";
    String coloreErr = "\u001B[33m";
    static final String RESET = "\u001B[0m";
    Socket socket;

    private BufferedReader in;
    private BufferedWriter out;
    
    
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
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println(colore + "1) Connessione con il server avvenuta" + RESET);
        } catch (ConnectException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(coloreErr + "Errore nella connessione col server" + RESET);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(coloreErr + "Errore nella risoluzione del nome del server" + RESET);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(coloreErr + "Errore nello stabilimento della connessione con il server" + RESET);

        }
    }
    
    
    public void scrivi(String messaggio){

        try {
            out.write(colore + messaggio);
            out.newLine(); //terminatore riga
            out.flush();
        } catch (IOException e) {
            System.err.println(coloreErr + "Errore nella scrittura" + RESET);
        }

    
    }
    
    public String leggi(){

        try {
            return in.readLine();
        } catch (IOException e) {
            System.err.println(coloreErr + "Errore nella lettura" + RESET);
            return null;
        }

    }

    public void chiudi() {

        if (socket != null) {
            try {
                socket.close();
                System.out.println(colore + "2) Chiusura del DataSocket avvenuta con successo" + RESET);
            } catch (IOException e) {
                System.err.println(coloreErr + "Errore nella chiusura del socket" + RESET);
            }
        }else{
            System.out.println(coloreErr + "Il socket non può essere chiuso in quanto non è stato istanziato" + RESET);
        }
    }
    
}
