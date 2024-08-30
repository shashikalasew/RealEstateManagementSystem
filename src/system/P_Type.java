/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author USER
 */
public class P_Type {
    
     private int id;
    private String name;
    private String description;
    
    //create getters and setters
    public Integer getId()
    {
      return id;
    }
    
    public void setId(Integer ID)
    {
      this.id = ID;
    }
    
    public String getName()
    {
      return name;
    }
    
    public void setName(String NAME)
    {
      this.name = NAME;
    }
    
    public String getDescription()
    {
      return this.description;
    }
    
    public void setDescription(String DESCRIPTION)
    {
      this.description = DESCRIPTION;
    }
    
    //create the class constructors
    public P_Type(){}
    
    public P_Type(Integer ID,String NAME,String DESCRIPTION)
    {
      this.id = ID;
      this.name = NAME;
      this.description = DESCRIPTION;
    }
    
   //create a function to insert ,edit,remove type
    public boolean execTypeQuery(String queryType, P_Type type)
    {
      PreparedStatement ps;
      
      //add a new type
      if(queryType.equals("add"))
      {
          try {
              ps = DBConnection.getConnection().prepareStatement("INSERT INTO property_type(name, description) VALUES (?,?)");
              ps.setString(1, type.getName());
              ps.setString(2, type.getDescription());
              
              return (ps.executeUpdate()>0);
                  
              
          } catch (SQLException ex) {
              Logger.getLogger(P_Type.class.getName()).log(Level.SEVERE, null, ex);
              return false;
          }
      }
      
      //update a new type
      else if(queryType.equals("update"))
      {
          try {
              ps = DBConnection.getConnection().prepareStatement("UPDATE property_type SET name=?,description=? WHERE id=? ");
              ps.setString(1, type.getName());
              ps.setString(2, type.getDescription());
              ps.setInt(3, type.getId());
              
              return (ps.executeUpdate()>0);
                  
              
          } catch (SQLException ex) {
              Logger.getLogger(P_Type.class.getName()).log(Level.SEVERE, null, ex);
              return false;
          }
      }
      
      //remove a new type
      else if(queryType.equals("remove"))
      {
          try {
              ps = DBConnection.getConnection().prepareStatement("DELETE FROM property_type WHERE id=? ");
              ps.setInt(1, type.getId());
              
              return (ps.executeUpdate()>0);
                  
              
          } catch (SQLException ex) {
              Logger.getLogger(P_Type.class.getName()).log(Level.SEVERE, null, ex);
              return false;
          }
      }
      
      else{
          JOptionPane.showMessageDialog(null, "Select add,edit or remove", "Invalid operation", 2);
          return false;
      }
    }
    
    //create a function to return a list of all types in a hashmap
    public HashMap<String, Integer> getTypesMap(){
    
      HashMap<String, Integer> map = new HashMap<>();
      
      Statement st = null;
      ResultSet rs;
      
        try {
            st = DBConnection.getConnection().createStatement();
            rs = st.executeQuery("SELECT* FROM property_type");
            
            P_Type type;
            
            while(rs.next())
            {
              type = new P_Type(rs.getInt(1),rs.getString(2),rs.getString(3));
              
              map.put(type.getName(), type.getId());
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(P_Type.class.getName()).log(Level.SEVERE, null, ex);
        }
     
      return map;
    }
    
    //create a function to get a type data by id
    //we can use getTypesMap() function to get the id and name
    //but we want the description to
    public P_Type getTypeById(Integer id){
      
        PreparedStatement ps = null;
        ResultSet rs;
        
        P_Type type = new P_Type();

        try {
            ps = DBConnection.getConnection().prepareStatement("SELECT* FROM property_type WHERE id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.next())
            {
              type.setId(id);
              type.setName(rs.getString(2));
              type.setDescription(rs.getString(3));

            }
            
        }catch (SQLException ex) {
            Logger.getLogger(P_Type.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return type;
    }
    
            
}
