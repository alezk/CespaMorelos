/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * Autor: ITI.Alejandro Rivera Figueroa
 * Asignatura: Aplicaciones Web
 * Unidad: Dos
 * Fecha: Octubre - 2012
 * 
 * Clase Java de conexión sql
 */
package Utilerias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author ITI.Alejandro Rivera Figueroa
 */
public class ConexionSql {

    private static String ipAddress;
    private static String dbName;
    private static String user;
    private static String password;
    private static String portservice;
    private static ResourceBundle propertiesConexion;

    public static Connection getConnection() throws SQLException {
        try {

            /*
             * Se coloca el driver jdbc para la conexión sql server 2012            
             */

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /*
         * Se obtienen las propiedades de conexión del properties sql_properties.properties
         */

        if (propertiesConexion == null) {
            propertiesConexion = ResourceBundle.getBundle("sql_properties");
            ipAddress = propertiesConexion.getString("ip_address");
            dbName = propertiesConexion.getString("db_name");
            user = propertiesConexion.getString("user");
            password = propertiesConexion.getString("password");
            portservice = propertiesConexion.getString("port_service");
        }


        /*
        
         *Se indica la url jdbc de la conexión sql server 2012
         * 
         *Ejemplos de url jdbc de conexión 
         * 
         * jdbc:sqlserver://nameHots:port;databaseName='';user='';password=''
         * 
         * jdbc:sqlserver://nameHots;databaseName='';user='';password=''
         * 
         * Cualquira de las url jdbc pueden ser implementadas
        
         */

        return DriverManager.getConnection("jdbc:sqlserver://" + ipAddress + ":" + portservice + ";databaseName=" + dbName, user, password);
    }

    /*
     * 
     * Metodo main para relizar pruebas a la conexión sql server 2012    
     */
    
    /*
     * 
    public static void main(String[] args) throws SQLException {

        Connection con = getConnection();
        System.out.println("Conexión Exitosa..." + con);
        con.close();

    }
     * 
     */
}
