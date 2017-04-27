/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Client.ChatClientInterface;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author raulbrun
 */
public interface ChatServerInterface extends Remote {
    
    public boolean comprobarAmigos(String idUsuario, String idAmigo) throws java.rmi.RemoteException;
    public boolean register (ChatClientInterface cliente) throws java.rmi.RemoteException;
    public void unRegister (ChatClientInterface cliente) throws java.rmi.RemoteException;
    
    public boolean registro (String nombre, String clave, ChatClientInterface client) throws java.rmi.RemoteException;
    public HashMap<String, ChatClientInterface> login(String idUsuario, String password, ChatClientInterface client) throws java.rmi.RemoteException;;
    public boolean bajaUsuario (String nombre, String clave) throws java.rmi.RemoteException;
    
    public boolean envioPeticionAmistad(String origen, String destino) throws java.rmi.RemoteException;
    public boolean aceptarPeticion(String origen, String destino) throws java.rmi.RemoteException;
    public boolean rechazarPeticion(String origen, String destino) throws java.rmi.RemoteException;
    public ArrayList<String> getPeticiones(String nombre) throws java.rmi.RemoteException;
    public boolean changePass(String idUsuario, String oldPass, String newPass)throws java.rmi.RemoteException;
    public ArrayList<String> buscarUsuarios(String idUsuario, String nombre)throws java.rmi.RemoteException;
}
