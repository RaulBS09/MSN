/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Client.Vista.vPrincipal;
import java.rmi.Remote;
import java.util.HashMap;

/**
 *
 * @author raulbrun
 */
public interface ChatClientInterface extends Remote{
    
    public void textMe(String user, String msg) throws java.rmi.RemoteException;
    public void newLogin(String user) throws java.rmi.RemoteException;
    
    public String getNombre() throws java.rmi.RemoteException;
    public void setAmigos(HashMap<String, ChatClientInterface> amigos)  throws java.rmi.RemoteException;
    
    public void setPanel(vPrincipal vista) throws java.rmi.RemoteException;
}
