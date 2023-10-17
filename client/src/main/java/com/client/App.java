package com.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        HashMap<String,String> mates = new HashMap<>();
        mates.put("pavlov","10.22.9.1");
        mates.put("didi","10.22.9.2");
        mates.put("falli","10.22.9.3");
        mates.put("masi","10.22.9.4");
        mates.put("mohd","10.22.9.5");
        mates.put("socci","10.22.9.6");
        mates.put("molla","10.22.9.7");
        mates.put("rettori","10.22.9.8");
        mates.put("bernat","10.22.9.9");
        mates.put("yasser","10.22.9.10");
        mates.put("grandi","10.22.9.11");
        mates.put("gonza","10.22.9.12");
        mates.put("taiti","10.22.9.13");
        mates.put("singh","10.22.9.14");
        mates.put("ardi","10.22.9.15");
        mates.put("spagni","10.22.9.16");
        mates.put("skorz","10.22.9.17");
        mates.put("aldi","10.22.9.18");
        mates.put("local","localhost");
        mates.put("close","close");

        String ip = mates.get("local");

        Scanner input = new Scanner(System.in);

        while (!ip.equals(mates.get("close"))) {
            
            try {

                System.out.println("A CHI INVIARE MESSAGGIO?\n");

                //the value of the ip string is the ip of the server you want to connect to
                String str = input.nextLine();

                if(!mates.containsKey(str))
                    continue;

                if(ip.equals("close"))
                    break;

                ip = mates.get(str);

                System.out.println("MESSAGGIO DA INVIARE A " + str + " ( "+ ip +"): ");

                str = input.nextLine();

                Socket mySocket = new Socket(ip, 3000);

                BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());

                out.writeBytes(str+"\n");
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
        input.close();
    }
}
