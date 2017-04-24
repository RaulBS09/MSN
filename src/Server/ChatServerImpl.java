/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Client.ChatClientInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;

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
                
                clientesConectados.put(cliente.getNombre(), cliente);   //Se añade a los clientesConectados
                clientesConectados.forEach((k, v) -> {
                    try {
                        clientesConectados.get(k).getNombre();
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

    @Override
    public boolean registro(String idUsuario, String password, ChatClientInterface client) {
        try {
            ConexionBD.testDriver();
            ConexionBD con=new ConexionBD();
            
            Connection c = con.obtenerConexion("localhost:3306", "tiendaDAWA");
            //Fijamos el nivel de aislamiento de la BD
            c.setTransactionIsolation(4);
            con.ejecutarOperacion("INSERT INTO usuarios VALUES('"+idUsuario+"','"+password+"');");
            c.close();
            con.cerrarConexion();
            register(client);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean login(String idUsuario, String password, ChatClientInterface client) {
        try {
            
            ConexionBD.testDriver();
            ConexionBD con=new ConexionBD();
            
            Connection c = con.obtenerConexion("localhost:3306", "tiendaDAWA");
            
            ResultSet rs;
            //Fijamos el nivel de aislamiento de la BD
            c.setTransactionIsolation(2);
            
            rs=con.ejecutarConsulta("SELECT * FROM usuarios WHERE idUsuario='"+idUsuario+"';");
            
            if(rs.next()){
                if(password.equals(rs.getString("password"))){
                    register(client);
                }
                
            }
            rs.close();
            c.close();
            con.cerrarConexion();
            
            
        } catch (Exception ex) {
            Logger.getLogger(ChatServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean changePass(String idUsuario, String oldPass, String newPass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
