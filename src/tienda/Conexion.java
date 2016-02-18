/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Pablo
 */
public class Conexion {
    Connection conectar = null;
    
    
    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection("jdbc:mysql://localhost/electronicos","root","");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return conectar;
    }
}
