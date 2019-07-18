/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author moon
 */
public class Client {
    public static void main(String[] args){
        try{
            Socket socket = new Socket("localhost",8091);
            System.out.println("Enter a Number: ");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
            pw.println(input);
            
            
            
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String result = bufferedReader.readLine();
            System.out.println("!"+input + " = " + result);
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
