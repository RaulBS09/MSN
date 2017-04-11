/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author raulbrun
 */
public class ChatServer {
    
    public static void main(String args[]) {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String portNum, registryURL;
        try{     
          
          startRegistry(2222);
          ChatServerImpl exportedObj = new ChatServerImpl();
          registryURL = 
            "rmi://localhost:2222/chat";
          Naming.rebind(registryURL, exportedObj);
          System.out.println("Callback Server ready.");
          
        }// end try
        catch (Exception re) {
          System.out.println(
            "Exception in ChatServer.main: " + re + " -> " + re.getMessage());
        }
    }
    
    private static void startRegistry(int RMIPortNum)
        throws RemoteException{
        try {
          Registry registry = 
            LocateRegistry.getRegistry(RMIPortNum);
          registry.list( );  
            // This call will throw an exception
            // if the registry does not already exist
        }
        catch (RemoteException e) { 
          // No valid registry at that port.
          Registry registry = 
            LocateRegistry.createRegistry(RMIPortNum);
        }
  } // end startRegistry
}
