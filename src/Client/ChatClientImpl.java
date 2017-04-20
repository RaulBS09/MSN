/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author raulbrun
 */
public class ChatClientImpl extends UnicastRemoteObject implements ChatClientInterface{
    
    private String nombre;
    private String password;
    private HashMap<String, ChatClientInterface> amigos;
    
    public ChatClientImpl(String name, String passwd) throws RemoteException{
        super();
        nombre=name;
        password=passwd;
        amigos = new HashMap();
    }

    @Override
    public String getNombre() throws java.rmi.RemoteException{
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public HashMap<String, ChatClientInterface> getAmigos() throws java.rmi.RemoteException{
        return amigos;
    }
    @Override
    public void setAmigos(HashMap<String, ChatClientInterface> amigos) throws java.rmi.RemoteException{
        this.amigos = amigos;
    }

    @Override
    public void textMe(String user, String msg) throws RemoteException {
        System.out.println(user + "dice: " + msg);
    }
    
    
}
