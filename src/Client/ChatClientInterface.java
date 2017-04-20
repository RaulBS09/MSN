/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.rmi.Remote;
import java.util.HashMap;

/**
 *
 * @author raulbrun
 */
public interface ChatClientInterface extends Remote{
    
    public void textMe(String user, String msg) throws java.rmi.RemoteException;
    
    public String getNombre() throws java.rmi.RemoteException;
    public void setAmigos(HashMap<String, ChatClientInterface> amigos)  throws java.rmi.RemoteException;
    public HashMap<String, ChatClientInterface> getAmigos()  throws java.rmi.RemoteException;
}
