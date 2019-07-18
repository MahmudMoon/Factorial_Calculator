/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author moon
 */
public class Server {

    public static void main(String[] args) {
        try{
            System.out.println("Server is Ready : ");
            ServerSocket ss = new ServerSocket(8091);
            Socket socket = ss.accept();
            System.out.println("GOT NEW CLIENT");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String value  = bufferedReader.readLine();
            System.out.println("VAlue " + value);
            int number = Integer.parseInt(value);
            int num = 1;
            for(int i=number ;i>=1;i--){
                num*=i;
            }
            PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
            String output = String.valueOf(num);
            pw.println(output);
            
            
            
        }catch(IOException e ){
            e.printStackTrace();
        }
    }
    
}
