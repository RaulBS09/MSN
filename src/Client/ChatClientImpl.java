/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Client.Vista.vPrincipal;
import Server.ChatServerInterface;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author raulbrun
 */
public class ChatClientImpl extends UnicastRemoteObject implements ChatClientInterface{
    
    private String nombre;
    private String password;
    private ChatServerInterface servidor;
    private HashMap<String, ChatClientInterface> amigos;
    private HashMap<String, String> conversaciones;
    private vPrincipal panel;
    
    //CONSTRUCTOR
    public ChatClientImpl(String name, String passwd, ChatServerInterface servidor) throws RemoteException{
        super();
        nombre=name;
        password=passwd;
        this.servidor = servidor;
        amigos = new HashMap();
        conversaciones = new HashMap();
    }

    //GETTERS & SETTERS
    @Override
    public String getNombre() {
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

    
    public HashMap<String, ChatClientInterface> getAmigos(){
        return amigos;
    }
    @Override
    public void setAmigos(HashMap<String, ChatClientInterface> amigos) throws java.rmi.RemoteException{
        this.amigos = amigos;
    }
    
    @Override
    public void setPanel(vPrincipal vista){
        panel = vista;
    }
    //METODOS ----------------------------------------------------------------------------------------
    @Override
    public void textMe(String user, String msg) throws RemoteException {
        System.out.println(user + "dice: " + msg);
        String C = conversaciones.get(user);
        if(C != null){
            C = C + " \n -> " + msg;
            conversaciones.remove(user);
        }else{
            C = "-> " + msg;
        }
        conversaciones.put(user, C);
        panel.actualizaConversacion(user);
    }
    
    public String getConversacion(String amigo){
        return conversaciones.get(amigo);
    }
    
    public void enviarMensaje(String nombre, String msg) throws RemoteException{
        String C = conversaciones.get(nombre);
        if(C != null){
            C = C + " \n\t\t\t <- " + msg;
            conversaciones.remove(nombre);
        }else{
            C = "\n\t\t\t <-" + msg;
        }
        conversaciones.put(nombre, C);
        panel.actualizaConversacion(nombre);

        amigos.get(nombre).textMe(this.nombre, msg);
    }

    @Override
    public void notificarAmigoConectado(String idAmigo, ChatClientInterface amigo) {
        amigos.put(idAmigo, amigo);
        
        panel.newLogin(idAmigo);
    }

    @Override
    public void notificarAmigoDesconectado(String idAmigo) {
        if(amigos.containsKey(idAmigo)){
            amigos.remove(idAmigo);
            panel.actualizaAmigos();
        }
    }
    
    @Override
    public boolean login() throws RemoteException{
        
        amigos = servidor.login(nombre, password, this);
        
        return amigos != null;
        
    }

    @Override
    public void envioArchivo(String file, byte[] data, int tam) throws RemoteException {
        try {
            File f = new File(file);
            f.createNewFile();
            FileOutputStream out = new FileOutputStream(f, true);
            
            out.write(data, 0, tam);
            out.flush();
            out.close();
            System.out.println("Done writing data...");
        } catch (IOException ex) {
            Logger.getLogger(ChatClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
