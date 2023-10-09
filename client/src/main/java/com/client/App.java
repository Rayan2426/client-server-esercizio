package com.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class App 
{
    public static void main( String[] args )
    {
        try {
            Socket mySocket = new Socket("10.22.9.6", 3000);

            BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());

            out.writeBytes("ciao mamma guarda come mi diverto\n");
            System.out.println("STRINGA INVIATA");

            String response = in.readLine();
            System.out.println("STRINGA MODIFICATA RICEVUTA: " + response);

            System.out.println(response);

            mySocket.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("ERRORE IN CLIENT");
        }
    }
}
