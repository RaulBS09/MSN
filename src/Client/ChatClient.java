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
        
        
        System.out.println("Introduzca su nombre de usuario:");
        userName = (br.readLine()).trim();
        System.out.println("Introduzca su contraseña:");
        passwd = (br.readLine()).trim();
        
        ChatServerInterface h = (ChatServerInterface)Naming.lookup("rmi://localhost:2222/chat");
        ChatClientInterface cliente = new ChatClientImpl(userName, passwd);
        
        if(h.register(cliente)){
            System.out.println("Ha ido to bien.");
            System.out.println("Mis amigos son: ");
            cliente.getAmigos().forEach((k, v) -> System.out.println("Key: " + k));
        }
        
        do{
            System.out.println("Que queres faser? (send / exit)");
            op = (br.readLine()).trim();
            if(op.equals("send")){
                System.out.println("A quen?");
                userName = (br.readLine()).trim();
                try{
                    cliente.getAmigos().get(userName).textMe(cliente.getNombre(), "Hola guapeton!");
                }catch(NullPointerException e){
                    op="null";
                    System.out.println("NullPointerException tratando de enviar a: " + userName);
                }
            }else if(op.equals("print")){
                System.out.println("Mis amigos son: ");
                cliente.getAmigos().forEach((k, v) -> System.out.println("Key: " + k));
            }
        }while(!op.equals("exit"));
        
        h.unRegister(cliente);
        }catch(Exception ex){
            System.out.println("Exception in ChatClient:" + ex + " -> " + ex.getMessage());
        }
    }
}
