/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class P_Sales {
    
    private int id;
    private int propertyId;
    private int clientId;
    private String finalPrice;
    private String sellingDate;
    
    public P_Sales(){}
    
    public P_Sales(int Id, int propertyId, int clientId, String fprice, String sellingDate)
    {
        this.id = Id;
        this.propertyId = propertyId;
        this.clientId = clientId;
        this.finalPrice = fprice;
        this.sellingDate = sellingDate;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(String sellingDate) {
        this.sellingDate = sellingDate;
    }
    
    
    //create a function to add a new sale
    public boolean addNewSale(P_Sales sale){
        
        PreparedStatement ps;
        String addQuery = "INSERT INTO sales(property_id, client_id, final_price, sale_date) VALUES (?,?,?,?)";
        
        try {
            ps = DBConnection.getConnection().prepareStatement(addQuery);
            ps.setInt(1, sale.getPropertyId());
            ps.setInt(2, sale.getClientId());
            ps.setString(3, sale.getFinalPrice());
            ps.setString(4, sale.getSellingDate());
            
            return (ps.executeUpdate()>0);
        
        } catch (SQLException ex) {
            Logger.getLogger(P_Sales.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //create a function to update the selected sale data
    public boolean updateSaleData(P_Sales sale){
    
        PreparedStatement ps;
        String updateQuery = "UPDATE sales SET property_id=?, client_id=?, final_price=?, sele_date=? WHERE id=?";
        
        try {
            ps = DBConnection.getConnection().prepareStatement(updateQuery);
            ps.setInt(1, sale.getPropertyId());
            ps.setInt(2, sale.getClientId());
            ps.setString(3, sale.getFinalPrice());
            ps.setString(4, sale.getSellingDate());
            ps.setInt(5, sale.getId());
            
            return (ps.executeUpdate()>0);
        
        } catch (SQLException ex) {
            Logger.getLogger(P_Sales.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //create a function to delete the selected sale
    public boolean deleteSale(int saleId)
    {
        PreparedStatement ps;
        String deleteQuery = "DELETE * FROM sales WHERE id=?";
        
        try {
            ps = DBConnection.getConnection().prepareStatement(deleteQuery);
            ps.setInt(1,saleId);
            
            return (ps.executeUpdate()>0);
        
        } catch (SQLException ex) {
            Logger.getLogger(P_Sales.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //create a function to return an arraylist of sales
    public ArrayList<P_Sales> salesList()
    {
        ArrayList<P_Sales> list = new ArrayList<>();
        
        Statement st;
        ResultSet rs;
        String selectQuery = "SELECT *FROM sales";
        
        try {
            st = DBConnection.getConnection().createStatement();
            rs = st.executeQuery(selectQuery);
            
            P_Sales sale;
            
            while(rs.next()){
                sale = new P_Sales(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                list.add(sale);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
}
