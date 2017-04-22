/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Server.ChatServerInterface;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import Client.Vista.*;
/**
 *
 * @author raulbrun
 */
public class ChatClient {
    
    public static void main(String args[]){
        try{
        
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String userName, passwd, op;
        
        ChatServerInterface h = (ChatServerInterface)Naming.lookup("rmi://localhost:2222/chat");
        
        VFrame cuadro = new VFrame();
        Login login = new Login(h, cuadro);
        cuadro.setContentPane(login);
        cuadro.setVisible(true);
        
        }catch(Exception ex){
            System.out.println("Exception in ChatClient:" + ex + " -> " + ex.getMessage());
        }
    }
}
