/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package system;

import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class Sales extends javax.swing.JFrame {

    /**
     * Creates new form Sales
     */
    public Sales() {
        initComponents();
        
         //set border to the title
        Border title = BorderFactory.createMatteBorder(0,0,3,0, new Color(102,102,102));
        pnltitle.setBorder(title);
        
         //set borders to buttons
        Border button = BorderFactory.createMatteBorder(3,3,3,3, new Color(255,255,255));
        btnAdd.setBorder(button);
        btnUpdate.setBorder(button);
        btnRemove.setBorder(button);
        
        //populate the table properties with property id, owner id and price
        fillTableProperties();
        
        //populate the table clients with client id, first name and last name
        fillTableClients();
        
        //populate the table sales
        fillTableSales();
    }
    
    //create a function to populate the properties table
    public void fillTableProperties(){
        
        P_Properties property = new P_Properties();
        ArrayList<P_Properties> propertyList = property.propertyList();
        
        //table columns
        String[] colNames = {"ID", "Owner Id", "Price"};
        
        //table rows
        //propertyList.size() = size of the arraylist
        Object[][] rows = new Object[propertyList.size()][3];
        
        for(int i = 0; i<propertyList.size(); i++)
        {
            rows[i][0] = propertyList.get(i).getId();
            rows[i][1] = propertyList.get(i).getOwnerid();
            rows[i][2] = propertyList.get(i).getPrice();

        }
        
         
        DefaultTableModel model = new DefaultTableModel(rows,colNames);
        tblproperties.setModel(model);
        
        tblproperties.setRowHeight(25);
        tblproperties.setSelectionBackground(new Color(0,0,0));
        tblproperties.getColumnModel().getColumn(0).setPreferredWidth(25);
        tblproperties.getColumnModel().getColumn(1).setPreferredWidth(25);
        
    }
    
    //create a function to populate the client table
    public void fillTableClients(){
        
        P_Client client = new P_Client();
        ArrayList<P_Client> clientList = client.clientList();
        
        //table columns
        String[] colNames = {"ID", "First Name", "Last Name"};
        
        //table rows
        //propertyList.size() = size of the arraylist
        Object[][] rows = new Object[clientList.size()][3];
        
        for(int i = 0; i<clientList.size(); i++)
        {
            rows[i][0] = clientList.get(i).getId();
            rows[i][1] = clientList.get(i).getFname();
            rows[i][2] = clientList.get(i).getLname();

        }
        
         
        DefaultTableModel model = new DefaultTableModel(rows,colNames);
        tblclients.setModel(model);
        
        tblclients.setRowHeight(25);
        tblclients.setSelectionBackground(new Color(0,0,0));
        tblclients.getColumnModel().getColumn(0).setPreferredWidth(25);
        
    }
    
    //create a function to populate the sales table
    public void fillTableSales(){
        
        P_Sales sale = new P_Sales();
        ArrayList<P_Sales> salesList = sale.salesList();
        
        //table columns
        String[] colNames = {"ID", "Property Id", "Client Id", "Price", "Date"};
        
        //table rows
        //propertyList.size() = size of the arraylist
        Object[][] rows = new Object[salesList.size()][5];
        
        for(int i = 0; i<salesList.size(); i++)
        {
            rows[i][0] = salesList.get(i).getId();
            rows[i][1] = salesList.get(i).getPropertyId();
            rows[i][2] = salesList.get(i).getClientId();
            rows[i][3] = salesList.get(i).getFinalPrice();
            rows[i][4] = salesList.get(i).getSellingDate();

        }
        
         
        DefaultTableModel model = new DefaultTableModel(rows,colNames);
        tblsales.setModel(model);
        
        tblsales.setRowHeight(25);
        tblsales.setSelectionBackground(new Color(0,0,0));
        tblsales.getColumnModel().getColumn(0).setPreferredWidth(25);
        //tblsales.getColumnModel().getColumn(1).setPreferredWidth(25);
        //tblsales.getColumnModel().getColumn(2).setPreferredWidth(25);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnltitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtpropid = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtclientid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtfprice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblproperties = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblclients = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblsales = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        btnRefreshSalesTable = new javax.swing.JButton();
        btnRefreshPropertiesTable = new javax.swing.JButton();
        btnRefreshClientsTable = new javax.swing.JButton();
        btnAddNewProperty = new javax.swing.JButton();
        btnAddNewClient = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        dtedate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        pnltitle.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sales");

        javax.swing.GroupLayout pnltitleLayout = new javax.swing.GroupLayout(pnltitle);
        pnltitle.setLayout(pnltitleLayout);
        pnltitleLayout.setHorizontalGroup(
            pnltitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnltitleLayout.createSequentialGroup()
                .addGap(597, 597, 597)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnltitleLayout.setVerticalGroup(
            pnltitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnltitleLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Property ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("ID             ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("Property List");

        txtpropid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnUpdate.setBackground(new java.awt.Color(0, 153, 0));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRemove.setBackground(new java.awt.Color(255, 0, 0));
        btnRemove.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("Remove");
        btnRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(51, 51, 255));
        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("Client ID");

        txtclientid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("Final Price");

        txtfprice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setText("Date");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setText(":");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setText(":");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setText(":");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel11.setText(":");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel12.setText(":");

        tblproperties.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblproperties.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblpropertiesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblproperties);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel14.setText("Clients List");

        tblclients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblclients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblclientsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblclients);

        tblsales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblsales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsalesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblsales);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel15.setText("Sales List");

        btnRefreshSalesTable.setBackground(new java.awt.Color(255, 255, 0));
        btnRefreshSalesTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRefreshSalesTable.setText("Refresh");
        btnRefreshSalesTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefreshSalesTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshSalesTableActionPerformed(evt);
            }
        });

        btnRefreshPropertiesTable.setBackground(new java.awt.Color(255, 255, 0));
        btnRefreshPropertiesTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRefreshPropertiesTable.setText("Refresh");
        btnRefreshPropertiesTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefreshPropertiesTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshPropertiesTableActionPerformed(evt);
            }
        });

        btnRefreshClientsTable.setBackground(new java.awt.Color(255, 255, 0));
        btnRefreshClientsTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRefreshClientsTable.setText("Refresh");
        btnRefreshClientsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefreshClientsTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshClientsTableActionPerformed(evt);
            }
        });

        btnAddNewProperty.setBackground(new java.awt.Color(0, 102, 51));
        btnAddNewProperty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAddNewProperty.setForeground(new java.awt.Color(255, 255, 255));
        btnAddNewProperty.setText("Add New Property");
        btnAddNewProperty.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddNewProperty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewPropertyActionPerformed(evt);
            }
        });

        btnAddNewClient.setBackground(new java.awt.Color(0, 102, 51));
        btnAddNewClient.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAddNewClient.setForeground(new java.awt.Color(255, 255, 255));
        btnAddNewClient.setText("Add New Client ");
        btnAddNewClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddNewClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewClientActionPerformed(evt);
            }
        });

        btnPrint.setBackground(new java.awt.Color(255, 102, 153));
        btnPrint.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPrint.setText("Print Bill");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        dtedate.setDateFormatString("yyyy-MM-dd");
        dtedate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnltitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtfprice, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtclientid, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtpropid, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtid, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dtedate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnRefreshSalesTable, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRefreshClientsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(btnAddNewClient, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddNewProperty, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefreshPropertiesTable, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnltitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtpropid, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtclientid, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11))
                            .addComponent(txtfprice, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12))
                            .addComponent(dtedate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRefreshPropertiesTable, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRefreshSalesTable, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRefreshClientsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddNewProperty, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddNewClient, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

         try
        {
            //update the selected sale
            int id = Integer.valueOf(txtid.getText());
            int propertyId = Integer.valueOf(txtpropid.getText());
            int clientId = Integer.valueOf(txtclientid.getText());
            String fprice = txtfprice.getText();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String sellingDate = dateFormat.format(dtedate.getDate());

            P_Sales sale = new P_Sales(id, propertyId, clientId, fprice, sellingDate);

            if (new P_Sales().updateSaleData(sale)) 
            {
                JOptionPane.showMessageDialog(null, "Sale data has been updated..", "Update sale", 1);
            } else 
            {
                JOptionPane.showMessageDialog(null, "Sale data not updated..", "Update sale", 2);
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Select the sale Id, property Id and the client Id..", "Update sale", 2);
        }
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed

         try
        {
            //remove the selected sale
            int id = Integer.valueOf(txtid.getText());

            if (new P_Sales().deleteSale(id))
            {
                JOptionPane.showMessageDialog(null, "Sale data has been deleted..", "Delete sale", 1);
            } else 
            {
                JOptionPane.showMessageDialog(null, "Sale data not deleted..", "Delete sale", 2);
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Select the sale Id you want to remove..", "Dlete sale", 2);
        }
        
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        try
        {
            //add a new sale
            int propertyId = Integer.valueOf(txtpropid.getText());
            int clientId = Integer.valueOf(txtclientid.getText());
            String fprice = txtfprice.getText();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String sellingDate = dateFormat.format(dtedate.getDate());

            P_Sales sale = new P_Sales(0, propertyId, clientId, fprice, sellingDate);

            if (new P_Sales().addNewSale(sale)) 
            {
                JOptionPane.showMessageDialog(null, "A new sale has been created and added..", "Add sale", 1);
            }
            else 
            {
                JOptionPane.showMessageDialog(null, "Sale not created..", "Add sale", 2);
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Select the property Id and the client Id..", "Add sale", 2);
        }
        
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblpropertiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblpropertiesMouseClicked

        int selectedRow = tblproperties.getSelectedRow();
        txtpropid.setText(tblproperties.getValueAt(selectedRow, 0).toString());
        txtfprice.setText(tblproperties.getValueAt(selectedRow, 2).toString());
        
    }//GEN-LAST:event_tblpropertiesMouseClicked

    private void tblclientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblclientsMouseClicked
        
        int selectedRow = tblclients.getSelectedRow();
        txtclientid.setText(tblclients.getValueAt(selectedRow, 0).toString());
        
    }//GEN-LAST:event_tblclientsMouseClicked

    private void tblsalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsalesMouseClicked
        
        //display the selected sale data
        int selectedRow = tblsales.getSelectedRow();
        txtid.setText(tblsales.getValueAt(selectedRow, 0).toString());
        txtpropid.setText(tblsales.getValueAt(selectedRow, 1).toString());
        txtclientid.setText(tblsales.getValueAt(selectedRow, 2).toString());
        txtfprice.setText(tblsales.getValueAt(selectedRow, 3).toString());
        
        Date saleDate;
        try {
            saleDate = new SimpleDateFormat("yyyy-MM-dd").parse(tblsales.getValueAt(selectedRow, 4).toString());
            dtedate.setDate(saleDate);
            
        } catch (ParseException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_tblsalesMouseClicked

    private void btnRefreshSalesTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshSalesTableActionPerformed
        
        fillTableSales();
        
        //clear all fields
        txtid.setText("");
        txtpropid.setText("");
        txtclientid.setText("");
        txtfprice.setText("");
        
    }//GEN-LAST:event_btnRefreshSalesTableActionPerformed

    private void btnRefreshPropertiesTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshPropertiesTableActionPerformed
        
        fillTableProperties();
        
    }//GEN-LAST:event_btnRefreshPropertiesTableActionPerformed

    private void btnRefreshClientsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshClientsTableActionPerformed
        
        fillTableClients();
        
    }//GEN-LAST:event_btnRefreshClientsTableActionPerformed

    private void btnAddNewPropertyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewPropertyActionPerformed
        
        //open the property form
        Property property = new Property();
        property.setVisible(true);
        property.pack();
        property.setLocationRelativeTo(null);
        property.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }//GEN-LAST:event_btnAddNewPropertyActionPerformed

    private void btnAddNewClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewClientActionPerformed
        
         //open the client form
        Client client = new Client();
        client.setVisible(true);
        client.pack();
        client.setLocationRelativeTo(null);
        client.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }//GEN-LAST:event_btnAddNewClientActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        
        //creating document                                         
        try {
            int selectedRow = tblsales.getSelectedRow();
            int salesId = Integer.parseInt(tblsales.getValueAt(selectedRow, 0).toString());
            int propertyId = Integer.parseInt(tblsales.getValueAt(selectedRow, 1).toString());
            int clientId = Integer.parseInt(tblsales.getValueAt(selectedRow, 2).toString());
            String finalPrice = tblsales.getValueAt(selectedRow, 3).toString();
            String sellingDate = tblsales.getValueAt(selectedRow, 4).toString();
            
            String title = "                                                              Evergreen Estates \n";
            String line = "                              ******************************************************************\n";
            String thank = "                                                          Thank you for visiting us!";
            String contact = "0718473559";

            // Generate bill content
            String billContent = title
                    + line + "\n"
                    + "Sales ID: " + salesId + "\n"
                    + "Property ID: " + propertyId + "\n"
                    + "Client ID: " + clientId + "\n"
                    + "Final Price: Rs." + finalPrice + ".00\n"
                    + "Selling Date: " + sellingDate + "\n"
                    + "Contact Us: " + contact + "\n\n"
                    + line 
                    + thank;

            // Generate PDF file
            String fileName = "bill_" + salesId + ".pdf";
            String filePath = BillPath.billpath + "\\" + fileName;
            FileOutputStream fos = new FileOutputStream(filePath);
            com.itextpdf.text.Document document = new com.itextpdf.text.Document();
            PdfWriter.getInstance(document, fos);
            document.open();
            document.add(new com.itextpdf.text.Paragraph(billContent));
            document.close();

            // Open the generated bill
            File file = new File(filePath);
            Desktop.getDesktop().open(file);

            JOptionPane.showMessageDialog(null, "Bill generated successfully.", "Generate Bill", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Select a sale from sales table", "Generate Bill", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btnPrintActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddNewClient;
    private javax.swing.JButton btnAddNewProperty;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRefreshClientsTable;
    private javax.swing.JButton btnRefreshPropertiesTable;
    private javax.swing.JButton btnRefreshSalesTable;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private com.toedter.calendar.JDateChooser dtedate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel pnltitle;
    private javax.swing.JTable tblclients;
    private javax.swing.JTable tblproperties;
    private javax.swing.JTable tblsales;
    private javax.swing.JTextField txtclientid;
    private javax.swing.JTextField txtfprice;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtpropid;
    // End of variables declaration//GEN-END:variables
}
