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
public class P_Client {
    
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
    
    public P_Client(){}
    public P_Client(int id, String fname, String lname, String phone, String email, String address ){
        
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        
    
    }
    
    //create a function to add a new client
    public boolean addNewClient(P_Client client){
        
        PreparedStatement ps;
        String addQuery = "INSERT INTO clients(fname,lname,phone,email,address) VALUES (?,?,?,?,?)";
        
        try {
            ps = DBConnection.getConnection().prepareStatement(addQuery);
            ps.setString(1, client.getFname());
            ps.setString(2, client.getLname());
            ps.setString(3, client.getPhone());
            ps.setString(4, client.getEmail());
            ps.setString(5, client.getAddress());
            
            return (ps.executeUpdate()>0);
        
        } catch (SQLException ex) {
            Logger.getLogger(P_Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //create a function to update the selected client data
    public boolean updateClientData(P_Client client){
    
        PreparedStatement ps;
        String updateQuery = "UPDATE clients SET fname=?,lname=?,phone=?,email=?,address=? WHERE id=?";
        
        try {
            ps = DBConnection.getConnection().prepareStatement(updateQuery);
            ps.setString(1, client.getFname());
            ps.setString(2, client.getLname());
            ps.setString(3, client.getPhone());
            ps.setString(4, client.getEmail());
            ps.setString(5, client.getAddress());
            ps.setInt(6, client.getId());
            
            return (ps.executeUpdate()>0);
        
        } catch (SQLException ex) {
            Logger.getLogger(P_Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //create a function to delete the selected client
    public boolean deleteClient(int clientId)
    {
        PreparedStatement ps;
        String deleteQuery = "DELETE FROM clients WHERE id=?";
        
        try {
            ps = DBConnection.getConnection().prepareStatement(deleteQuery);
            ps.setInt(1,clientId);
            
            return (ps.executeUpdate()>0);
        
        } catch (SQLException ex) {
            Logger.getLogger(P_Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //create a function to return an arraylist of clients
    public ArrayList<P_Client> clientList()
    {
        ArrayList<P_Client> list = new ArrayList<>();
        
        Statement st;
        ResultSet rs;
        String selectQuery = "SELECT *FROM clients";
        
        try {
            st = DBConnection.getConnection().createStatement();
            rs = st.executeQuery(selectQuery);
            
            P_Client client;
            
            while(rs.next()){
                client = new P_Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(client);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
}
