package Utilerias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Clase que establece el medio de comunicaci�n con la base de datos hecha en
 * Oracle
 */
public class ConexionSybase {

    private static String ipAddress;
    private static String dbName;
    private static String user;
    private static String password;
    private static String portservice;
    private static ResourceBundle propertiesConexion;

    /**
     * Metodo que carga el driver, establece la conexi�n.
     *
     * @ return Connection
     *
     */
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.sybase.jdbc.SybDriver");
            //Class.forName("net.sourceforge.jtds.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (propertiesConexion == null) {
            propertiesConexion = ResourceBundle.getBundle("sql_properties");
            ipAddress = propertiesConexion.getString("ip_address");
            dbName = propertiesConexion.getString("db_name");
            user = propertiesConexion.getString("user");
            password = propertiesConexion.getString("password");
            portservice = propertiesConexion.getString("port_service");
        }
        //return DriverManager.getConnection("jdbc:jtds:sybase://" + ipAddress + ":" + portservice + "/" + dbName, user, password);
        return DriverManager.getConnection("jdbc:sybase:Tds:" + ipAddress + ":" + portservice + "/" + dbName, user, password);
    }

    public static void main(String[] args) {
        try {
            Connection con = getConnection();
            System.out.println("Conexion efectuada..." + con);
            con.close();
        } catch (SQLException e) {
            System.out.println("<<" + e);
        }
    }
}
