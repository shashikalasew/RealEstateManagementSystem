/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author USER
 */
public class P_Owner {
    
    private int id;
    private String fname;
    private String lname;
    private String phone;
    private String email;
    private String address;
    
    public int getId()
    {
      return this.id;
    }
    
    public void setId(int id)
    {
      this.id = id;
    }
    
    public String getFname()
    {
      return this.fname;
    }
    
    public void setFname(String fname)
    {
      this.fname = fname;
    }
    
    public String getLname()
    {
      return this.lname;
    }
    
    public void setLname(String lname)
    {
      this.lname = lname;
    }
    
    public String getPhone()
    {
      return this.phone;
    }
    
    public void setPhone(String phone)
    {
      this.phone = phone;
    }
    
    public String getEmail()
    {
      return this.email;
    }
    
    public void setEmail(String email)
    {
      this.email = email;
    }
    
    public String getAddress()
    {
      return this.address;
    }
    
    public void setaddress(String address)
    {
      this.address = address;
    }
    
    public P_Owner(){}
    public P_Owner(int id, String fname, String lname, String phone, String email, String address ){
        
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        
    
    }
    
    //create a function to add a new owner
    public boolean addNewOwner(P_Owner owner){
        
        PreparedStatement ps;
        String addQuery = "INSERT INTO owners(fname,lname,phone,email,address) VALUES (?,?,?,?,?)";
        
        try {
            ps = DBConnection.getConnection().prepareStatement(addQuery);
            ps.setString(1, owner.getFname());
            ps.setString(2, owner.getLname());
            ps.setString(3, owner.getPhone());
            ps.setString(4, owner.getEmail());
            ps.setString(5, owner.getAddress());
            
            return (ps.executeUpdate()>0);
        
        } catch (SQLException ex) {
            Logger.getLogger(P_Owner.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //create a function to update the selected owner data
    public boolean updateOwnerData(P_Owner owner){
    
        PreparedStatement ps;
        String updateQuery = "UPDATE owners SET fname=?,lname=?,phone=?,email=?,address=? WHERE id=?";
        
        try {
            ps = DBConnection.getConnection().prepareStatement(updateQuery);
            ps.setString(1, owner.getFname());
            ps.setString(2, owner.getLname());
            ps.setString(3, owner.getPhone());
            ps.setString(4, owner.getEmail());
            ps.setString(5, owner.getAddress());
            ps.setInt(6, owner.getId());
            
            return (ps.executeUpdate()>0);
        
        } catch (SQLException ex) {
            Logger.getLogger(P_Owner.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //create a function to delete the selected owner
    public boolean deleteOwner(int ownerId)
    {
        PreparedStatement ps;
        String deleteQuery = "DELETE FROM owners WHERE id=?";
        
        try {
            ps = DBConnection.getConnection().prepareStatement(deleteQuery);
            ps.setInt(1,ownerId);
            
            return (ps.executeUpdate()>0);
        
        } catch (SQLException ex) {
            Logger.getLogger(P_Owner.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //create a function to return an arraylist of owners
    public ArrayList<P_Owner> ownersList()
    {
        ArrayList<P_Owner> list = new ArrayList<>();
        
        Statement st;
        ResultSet rs;
        String selectQuery = "SELECT *FROM owners";
        
        try {
            st = DBConnection.getConnection().createStatement();
            rs = st.executeQuery(selectQuery);
            
            P_Owner owner;
            
            while(rs.next()){
                owner = new P_Owner(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(owner);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Owner.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
}
