
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
import javax.swing.table.DefaultTableModel;
import oop.DatabaseConnect;
import oop.SupplierClass;



public class Suppliers extends javax.swing.JFrame {
    
            public int c;//counder variable
                                                //database name=linda
            public String urldb="jdbc:mysql://localhost:3306/city_mart";
            public String usernamedb="root";
            public String passworddb="";
            public String stringerrorvariabl;
            public String selectquery="SELECT 's_id','s_name','s_contact_no','s_add','s_food_type' FROM suplieraccounttable";
            
    
     //r_add function create
    public void s_add(){
        //variables to pass textfeileed values
    String  s_id = supplieridTextField.getText();
    String  s_name =suppliernameTextField.getText();
    String  s_contact =suppliercontactTextField.getText();
    String  s_add=supplieraddressTextField.getText();
    String  s_food=supplierfoodtypeTextField.getText();
    
        try {                        //2 create a connection
            Connection conn = (Connection) DriverManager.getConnection(urldb, usernamedb, passworddb);
            System.out.println("...CONNECTED...");
                                                                                                               //1,2,3,4,5
            String addquery="INSERT INTO suplieraccounttable(s_id,s_name,s_contact_no,s_add,s_food_type) VALUES(?,?,?,?,?)";
            PreparedStatement insert =(PreparedStatement) conn.prepareStatement(addquery);
            
                           //String variables in text feild values
            insert.setString(1,s_id);
            insert.setString(2,s_name);
            insert.setString(3,s_contact);
            insert.setString(4,s_add);
            insert.setString(5,s_food);
            
            //save to data database table as array[][]={0=id,1=name,2=mobile,3=course}
            
            //now should execute the query
          //  insert.executeUpdate(); ok vithr use klt wad
          //  JOptionPane.showMessageDialog(this,"ADDED SUCCESSFULL..!");
            
             if(insert.executeUpdate()== 1 ){
             System.out.println("Inserted..!"); 
              JOptionPane.showMessageDialog(this,"...ADDED SUCCESSFULL..");
             }else{
                JOptionPane.showMessageDialog(this,"..Error in Add..!");
            }
           
            // r_idTextField.setText("");
           // r_idTextField.requestFocus();
          //last close the connection
            conn.close();
        }
        catch (SQLException ex) {
           System.out.println("Error.. is " + ex.getMessage());
           
           //catch the error type and pass to dialogbox
           String stringerrorvariable=ex.getMessage();
           
           JOptionPane.showMessageDialog(this,stringerrorvariable);
        }
        
    }//end add
    
   
    //create r_showtable function
    public  void s_showtable(){
        try {
               
            //2 create a connection
            Connection conn = (Connection) DriverManager.getConnection(urldb, usernamedb, passworddb);
            System.out.println("CONNECTEDD..!");
            String selectquery="SELECT *FROM suplieraccounttable";
            
            PreparedStatement insert =(PreparedStatement) conn.prepareStatement(selectquery);
            
            ResultSet rs = insert.executeQuery();
          
            ResultSetMetaData rsmd = (ResultSetMetaData)rs.getMetaData();
            int c=rsmd.getColumnCount();// int c to get how much index numbers in the database
            DefaultTableModel Df=(DefaultTableModel) jTable1.getModel();
            Df.setRowCount(0);
            while(rs.next()){
                Vector v2=new Vector();
                for(int a=1; a<=c; a++){
                   // database eke table wala colum piliwel oni ape table ek anuwa data retrive krnn
                                       //database colum name
                    v2.add(rs.getString("s_id"));
                    v2.add(rs.getString("s_name"));
                    v2.add(rs.getString("s_contact_no"));
                    v2.add(rs.getString("s_add"));
                    v2.add(rs.getString("s_food_type")  );
                   
                }
                Df.addRow(v2);
            }
            
            //last close the connection
            conn.close();
        }
        catch (SQLException ex) {
           System.out.println("Error.. is" + ex.getMessage());
           
            //catch the error type and pass to dialogbox
            String stringerrorvariable = ex.getMessage();
                 JOptionPane.showMessageDialog(this,stringerrorvariable);
        }
        catch (Exception ex) {
            System.out.println("Error.. is" + ex.getMessage());
           
            //catch the error type and pass to dialogbox
            Object stringerrorvariable = ex.getMessage();
            JOptionPane.showMessageDialog(this,stringerrorvariable);
        }         
    }//end r_showtable()
   
    
    
    //create s_update()
  public void s_update(){  
    
      
        DefaultTableModel Df=(DefaultTableModel) jTable1.getModel();//table valus get
        int selectedIndex = jTable1.getSelectedRow();//seleted row index number catch
        
        try {
            
            int id = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());
            
    //variables to pass values in textfeild
          
    String  s_name =suppliernameTextField.getText();
    String  s_contact =suppliercontactTextField.getText();
    String  s_add=supplieraddressTextField.getText();
    String  s_food=supplierfoodtypeTextField.getText();
    
   
            //create dbconnection with mysql
            //2 create a connection
            Connection conn = (Connection) DriverManager.getConnection(urldb, usernamedb, passworddb);
            System.out.println("CONNECTEDD..!");
                                                                //1          //2         //3           //4
            String updatequery=" UPDATE suplieraccounttable SET s_name=? , s_contact_no=?, s_add=?,s_food_type=? Where s_id=?    ";
            PreparedStatement insert =(PreparedStatement) conn.prepareStatement(updatequery);
           
            insert.setString(1,s_name);
            insert.setString(2,s_contact);
            insert.setString(3,s_add);
            insert.setString(4,s_food);
            insert.setInt(5,id);//last item
            
            //save tge data database table array[][]={0=id,1=name,2=mobile,3=course}
            
         //  now should execute the query
         //  insert.executeUpdate(); ok vithr use klt wad
         //  JOptionPane.showMessageDialog(this,"UPDATED..!");
            
             if(insert.executeUpdate()== 1 ){
             System.out.println("Inserted..!"); 
              JOptionPane.showMessageDialog(this,"..UPDATE SUCCESSFULL..!");
             }else{
                JOptionPane.showMessageDialog(this,"Error IN UPDATE..?");
            }
        
            //last close the connection
            conn.close();  
            //set empty fields
            suppliernameTextField.setText("");
            supplieraddressTextField.setText("");
            suppliercontactTextField.setText("");
            supplierfoodtypeTextField.setText("");
        }
        catch (SQLException ex) {
           System.out.println("Error.. is " + ex.getMessage());
           //catch the error type and pass to dialogbox
           String stringerrorvariable=ex.getMessage();
           JOptionPane.showMessageDialog(this,stringerrorvariable);
        }
  }//end r_update function        
            
  
  
 //create s_delete()
   public void s_delete(){
       //delet the id row data
        DefaultTableModel Df=(DefaultTableModel) jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();  
        
        try {
            int id = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());//table coloum o index value get
            
            int dialogResult=JOptionPane.showConfirmDialog(null,"Do You Want DELETE This Row-Record.. ?","Warning",JOptionPane.YES_NO_OPTION);
            
            if(dialogResult == JOptionPane.YES_OPTION){
            //2 create a connection
            Connection conn = (Connection) DriverManager.getConnection(urldb, usernamedb, passworddb);
            System.out.println("CONNECTEDD..!");
     
            String deletequery="DELETE FROM suplieraccounttable  WHERE s_id=?";
            PreparedStatement insert =(PreparedStatement) conn.prepareStatement(deletequery);
            insert.setInt(1,id); 
            
             if(insert.executeUpdate()== 1){
              JOptionPane.showMessageDialog(this,"...DELETE SUCCESSFULL..!");
             }else{
                JOptionPane.showMessageDialog(this,"...Error IN DELETE ?..");
            }
            
             
            //last close the connection
            conn.close();
            }
            //set empty fields
            suppliernameTextField.setText("");
            supplieraddressTextField.setText("");
            suppliercontactTextField.setText("");
            supplierfoodtypeTextField.setText("");
           
            
        }
        catch (SQLException ex) {
           System.out.println("Error.. is " + ex.getMessage());
           
           //catch the error type and pass to dialogbox
           String stringerrorvariable=ex.getMessage();
           
           JOptionPane.showMessageDialog(this,stringerrorvariable);
        }
   } //end delete function      
            
  
    
    public Suppliers() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);//full screen krnn
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addTextField1 = new javax.swing.JTextField();
        deletTextField2 = new javax.swing.JTextField();
        editTextField3 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        supplieridTextField = new javax.swing.JTextField();
        suppliernameTextField = new javax.swing.JTextField();
        suppliercontactTextField = new javax.swing.JTextField();
        supplieraddressTextField = new javax.swing.JTextField();
        supplierfoodtypeTextField = new javax.swing.JTextField();
        showRadioButton1 = new javax.swing.JRadioButton();
        hideRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
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
                "SUPPLIER ID", "SUPPLIER NAME", "CONTACT PERSON", "ADDRESS", "FOOD TYPE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTable1MouseMoved(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        addTextField1.setBackground(new java.awt.Color(0, 0, 0));
        addTextField1.setForeground(new java.awt.Color(255, 255, 255));
        addTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        addTextField1.setText("Add Supplier");
        addTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addTextField1MouseClicked(evt);
            }
        });
        addTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTextField1ActionPerformed(evt);
            }
        });

        deletTextField2.setBackground(new java.awt.Color(0, 0, 0));
        deletTextField2.setForeground(new java.awt.Color(255, 255, 255));
        deletTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        deletTextField2.setText("Delete");
        deletTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deletTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deletTextField2MouseClicked(evt);
            }
        });
        deletTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletTextField2ActionPerformed(evt);
            }
        });

        editTextField3.setBackground(new java.awt.Color(0, 0, 0));
        editTextField3.setForeground(new java.awt.Color(255, 255, 255));
        editTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        editTextField3.setText("Edit");
        editTextField3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editTextField3MouseClicked(evt);
            }
        });
        editTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTextField3ActionPerformed(evt);
            }
        });

        supplieridTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        supplieridTextField.setText("Id");
        supplieridTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplieridTextFieldActionPerformed(evt);
            }
        });

        suppliernameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        suppliernameTextField.setText("Name");
        suppliernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppliernameTextFieldActionPerformed(evt);
            }
        });

        suppliercontactTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        suppliercontactTextField.setText("contact-No");
        suppliercontactTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppliercontactTextFieldActionPerformed(evt);
            }
        });

        supplieraddressTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        supplieraddressTextField.setText("Address");
        supplieraddressTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplieraddressTextFieldActionPerformed(evt);
            }
        });

        supplierfoodtypeTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        supplierfoodtypeTextField.setText("Food-Type");
        supplierfoodtypeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierfoodtypeTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(supplieridTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(suppliernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(suppliercontactTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(supplieraddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(supplierfoodtypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(suppliercontactTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suppliernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(supplieraddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(supplierfoodtypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(supplieridTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        showRadioButton1.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(showRadioButton1);
        showRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        showRadioButton1.setText("Show");
        showRadioButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRadioButton1ActionPerformed(evt);
            }
        });

        hideRadioButton2.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(hideRadioButton2);
        hideRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        hideRadioButton2.setText("Hide");
        hideRadioButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hideRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideRadioButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Home");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Suppliers");
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel2MouseMoved(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Manager");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(235, 235, 235)
                        .addComponent(jLabel1)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel3)
                        .addGap(96, 96, 96))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(showRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(hideRadioButton2)
                        .addGap(32, 32, 32)
                        .addComponent(addTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(editTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(deletTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showRadioButton1)
                    .addComponent(hideRadioButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 752, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
        /*Table eke row ek click kalam eke values tika text feild wlat ai dann*/
        DefaultTableModel Df=(DefaultTableModel) jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();// table row click catch the row data pass to textboxes again view
        //jtable eke colum thin index tik  0,1,2...14 piliwelt
            supplieridTextField.setText(Df.getValueAt(selectedIndex, 0).toString());
            suppliernameTextField.setText(Df.getValueAt(selectedIndex, 1).toString());
            suppliercontactTextField.setText(Df.getValueAt(selectedIndex, 2).toString());
            supplieraddressTextField.setText(Df.getValueAt(selectedIndex, 3).toString());
            supplierfoodtypeTextField.setText(Df.getValueAt(selectedIndex, 4).toString());
            
    }//GEN-LAST:event_jTable1MouseClicked

    private void suppliercontactTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppliercontactTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suppliercontactTextFieldActionPerformed

    private void addTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addTextField1ActionPerformed

    private void editTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editTextField3ActionPerformed

    private void deletTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deletTextField2ActionPerformed

    private void hideRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hideRadioButton2ActionPerformed
       jTable1.setForeground(Color.black);
    }//GEN-LAST:event_hideRadioButton2ActionPerformed

    private void showRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRadioButton1ActionPerformed
                try {
                    SupplierClass sc=new  SupplierClass ();
                    jTable1.setModel(sc.getModelDataToJtTable());
                } catch (SQLException ex) {
                    Logger.getLogger(SupplierClass.class.getName()).log(Level.SEVERE, null, ex);
                }
                        
    }//GEN-LAST:event_showRadioButton1ActionPerformed

    private void supplieridTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplieridTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplieridTextFieldActionPerformed

    private void suppliernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppliernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suppliernameTextFieldActionPerformed

    private void supplieraddressTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplieraddressTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplieraddressTextFieldActionPerformed

    private void supplierfoodtypeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierfoodtypeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierfoodtypeTextFieldActionPerformed

    private void addTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addTextField1MouseClicked
        s_add();
    }//GEN-LAST:event_addTextField1MouseClicked

    private void editTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editTextField3MouseClicked
        s_update();
    }//GEN-LAST:event_editTextField3MouseClicked

    private void deletTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletTextField2MouseClicked
        s_delete();
    }//GEN-LAST:event_deletTextField2MouseClicked

    private void jTable1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseMoved

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setVisible(false);
        new Managerhome().setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseMoved
        jPanel1.setBackground(Color.BLACK);
    }//GEN-LAST:event_jLabel2MouseMoved

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
      jPanel1.setBackground(Color.decode("#5d5967"));
    }//GEN-LAST:event_jPanel1MouseMoved

   
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
            java.util.logging.Logger.getLogger(Suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Suppliers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addTextField1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField deletTextField2;
    private javax.swing.JTextField editTextField3;
    private javax.swing.JRadioButton hideRadioButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JRadioButton showRadioButton1;
    private javax.swing.JTextField supplieraddressTextField;
    private javax.swing.JTextField suppliercontactTextField;
    private javax.swing.JTextField supplierfoodtypeTextField;
    private javax.swing.JTextField supplieridTextField;
    private javax.swing.JTextField suppliernameTextField;
    // End of variables declaration//GEN-END:variables
}
