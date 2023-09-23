/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//First step-Making the Singleton connection; Make sure only one object make from this connection
package pos.layered.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kavindu
 */
public class DbConnection {
    private static DbConnection dbConnection; //can access for dbConnection without any object
    private Connection connection;
    
    //using private constructor not allows to create any other constructors apart from this
    private DbConnection(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/pos-mvc","root","1174Kavindu@");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    public static DbConnection getInstance(){
        if(dbConnection == null){
            dbConnection = new DbConnection(); //at here make sures only one db connection has created
        }
        return dbConnection;
    }
    
    public Connection getConnection(){
        return connection;
    }
    
}
