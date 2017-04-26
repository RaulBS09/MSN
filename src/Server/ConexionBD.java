package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
        private Connection con;
    
    protected static void testDriver() throws Exception{
	try{
            Class.forName ("com.mysql.jdbc.Driver");
            System.out.println ( "Encontrado el driver de MySQL" );
        }catch(java.lang.ClassNotFoundException e){
            System.out.println("MySQL JDBC Driver no encontrado ... ");
            throw (e);
        }
    }
    
    protected Connection obtenerConexion (String host, String database) throws Exception{
    	String url = "";
        
	try{
            url = "jdbc:mysql://" + host + "/" + database;
            
            /*Aqui cada uno pondrá el usuario y contraseña que tenga en mysql*/
            this.con = DriverManager.getConnection(url, "root", "root");
            System.out.println("Conexion establecida con " + url + "...");	    
            return this.con;
        }catch (SQLException e){
            System.out.println("Conexion NO establecida con " + url);
            throw (e);
        }
    }
    
    protected void ejecutarOperacion (String sqlStatement) throws Exception{    
	try{
            Statement s = this.con.createStatement();
            s.execute (sqlStatement);      		
            s.close ( );
        }catch (SQLException e){
            System.out.println ("Error ejecutando sentencia SQL");
            throw (e);
        }
    }
    
    protected ResultSet ejecutarConsulta (String sqlStatement) throws Exception{    
	try{
            ResultSet rs = null;
            Statement s = this.con.createStatement();
            rs = s.executeQuery(sqlStatement);  
            return rs;
        }catch (SQLException e){
            System.out.println ("Error ejecutando sentencia SQL");
            throw (e);
        }
    }
    
    public void cerrarConexion ()throws Exception {
	try{
            //Cerramos la conexión a la base de datos
            this.con.close();
	}catch (java.sql.SQLException e){
            System.out.println("Conexion mal cerrada");
            throw (e);
	}
    }
}
