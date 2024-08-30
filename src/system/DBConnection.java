/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system;

import java.sql.DriverManager;
import java.sql.Connection;
import javax.swing.JOptionPane;
/**
 *
 * @author USER
 */
public class DBConnection {
    
    public static Connection getConnection()
    {
      Connection con = null;
      
      try{
     Class.forName("com.mysql.cj.jdbc.Driver");
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/realstate_db", "root", "");
     }
     catch(Exception e){
     JOptionPane.showMessageDialog(null, e);
     
     }
     return con;
    }
}
