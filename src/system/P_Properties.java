/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JOptionPane;
/**
 *
 * @author USER
 */
public class P_Properties {
    
    private int id;
    private int type;
    private int size;
    private int ownerid;
    private String price;
    private String address;
    private int bedrooms;
    private int bathrooms;
    private int age;
    private boolean balcony;
    private boolean pool;
    private boolean backyard;
    private boolean garage;
    private String description ;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public boolean isBackyard() {
        return backyard;
    }

    public void setBackyard(boolean backyard) {
        this.backyard = backyard;
    }

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    public P_Properties(){}
    
    public P_Properties(int id ,int type, int size, int ownerid, String price, String address, int bedrooms, int bathrooms, int age,
                      boolean balcony, boolean pool, boolean backyard, boolean garage, String description)
    {
        this.id = id;
        this.type = type;
        this.size = size;
        this.ownerid = ownerid;
        this.price = price;
        this.address = address;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.age = age;
        this.balcony = balcony;
        this.pool = pool;
        this.backyard = backyard;
        this.garage = garage;
        this.description = description;
        
    }
    
    //create a function to add a new property
    public boolean addNewProperty(P_Properties property)
    {
        PreparedStatement ps;
        String addQuery = "INSERT INTO properties(type, square_feet, ownerid, price, address, bedrooms, bathrooms, age, balcony, pool, backyard, garage, description) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            ps = DBConnection.getConnection().prepareStatement(addQuery);
            ps.setInt(1, property.getType());
            ps.setInt(2, property.getSize());
            ps.setInt(3, property.getOwnerid());
            ps.setString(4, property.getPrice());
            ps.setString(5, property.getAddress());
            ps.setInt(6, property.getBedrooms());
            ps.setInt(7, property.getBathrooms());
            ps.setInt(8, property.getAge());
            ps.setBoolean(9, property.isBalcony());
            ps.setBoolean(10, property.isPool());
            ps.setBoolean(11, property.isBackyard());
            ps.setBoolean(12, property.isGarage());
            ps.setString(13, property.getDescription());
            
            return(ps.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Properties.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    //create a function to update a selected property
    public boolean updateProperty(P_Properties property)
    {
        PreparedStatement ps;
        String updateQuery = "UPDATE properties SET type=?, square_feet=?, ownerid=?, price=?, address=?, bedrooms=?, bathrooms=?, age=?, balcony=?, pool=?, backyard=?, garage=?, description=? WHERE id=?";
        
        try {
            ps = DBConnection.getConnection().prepareStatement(updateQuery);
            ps.setInt(1, property.getType());
            ps.setInt(2, property.getSize());
            ps.setInt(3, property.getOwnerid());
            ps.setString(4, property.getPrice());
            ps.setString(5, property.getAddress());
            ps.setInt(6, property.getBedrooms());
            ps.setInt(7, property.getBathrooms());
            ps.setInt(8, property.getAge());
            ps.setBoolean(9, property.isBalcony());
            ps.setBoolean(10, property.isPool());
            ps.setBoolean(11, property.isBackyard());
            ps.setBoolean(12, property.isGarage());
            ps.setString(13, property.getDescription());
            ps.setInt(14, property.getId());
            
            return(ps.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Properties.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //create a function to delete a selected property
    public boolean removeProperty(int propertyid)
    {
        PreparedStatement ps;
        String deleteQuery = "DELETE * FROM properties WHERE id=?";
        
        try {
            ps = DBConnection.getConnection().prepareStatement(deleteQuery);
            ps.setInt(1,propertyid);
            
            return (ps.executeUpdate()>0);
        
        } catch (SQLException ex) {
            Logger.getLogger(P_Properties.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //create a function to search for a property by id
    public P_Properties searchProperty(int propertyid)
    {
        PreparedStatement ps;
        ResultSet rs;
        P_Properties property = null;
        
        String searchQuery = "SELECT * FROM properties WHERE id = ?";
        
        try {
            ps = DBConnection.getConnection().prepareStatement(searchQuery);
            ps.setInt(1, propertyid);
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                property = new P_Properties(rs.getInt("id"),
                                          rs.getInt("type"),
                                          rs.getInt("square_feet"),
                                          rs.getInt("Ownerid"),
                                          rs.getString("price"),
                                          rs.getString("address"),
                                          rs.getInt("bedrooms"),
                                          rs.getInt("bathrooms"),
                                          rs.getInt("age"),
                                          rs.getBoolean("balcony"),
                                          rs.getBoolean("pool"),
                                          rs.getBoolean("backyard"),
                                          rs.getBoolean("garage"),
                                          rs.getString("description"));
            }
            
            return property;
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Properties.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return property;
    }
    
    //create a function to return an arraylist of properties
    public ArrayList<P_Properties> propertyList()
    {
        ArrayList<P_Properties> list = new ArrayList();
        
        Statement st;
        ResultSet rs;
        String selectQuery = "SELECT *FROM properties";
        
        try {
            st = DBConnection.getConnection().createStatement();
            rs = st.executeQuery(selectQuery);
            
            P_Properties property;
            
            while(rs.next()){
                property = new P_Properties(rs.getInt("id"),
                                          rs.getInt("type"),
                                          rs.getInt("square_feet"),
                                          rs.getInt("Ownerid"),
                                          rs.getString("price"),
                                          rs.getString("address"),
                                          rs.getInt("bedrooms"),
                                          rs.getInt("bathrooms"),
                                          rs.getInt("age"),
                                          rs.getBoolean("balcony"),
                                          rs.getBoolean("pool"),
                                          rs.getBoolean("backyard"),
                                          rs.getBoolean("garage"),
                                          rs.getString("description"));
                list.add(property);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Properties.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    //create a function to return a list of property depending on the selected type
     public ArrayList<P_Properties> propertyListByType(int typeId)
     {
        ArrayList<P_Properties> list = new ArrayList<>();
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM properties WHERE type=?";
        
        try {
            ps = DBConnection.getConnection().prepareStatement(selectQuery);
            ps.setInt(1, typeId);
            rs = ps.executeQuery();
            
            P_Properties property;
            
            while(rs.next()){
                property = new P_Properties(rs.getInt("id"),
                                          rs.getInt("type"),
                                          rs.getInt("square_feet"),
                                          rs.getInt("Ownerid"),
                                          rs.getString("price"),
                                          rs.getString("address"),
                                          rs.getInt("bedrooms"),
                                          rs.getInt("bathrooms"),
                                          rs.getInt("age"),
                                          rs.getBoolean("balcony"),
                                          rs.getBoolean("pool"),
                                          rs.getBoolean("backyard"),
                                          rs.getBoolean("garage"),
                                          rs.getString("description"));
                list.add(property);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Properties.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
     
     //create a function to return an arraylist of owner properties
     public ArrayList<P_Properties> propertyListByOwner(int ownerId)
     {
        ArrayList<P_Properties> list = new ArrayList<>();
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM properties WHERE ownerid=?";
        
        try {
            ps = DBConnection.getConnection().prepareStatement(selectQuery);
            ps.setInt(1, ownerId);
            rs = ps.executeQuery();
            
            P_Properties property;
            
            while(rs.next()){
                property = new P_Properties(rs.getInt("id"),
                                          rs.getInt("type"),
                                          rs.getInt("square_feet"),
                                          rs.getInt("Ownerid"),
                                          rs.getString("price"),
                                          rs.getString("address"),
                                          rs.getInt("bedrooms"),
                                          rs.getInt("bathrooms"),
                                          rs.getInt("age"),
                                          rs.getBoolean("balcony"),
                                          rs.getBoolean("pool"),
                                          rs.getBoolean("backyard"),
                                          rs.getBoolean("garage"),
                                          rs.getString("description"));
                list.add(property);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Properties.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    } 
     
     //create a function to add image to the property
    public boolean addImage(int propertyId, String imagePath)
    {
        PreparedStatement ps;
        String addQuery = "INSERT INTO property_images(property_id, image) VALUES (?,?)";
        
        try {
            try {
                FileInputStream propertyImage = new FileInputStream(new File(imagePath));
                ps = DBConnection.getConnection().prepareStatement(addQuery);
                ps.setInt(1, propertyId);
                ps.setBinaryStream(2, propertyImage);
                
                return(ps.executeUpdate() > 0);
                
            } catch (FileNotFoundException ex) {
                //Logger.getLogger(properties.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Invalid file", "Image Error", 2);
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Properties.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    
    //create a function to get the images list of selected property 
     public HashMap<byte[], Integer> propertyImageList(int propertyId)
    {
        HashMap<byte[], Integer> list = new HashMap<>();
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM property_images WHERE property_id=?";
        
        try {
            ps = DBConnection.getConnection().prepareStatement(selectQuery);
            ps.setInt(1, propertyId);
            rs = ps.executeQuery();
            
            
            while(rs.next()){
               list.put(rs.getBytes("image"), rs.getInt("id"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Properties.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
     
     
    //create a function to get image by id
     public byte[] getImageById(int imageId)
    {
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT image FROM property_images WHERE id=?";
        
        try {
            ps = DBConnection.getConnection().prepareStatement(selectQuery);
            ps.setInt(1, imageId);
            rs = ps.executeQuery();
            
            
            if(rs.next()){
               return rs.getBytes("image");
            }
            else{
                return null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Properties.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    } 
    
     
    //create a function to remove image by id
     public boolean removePropertyImage(int imageId)
    {
        PreparedStatement ps;
        ResultSet rs;
        
        String deleteQuery = "DELETE FROM property_images WHERE id=?";
        
        try {
            ps = DBConnection.getConnection().prepareStatement(deleteQuery);
            ps.setInt(1, imageId);
            
            return(ps.executeUpdate() > 0);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Properties.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
}
