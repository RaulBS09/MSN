/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Client.ChatClientImpl;
import Client.ChatClientInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author raulbrun
 */
public class ChatServerImpl extends UnicastRemoteObject implements ChatServerInterface{
    
    public HashMap<String, ChatClientInterface> clientesConectados; //Esta variable controlará todos los clientes conectados al servidor.
    
    public ChatServerImpl() throws RemoteException{
        super();
        clientesConectados = new HashMap();
    }

    @Override
    public boolean register(ChatClientInterface cliente) throws RemoteException {
        
        try{
            if(!clientesConectados.containsKey(cliente.getNombre())){
            
                /*Class.forName("com.mysql.jdbc.Driver");
                
	    	String url = "jdbc:mysql://localhost/chat";
      		Connection con = DriverManager.getConnection(url, "root", "root");*/
                
                clientesConectados.put(cliente.getNombre(), cliente);   //Se añade a los clientesConectados
                clientesConectados.forEach((k, v) -> {
                    try {
                        clientesConectados.get(k).setAmigos(clientesConectados);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ChatServerImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                System.out.println(cliente.getNombre() + " ha iniciado sesión.");
                return true;
            
        }
        }catch(Exception e){
            System.out.println("Excepcion en registro: "+ e);
        }
        return false;
    }

    @Override
    public void unRegister(ChatClientInterface cliente) throws RemoteException {
        clientesConectados.remove(cliente.getNombre());
    }
}
