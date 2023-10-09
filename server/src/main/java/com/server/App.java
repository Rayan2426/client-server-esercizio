package com.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class App 
{
    public static void main( String[] args )
    {
        try {
            System.out.println("SERVER AVVIATO");
            ServerSocket server = new ServerSocket(3000);
            
            Socket s = server.accept();
            
            System.out.println("Un client si è connesso");
            
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            System.out.println("CREATI STREAM DI INPUT E OUTPUT");
            
            String stringa = in.readLine();
            System.out.println("STRINGA LETTA: " + stringa);


            stringa = stringa.toUpperCase();

            out.writeBytes(stringa + "\n");
            System.out.println("STRINGA MODIFICATA INVIATA");
            
            server.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("ERRORE IN SERVER");
            System.exit(1);
        }
    }
}
