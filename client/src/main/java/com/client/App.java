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
        mates.put("/change","change");
        mates.put("close","close");


        //the value of the ip string is the ip of the server you want to connect to
        String ip = mates.get("local");
        String inp = "local";

        Scanner input = new Scanner(System.in);

        while (!ip.equals(mates.get("close"))) {
            
            try {
                if(inp.equals("/change")){

                    System.out.println("A CHI INVIARE MESSAGGIO?\n");
                    inp = input.nextLine();

                    if(!mates.containsKey(inp)){
                        inp = "local";
                        continue;
                    }

                    if(ip.equals("close"))
                        break;
                    

                    ip = mates.get(inp);
                }

                System.out.println("MESSAGGIO DA INVIARE A " + inp + " ( "+ ip +"):\n");

                String str = input.nextLine();


                if(!str.equals("/change")){

                    Socket mySocket = new Socket(ip, 3000);

                    BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
                    DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());

                    out.writeBytes(str+"\n");
                    System.out.println("STRINGA INVIATA\n");

                    String response = in.readLine();
                    System.out.println("STRING RICEVUTA: \n" + response);

                    mySocket.close();
                }
                else{
                    inp = "/change";
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                inp = "/change";
                System.out.println("ERRORE IN CLIENT\n");
            }
        }
        input.close();
    }
}
