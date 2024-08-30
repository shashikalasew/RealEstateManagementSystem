/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package system;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class ShowProperties extends javax.swing.JFrame {

    /**
     * Creates new form ShowProperties
     */
    public ShowProperties() {
        initComponents();
        
        //populate the table
        fillTableProperties();
    }
    
    //create a function to populate the table
    public void fillTableProperties(){
        
        P_Properties property = new P_Properties();
        ArrayList<P_Properties> propertyList = property.propertyList();
        
        //table columns
        String[] colNames = {"ID","Type", "Square feet", "Owner ID", "Price(USD)", "Address", "Bedrooms", "Bathrooms", "Age", "Balcony", "Pool", "Backyard", "Garage", "Description"};
        
        //table rows
        //propertyList.size() = size of the arraylist
        Object[][] rows = new Object[propertyList.size()][14];
        
        for(int i = 0; i<propertyList.size(); i++)
        {
            rows[i][0] = propertyList.get(i).getId();
            rows[i][1] = propertyList.get(i).getType();
            rows[i][2] = propertyList.get(i).getSize();
            rows[i][3] = propertyList.get(i).getOwnerid();
            rows[i][4] = propertyList.get(i).getPrice();
            rows[i][5] = propertyList.get(i).getAddress();
            rows[i][6] = propertyList.get(i).getBedrooms();
            rows[i][7] = propertyList.get(i).getBathrooms();
            rows[i][8] = propertyList.get(i).getAge();
            
            if( propertyList.get(i).isBalcony()) rows[i][9] = "Yes";
            else{rows[i][9] = "No";}
            
            if( propertyList.get(i).isPool()) rows[i][10] = "Yes";
            else{rows[i][10] = "No";}
            
            if( propertyList.get(i).isBackyard()) rows[i][11] = "Yes";
            else{rows[i][11] = "No";}
            
            if( propertyList.get(i).isGarage()) rows[i][12] = "Yes";
            else{rows[i][12] = "No";}
            
            rows[i][13] = propertyList.get(i).getDescription();
            
        }
        
        DefaultTableModel model = new DefaultTableModel(rows,colNames);
        tblproperties.setModel(model);
        
        tblproperties.setRowHeight(25);
        tblproperties.setSelectionBackground(Color.black);
        tblproperties.getColumnModel().getColumn(0).setPreferredWidth(25);
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblproperties = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaddress = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtdescription = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

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
        jScrollPane1.setViewportView(tblproperties);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("Address ");

        txtaddress.setColumns(20);
        txtaddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtaddress.setRows(5);
        jScrollPane2.setViewportView(txtaddress);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel19.setText("Description/Comment");

        txtdescription.setColumns(20);
        txtdescription.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtdescription.setRows(5);
        jScrollPane3.setViewportView(txtdescription);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblpropertiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblpropertiesMouseClicked
        
        //display the property address & description in text fields
        int selectedRow = tblproperties.getSelectedRow();
        txtaddress.setText(tblproperties.getValueAt(selectedRow, 5).toString());
        txtdescription.setText(tblproperties.getValueAt(selectedRow, 13).toString());
        
    }//GEN-LAST:event_tblpropertiesMouseClicked

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
            java.util.logging.Logger.getLogger(ShowProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowProperties().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblproperties;
    private javax.swing.JTextArea txtaddress;
    private javax.swing.JTextArea txtdescription;
    // End of variables declaration//GEN-END:variables
}
