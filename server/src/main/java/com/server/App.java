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
            int cont = 0;
            int rnd = -1;
            while(true){
                Socket s = server.accept();
            
                System.out.println("Un client si è connesso");
                
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
    
                System.out.println("CREATI STREAM DI INPUT E OUTPUT");
                
                String stringa = in.readLine();
                System.out.println("STRINGA LETTA: " + stringa + "\nINVIATA DA: " + s.getInetAddress());
    
                if(stringa.equals("closeserver")){
                    System.out.println("SERVER TERMINATO");
                    out.writeBytes("closed");
                    s.close();
                    break;
                }
                int n;
                try {
                    n = Integer.parseInt(stringa);
                } catch (Exception e) {
                    out.writeBytes(e.getMessage());
                    continue;
                }
                
                if(cont == 0)
                    rnd = (int)(Math.random()*10);

                System.out.println("random is " + rnd);

                cont++;

                if(n < rnd){
                    out.writeBytes("1\n");
                }
                else if(n > rnd){
                    out.writeBytes("2\n");
                }
                else if(n == rnd){
                    out.writeBytes("3#" + cont + "\n");
                    out.writeBytes(cont + "\n");
                    cont = 0;
                }
            
            }
          
            server.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("ERRORE IN SERVER");
            System.exit(1);
        }
    }
}
