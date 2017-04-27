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
    public boolean comprobarAmigos(String idUsuario, String idAmigo){
        boolean resultado = false;
        try {
            ConexionBD.testDriver();
            ConexionBD con=new ConexionBD();
            
            try (Connection c = con.obtenerConexion("localhost:3306", "msn")) {
                ResultSet rs;
                //Fijamos el nivel de aislamiento de la BD
                c.setTransactionIsolation(2);
                
                rs=con.ejecutarConsulta("SELECT * FROM amigos WHERE (userId = '"+idUsuario+"' AND friendId = '"+idAmigo+"') OR (userId = '"+idAmigo+"' AND friendId = '"+idUsuario+"');");
                
                if(rs.next()){
                    resultado = true;
                }
                rs.close();
            }
            con.cerrarConexion();
        } catch (Exception ex) {
            Logger.getLogger(ChatServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    @Override
    public boolean register(ChatClientInterface cliente) throws RemoteException {
        
        try{
            if(!clientesConectados.containsKey(cliente.getNombre())){
                
                ;   //Se añade a los clientesConectados
                clientesConectados.forEach((k, v) -> {
                    try {
                        if( comprobarAmigos(cliente.getNombre(),k)){ 
                            v.notificarAmigoConectado(cliente.getNombre(), cliente);
                        }
                    } catch (RemoteException ex) {
                        Logger.getLogger(ChatServerImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                clientesConectados.put(cliente.getNombre(), cliente);
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
        clientesConectados.forEach((k, v) -> {
            try {
                if( v.getNombre().equals(cliente.getNombre())) v.notificarAmigoDesconectado(k);
            } catch (RemoteException ex) {
                Logger.getLogger(ChatServerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }

    @Override
    public boolean registro(String idUsuario, String password, ChatClientInterface client) {
        try {
            ConexionBD.testDriver();
            ConexionBD con=new ConexionBD();
            
            Connection c = con.obtenerConexion("localhost:3306", "msn");
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
    public HashMap<String, ChatClientInterface> login(String idUsuario, String password, ChatClientInterface client) {
        try {
            
            HashMap<String, ChatClientInterface> amigos = new HashMap();
            
            ConexionBD.testDriver();
            ConexionBD con=new ConexionBD();
            
            Connection c = con.obtenerConexion("localhost:3306", "msn");
            
            ResultSet rs;
            //Fijamos el nivel de aislamiento de la BD
            c.setTransactionIsolation(2);
            
            rs=con.ejecutarConsulta("SELECT * FROM usuarios WHERE idUsuario='"+idUsuario+"';");
            
            if(rs.next()){
                if(password.equals(rs.getString("password"))){
                    register(client);
                    clientesConectados.forEach((k, v) -> {
                        if( comprobarAmigos(idUsuario,k)) amigos.put(k, v);
                    });
                }
                else return null;
            }
            else return null;
            
            rs.close();
            c.close();
            con.cerrarConexion();
            
            return amigos;
            
            
        } catch (Exception ex) {
            Logger.getLogger(ChatServerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean changePass(String idUsuario, String oldPass, String newPass) {
        try {
            boolean resultado = false;
            ConexionBD.testDriver();
            ConexionBD con=new ConexionBD();
            
            Connection c = con.obtenerConexion("localhost:3306", "msn");
            
            ResultSet rs;
            //Fijamos el nivel de aislamiento de la BD
            c.setTransactionIsolation(2);
            
            rs=con.ejecutarConsulta("SELECT * FROM usuarios WHERE idUsuario='"+idUsuario+"';");
            
            if(rs.next()){
                if(oldPass.equals(rs.getString("password"))){
                    con.ejecutarOperacion("update usuarios set password=" + newPass + "where idUsuario=" + idUsuario +";");
                    resultado = true;
                }
                
            }
            rs.close();
            c.close();
            con.cerrarConexion();
            return resultado;
        } catch (Exception ex) {
            Logger.getLogger(ChatServerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean envioPeticionAmistad(String idEnvia, String idRecibe) {
        try {
            ConexionBD.testDriver();
            ConexionBD con=new ConexionBD();
            
            Connection c = con.obtenerConexion("localhost:3306", "msn");
            c.setTransactionIsolation(4);
            con.ejecutarOperacion("INSERT INTO peticiones VALUES('"+idEnvia+"','"+idRecibe+"');");
            c.close();
            con.cerrarConexion();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean bajaUsuario(String nombre, String clave) throws RemoteException {
        try {
            ConexionBD.testDriver();
            ConexionBD con=new ConexionBD();
            
            Connection c = con.obtenerConexion("localhost:3306", "msn");
            c.setTransactionIsolation(4);
            con.ejecutarOperacion("DELETE FROM usuarios WHERE idUsuario = '"+nombre+"' AND password = '"+clave+"';");
            c.close();
            con.cerrarConexion();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean aceptarPeticion(String origen, String destino) throws RemoteException {

        try {
            ConexionBD.testDriver();
            ConexionBD con=new ConexionBD();
            
            Connection c = con.obtenerConexion("localhost:3306", "msn");
            c.setTransactionIsolation(4);
            con.ejecutarOperacion("DELETE FROM peticiones WHERE userId = '"+origen+"' AND addressedId = '"+destino+"';");
            con.ejecutarOperacion("INSERT INTO amigos VALUES('"+origen+"','"+destino+"');");
            c.close();
            con.cerrarConexion();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ChatServerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }

    @Override
    public boolean rechazarPeticion(String origen, String destino) throws RemoteException {
        try {
            ConexionBD.testDriver();
            ConexionBD con=new ConexionBD();
            
            Connection c = con.obtenerConexion("localhost:3306", "msn");
            c.setTransactionIsolation(4);
            con.ejecutarOperacion("DELETE FROM peticiones WHERE userId = '"+origen+"' AND addressedId = '"+destino+"';");
            c.close();
            con.cerrarConexion();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public ArrayList<String> getPeticiones(String nombre) throws RemoteException {
        ArrayList<String> resultados = new ArrayList<>();
        try {
            ConexionBD.testDriver();
            ConexionBD con=new ConexionBD();
            
            Connection c = con.obtenerConexion("localhost:3306", "msn");
            ResultSet rs = null;
            
            //Fijamos el nivel de aislamiento de la BD
            c.setTransactionIsolation(2);
            rs=con.ejecutarConsulta("select * from peticiones where addressedId = '" + nombre +"';");
            while(rs.next()){
                resultados.add(rs.getString("userId"));
            }
            rs.close();
            c.close();
            con.cerrarConexion();
        } catch (Exception ex) {
            Logger.getLogger(ChatServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultados;
    }

    @Override
    public ArrayList<String> buscarUsuarios(String idUsuario, String nombre) {
        ArrayList<String> resultados = new ArrayList<>();
        try {
            ConexionBD.testDriver();
            ConexionBD con=new ConexionBD();
            
            Connection c = con.obtenerConexion("localhost:3306", "msn");
            ResultSet rs = null;
            
            //Fijamos el nivel de aislamiento de la BD
            c.setTransactionIsolation(2);
            rs=con.ejecutarConsulta("select * from usuarios where idUsuario like '%"+nombre+"%' AND not like '"+idUsuario+"';");
            while(rs.next()){
                resultados.add(rs.getString("idUsuario"));
            }
            rs.close();
            c.close();
            con.cerrarConexion();
        } catch (Exception ex) {
            Logger.getLogger(ChatServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultados;
    }
    
}
