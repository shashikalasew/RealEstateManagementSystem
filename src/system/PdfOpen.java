/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system;

import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;
/**
 *
 * @author USER
 */
public class PdfOpen {
     
    public static void open(String id)
    {
        try
        {
            File file = new File(BillPath.billpath + id + ".pdf");
            if(file.exists()){
                Desktop.getDesktop().open(file);
            }
            else{
                JOptionPane.showMessageDialog(null,"File does not exist");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
