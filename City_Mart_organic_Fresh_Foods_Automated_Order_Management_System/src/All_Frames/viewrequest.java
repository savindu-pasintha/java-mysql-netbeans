
package All_Frames;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import java.awt.Color;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import oop.RequestOrderClass;
import oop.StoreClass;
import oop.SupplierClass;


public class viewrequest extends javax.swing.JFrame {
     RequestOrderClass ro=new RequestOrderClass();
     
//            public int c;
//                                                //database name=linda
//            public String urldb="jdbc:mysql://localhost:3306/city_mart";
//            public String usernamedb="root";
//            public String passworddb="";
//            
           
            
    
    public viewrequest() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);//full screen krnn
    }
    
//     //create r_showtable function
//    public void requestshowtable(JTable table){
//        try {
//                        
//            //2 create a connection
//            Connection conn = (Connection) DriverManager.getConnection(urldb, usernamedb, passworddb);
//            System.out.println("CONNECTEDD..!");
//            
//            String selectquery="SELECT *FROM request_order";
//            PreparedStatement insert =(PreparedStatement) conn.prepareStatement(selectquery);
//            ResultSet rs = insert.executeQuery();
//            ResultSetMetaData rss = (ResultSetMetaData) rs.getMetaData();
//            
//            c=rss.getColumnCount();// int c to get how much index numbers in the database
//            
//            DefaultTableModel Df=(DefaultTableModel) table.getModel();
//            Df.setRowCount(0);
//            while(rs.next()){
//                Vector v2=new Vector();
//                for(int a=1; a<=c; a++){
//                   // database eke table wala colum piliwel oni ape table ek anuwa data retrive krnn
//                   //othan thinne Ape table eke colum piliwelt Database-colum numliy
//                    v2.add(rs.getString("ro_id"));
//                    v2.add(rs.getString("ro_full_name"));
//                    v2.add(rs.getString("ro_birthdate"));
//                    v2.add(rs.getString("ro_add"));
//                    v2.add(rs.getString("ro_email"));
//                    v2.add(rs.getString("ro_contact"));
//                    v2.add(rs.getString("ro_item"));
//                    v2.add(rs.getString("ro_quentity"));
//                    v2.add(rs.getString("ro_yourprice"));
//                    v2.add(rs.getString("ro_description"));
//                    v2.add(rs.getString("ro_date"));
//                    v2.add(rs.getString("Approve"));
//                    
//                }
//                Df.addRow(v2);
//            }
//            //last close the connection
//            conn.close();
//        }
//        catch (SQLException ex) {
//           System.out.println("Error.. is" + ex.getMessage());
//           
//            //catch the error type and pass to dialogbox
//            String stringerrorvariable = ex.getMessage();
//                 JOptionPane.showMessageDialog(this,stringerrorvariable);
//        }
//        catch (Exception ex) {
//            System.out.println("Error.. is" + ex.getMessage());
//           
//            //catch the error type and pass to dialogbox
//            Object stringerrorvariable = ex.getMessage();
//            JOptionPane.showMessageDialog(this,stringerrorvariable);
//        }    
//    
//        
//    }//end r_showtable()
//   
    
    
    
    
//     //create r_update()
//  public void Approveupdate(String Approve,String type){  
//        DefaultTableModel Df=(DefaultTableModel) jTable1.getModel();//table valus get
//       int selectedIndex = jTable1.getSelectedRow();//seleted row index number catch
//        
//        try {
//            //variables to pass values in textfeild
//           int id= Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());
//            //String  Approve ="yes";
//            
//           
//            //2 create a connection
//            Connection conn = (Connection) DriverManager.getConnection(urldb, usernamedb, passworddb);
//            System.out.println("CONNECTEDD..!");
//                                                           
//            String updatequery="UPDATE request_order SET Approve=?  Where ro_id=?    ";
//            PreparedStatement insert =(PreparedStatement) conn.prepareStatement(updatequery);
//            
//            insert.setString(1,Approve);//approve is a parameeter valuve get
//            insert.setInt(2,id);//database colum datatype is intiger
//           
//            //save tge data database table array[][]={0=id,1=name,2=mobile,3=course}
//            
//           //now should execute the query
//          //  insert.executeUpdate(); ok vithr use klt wad
//          //  JOptionPane.showMessageDialog(this,"UPDATED..!");
//            
//             if(insert.executeUpdate()== 1 ){
//             System.out.println("Inserted..!"); 
//              JOptionPane.showMessageDialog(this,type);//type is parammeter variable
//             }else{
//                JOptionPane.showMessageDialog(this,"Error IN UPDATE ?");
//            }
//        
//            //last close the connection
//            conn.close();
//            
//        }
//        catch (SQLException ex) {
//           System.out.println("Error.. is " + ex.getMessage());
//           
//           //catch the error type and pass to dialogbox
//           String stringerrorvariable=ex.getMessage();
//           
//           JOptionPane.showMessageDialog(this,stringerrorvariable);
//        }
//  }//end r_update function        
//            
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        approvalorderidTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        okbtn = new javax.swing.JButton();
        Cancelbtn = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        deleterequest = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(0, 0, 0));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Full name", "Birthdate", "Address", "Email", "Contact", "Item", "Quentity", "Your price", "Description", "Request  Date", "Approve"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        approvalorderidTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        approvalorderidTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approvalorderidTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Approval-Order ID");

        okbtn.setBackground(new java.awt.Color(255, 255, 255));
        okbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        okbtn.setText("OK");
        okbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        okbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okbtnActionPerformed(evt);
            }
        });

        Cancelbtn.setBackground(new java.awt.Color(255, 255, 255));
        Cancelbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Cancelbtn.setForeground(new java.awt.Color(255, 51, 51));
        Cancelbtn.setText("Cancel");
        Cancelbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelbtnActionPerformed(evt);
            }
        });

        jRadioButton1.setBackground(new java.awt.Color(102, 255, 102));
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Refresh Table");
        jRadioButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        deleterequest.setBackground(new java.awt.Color(0, 0, 0));
        deleterequest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deleterequest.setForeground(new java.awt.Color(255, 255, 0));
        deleterequest.setText("Request-Delete ");
        deleterequest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleterequestMouseClicked(evt);
            }
        });
        deleterequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleterequestActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Home");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Manager");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Request & Approvels");
        jLabel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel4MouseMoved(evt);
            }
        });
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 0));
        jButton4.setText("View Approved Request");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(53, 53, 53)
                .addComponent(jLabel3)
                .addGap(93, 93, 93))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(approvalorderidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(okbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleterequest)
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jButton4)
                    .addContainerGap(766, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(approvalorderidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleterequest))
                .addGap(76, 76, 76))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(559, Short.MAX_VALUE)
                    .addComponent(jButton4)
                    .addGap(17, 17, 17)))
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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        DefaultTableModel Df=(DefaultTableModel) jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();// table row click catch the row data pass to textboxes again view
        //jtable eke colum thin index tik  0 thin id ek damm vtfield ekt 
        approvalorderidTextField.setText(Df.getValueAt(selectedIndex, 0).toString());
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void approvalorderidTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approvalorderidTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_approvalorderidTextFieldActionPerformed

    private void CancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelbtnActionPerformed
        //        // viewrequest v=new viewrequest();
//         //String Approvecancel="";
//         Approveupdate("","Canceld");
         ro.orid=approvalorderidTextField.getText();
         ro.doApprove("No");
         approvalorderidTextField.setText("");
    }//GEN-LAST:event_CancelbtnActionPerformed

    private void deleterequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleterequestActionPerformed
 
       try{
       SupplierClass s=new SupplierClass();
       s.s_id=approvalorderidTextField.getText(); 
       s.dq="DELETE FROM request_order  WHERE ro_id=?";
      // int storedid = Integer.parseInt(itemidtf.getText());
       s.delete();
       }catch(NumberFormatException e){ JOptionPane.showMessageDialog(this, e); }finally{approvalorderidTextField.setText("");}
         
    }//GEN-LAST:event_deleterequestActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        try {
            // requestshowtable(jTable1);
            jTable1.setModel(ro.getModelDataToJtTable());
        } catch (SQLException ex) {
            Logger.getLogger(viewrequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void okbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okbtnActionPerformed
//      //  String  Approve ="yes";    
//        Approveupdate("YES","Approved");

         ro.orid=approvalorderidTextField.getText();
         ro.doApprove("Yes");
         approvalorderidTextField.setText("");
    }//GEN-LAST:event_okbtnActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.setVisible(false);
        new Loginpage().setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
       // this.setVisible(false);
       this.dispose();
        new Managerhome().setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseMoved
        jPanel1.setBackground(Color.black);
    }//GEN-LAST:event_jLabel4MouseMoved

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        jPanel1.setBackground(Color.decode("#5A4642"));
    }//GEN-LAST:event_jPanel1MouseMoved

    private void deleterequestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleterequestMouseClicked
                try {
                    new approvedrequest().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(viewrequest.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_deleterequestMouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         try {
             new approvedrequest().setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(viewrequest.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jButton4ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewrequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         //</editor-fold>
         
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new viewrequest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelbtn;
    private javax.swing.JTextField approvalorderidTextField;
    private javax.swing.JButton deleterequest;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton okbtn;
    // End of variables declaration//GEN-END:variables
}
