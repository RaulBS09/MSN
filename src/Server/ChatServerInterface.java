/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Client.ChatClientInterface;
import java.rmi.Remote;

/**
 *
 * @author raulbrun
 */
public interface ChatServerInterface extends Remote {
    
    public boolean register (ChatClientInterface cliente) throws java.rmi.RemoteException;
    public void unRegister (ChatClientInterface cliente) throws java.rmi.RemoteException;
    
    public boolean registro (String nombre, String clave) throws java.rmi.RemoteException;
    public boolean bajaUsuario (String nombre, String clave) throws java.rmi.RemoteException;
    
    public boolean envioPeticionAmistad(String origen, String destino) throws java.rmi.RemoteException;
    public void aceptarPeticion(String origen, String destino) throws java.rmi.RemoteException;
    public void rechazarPeticion(String origen, String destino) throws java.rmi.RemoteException;
}
