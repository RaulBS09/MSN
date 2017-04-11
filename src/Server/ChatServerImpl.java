/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Client.ChatClientInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
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
        if(!clientesConectados.containsKey(cliente.getNombre())){
            ArrayList<ChatClientInterface> amigos = new ArrayList();

            clientesConectados.entrySet().forEach((entry) -> { //Con esto se añaden todos los clientes conectados a la lista de amigos.
                amigos.add(entry.getValue());
                try {                                
                    entry.getValue().getAmigos().add(cliente);
                } catch (RemoteException ex) {
                    Logger.getLogger(ChatServerImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            clientesConectados.put(cliente.getNombre(), cliente);   //Se añade a los clientesConectados
            cliente.setAmigos(amigos);
            System.out.println(cliente.getNombre() + " ha iniciado sesión.");
            return true;
        }
        return false;
    }

    @Override
    public void unRegister(ChatClientInterface cliente) throws RemoteException {
        clientesConectados.remove(cliente.getNombre());
    }
}
