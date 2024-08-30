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
public class OwnerProperties extends javax.swing.JFrame {

    /**
     * Creates new form OwnerProperties
     */
    
    static int ownerId;
    
    public OwnerProperties(int oId) {
        initComponents();
        
        this.ownerId = oId;
        
        fillTableOwnerProperties(ownerId);
                
    }
    
    //create a function to populate the table
    public void fillTableOwnerProperties(int id){
        
        P_Properties property = new P_Properties();
        ArrayList<P_Properties> propertyList = property.propertyListByOwner(id);
        
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
        tblOwnerProp.setModel(model);
        
        tblOwnerProp.setRowHeight(25);
        tblOwnerProp.setSelectionBackground(Color.black);
        tblOwnerProp.getColumnModel().getColumn(0).setPreferredWidth(25);
        
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
        tblOwnerProp = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        tblOwnerProp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblOwnerProp);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1064, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(OwnerProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OwnerProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OwnerProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OwnerProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OwnerProperties(ownerId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOwnerProp;
    // End of variables declaration//GEN-END:variables
}
