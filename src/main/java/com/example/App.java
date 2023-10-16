package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class App 
{
    public static void main( String[] args )
    {
        try {
            Socket s = new Socket("localhost", 6790);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            BufferedReader inServ = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String stringaServer;
            int n = 0;
            do {
                n++;
                System.out.println("inserisci numero: ");
                String st = in.readLine();
                out.writeBytes(st + '\n');
                stringaServer = inServ.readLine();
                if (stringaServer.equals("1"))
                {
                    System.out.println("il numero da indovinare è piu basso.");
                }
                if (stringaServer.equals("2"))
                {
                    System.out.println("il numero da indovinare è piu alto.");
                }
                if(stringaServer.equals("4"))
                {
                    System.out.println("devi inserire un numero compreso tra 0 e 99");
                    n--;
                }
            } while (Integer.parseInt(stringaServer)!= 3);
            if(n == 1)
            {
                System.out.println("hai indovinato in 1 tentativo, sei un figo ;)");
            }
            else{
                System.out.println("hai indovinato, ci hai messo " + n + " tentativi, non sei un figo :(");
            }
            s.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("errore durante la comunicazione!");
            System.exit(1);
        }
    }
}