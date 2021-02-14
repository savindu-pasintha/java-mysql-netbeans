
package All_Frames;

import javax.swing.table.DefaultTableModel;
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
import oop.RequestOrderClass;
import oop.StoreClass;
import oop.SupplierClass;


public class Storemanager extends javax.swing.JFrame {
                   StoreClass stcobj=new StoreClass();   
                   RequestOrderClass ro=new  RequestOrderClass();
                  
                   
            public String priviousamount;//click table amount to add new amount
            public int c;//counter variable
//                                                //database name=linda
//            public String urldb="jdbc:mysql://localhost:3306/city_mart";
//            public String usernamedb="root";
//            public String passworddb="";
//            public String stringerrorvariabl;
           
//  //r_add function create
//    public void newitemadd(){
//        //variables to pass textfeileed values
//    String  itemid = itemidtf.getText();
//    String  itemname =itemnametf.getText();
//    String  itemamount =itemamounttf.getText();
//    
//    
//        try {                        //2 create a connection
//            Connection conn = (Connection) DriverManager.getConnection(urldb, usernamedb, passworddb);
//            System.out.println("...CONNECTED...");
//                                                                //1,2,3,4,5
//            String addquery="INSERT INTO store(id,item_name,amount) VALUES(?,?,?)";
//            PreparedStatement insert =(PreparedStatement) conn.prepareStatement(addquery);
//            
//                           //String variables in text feild values
//            insert.setString(1,itemid);
//            insert.setString(2,itemname);
//            insert.setString(3,itemamount);
//           
//             if(insert.executeUpdate()== 1 ){
//             System.out.println("Inserted"); 
//              JOptionPane.showMessageDialog(this,"ADDED SUCCESSFULL");
//             }else{
//                JOptionPane.showMessageDialog(this,"Error in Add..!");
//            }
//         
//            conn.close();
//        }
//        catch (SQLException ex) {
//           System.out.println("Error.. is " + ex.getMessage());
//           
//           //catch the error type and pass to dialogbox
//           String stringerrorvariable=ex.getMessage();
//           
//           JOptionPane.showMessageDialog(this,stringerrorvariable);
//        }
//        
//    }//end add
    
    //create r_showtable function
//    public void s_showtable(){
//        try {
//             int c;//counder variable       
//            //2 create a connection
//            Connection conn = (Connection) DriverManager.getConnection(urldb, usernamedb, passworddb);
//            System.out.println("CONNECTEDD..!");
//            String selectquerym="SELECT *FROM store";
//            
//            PreparedStatement insert =(PreparedStatement) conn.prepareStatement(selectquerym);
//            ResultSet rs = insert.executeQuery();
//            ResultSetMetaData rss = (ResultSetMetaData) rs.getMetaData();
//            
//            c=rss.getColumnCount();// int c to get how much index numbers in the database
//            
//            DefaultTableModel Df=(DefaultTableModel) jTable1.getModel();
//            Df.setRowCount(0);
//            while(rs.next()){
//                Vector v2=new Vector();
//                for(int a=1; a<=c; a++){
//                   // database eke table wala colum piliwel oni ape table ek anuwa data retrive krnn
//                                       //database colum name
//                    v2.add(rs.getString("id"));
//                    v2.add(rs.getString("item_name"));
//                    v2.add(rs.getString("amount")  );
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
   
    
     
//    //create s_update()
//  public void itemsput(int x){  
//    
//      
//        DefaultTableModel Df=(DefaultTableModel) jTable1.getModel();//table valus get
//        int selectedIndex = jTable1.getSelectedRow();//seleted row index number catch
//        
//        try {
//            
//            int id = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());
//            String  itemname = itemnametf.getText();
//           /*
//          //variables to pass values in textfeild
//          String  itemamount =itemamounttf.getText();
//          int f=Integer.parseInt(itemamount);
//          int g=Integer.parseInt(priviousamount);
//          int h=f+g;
//          */
//          String newamount=Integer.toString(x);//x is a parameeter
//   
//            //create dbconnection with mysql
//            //2 create a connection
//            Connection conn = (Connection) DriverManager.getConnection(urldb, usernamedb, passworddb);
//            System.out.println("CONNECTEDD..!");
//                                               //1          //2         //3           //4
//            String updatequery=" UPDATE store SET item_name=? , amount=? Where id=?     ";
//            PreparedStatement insert =(PreparedStatement) conn.prepareStatement(updatequery);
//            
//            insert.setString(1,itemname); 
//            insert.setString(2,newamount); 
//            insert.setInt(3,id);//last item
//            
//            //save tge data database table array[][]={0=id,1=name,2=mobile,3=course}
//            
//         //  now should execute the query
//         //  insert.executeUpdate(); ok vithr use klt wad
//         //  JOptionPane.showMessageDialog(this,"UPDATED..!");
//            
//             if(insert.executeUpdate()== 1 ){
//              System.out.println("Inserted..!"); 
//              JOptionPane.showMessageDialog(this,"UPDATED");
//             }else{
//                JOptionPane.showMessageDialog(this,"Error IN UPDATE..?");
//            }
//        
//            //last close the connection
//            conn.close();  
//            //set empty fields
//
//            itemnametf.setText("");
//            itemamounttf.setText("");
//            itemidtf.setText("");
//        }
//        catch (SQLException ex) {
//           System.out.println("Error.. is " + ex.getMessage());
//           //catch the error type and pass to dialogbox
//           String stringerrorvariable=ex.getMessage();
//           JOptionPane.showMessageDialog(this,stringerrorvariable);
//        }
//  }//end r_update function        
//            
  
  
// //create s_delete()
//   public void deletecolum(){
//       //delet the id row data
//        DefaultTableModel Df=(DefaultTableModel) jTable1.getModel();
//        int selectedIndex = jTable1.getSelectedRow();  
//        try {
//            int id = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());//table coloum o index value get
//           int dialogResult=JOptionPane.showConfirmDialog(null,"Do You Want DELETE This Row-Record.. ?","Warning",JOptionPane.YES_NO_OPTION);
//            
//            if(dialogResult == JOptionPane.YES_OPTION){
//            //2 create a connection
//            Connection conn = (Connection) DriverManager.getConnection(urldb, usernamedb, passworddb);
//            System.out.println("CONNECTEDD..!");
//     
//            String deletequery="DELETE FROM store  WHERE id=?";
//            PreparedStatement insert =(PreparedStatement) conn.prepareStatement(deletequery);
//            insert.setInt(1,id); 
//            
//             if(insert.executeUpdate()== 1){
//              JOptionPane.showMessageDialog(this,"DELETE SUCCESSFULL");
//             }else{
//                JOptionPane.showMessageDialog(this,"Error IN DELETE ?");
//            }
//            
//             
//            //last close the connection
//            conn.close();
//            }
//            //set empty fields
//            itemnametf.setText("");
//            itemidtf.setText("");
//            itemamounttf.setText("");
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
//   } //end delete function      
            
    public Storemanager() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);//full screen krnn
    }

   private void cleartxt(){
   itemidtf.setText("");
   itemnametf.setText("");
   itemamounttf.setText("");
   itemidstore.setText("");
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        itemidtf = new javax.swing.JTextField();
        itemnametf = new javax.swing.JTextField();
        itemamounttf = new javax.swing.JTextField();
        removeitemTextField4 = new javax.swing.JTextField();
        putitemTextField5 = new javax.swing.JTextField();
        Stored = new javax.swing.JTextField();
        hideRadioButton4 = new javax.swing.JRadioButton();
        showRadioButton3 = new javax.swing.JRadioButton();
        deleteitemTextField5 = new javax.swing.JTextField();
        addnewitemTextField4 = new javax.swing.JTextField();
        showRadioButtonyes = new javax.swing.JRadioButton();
        showRadioButtonno = new javax.swing.JRadioButton();
        itemidstore = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 0));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
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
                "Item-ID", "Item- NAME", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Home");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Store-Manage");
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel2MouseMoved(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Store-Keeper");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM NAME", "New AMOUNT", "Manager APPROVED YES", "PURCHASE DATE", "NOW STORED YES-NO", "STORED DATE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));

        itemidtf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemidtf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemidtf.setText("Id");
        itemidtf.setToolTipText("");
        itemidtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemidtfActionPerformed(evt);
            }
        });

        itemnametf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemnametf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemnametf.setText("Item-Name");
        itemnametf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemnametfActionPerformed(evt);
            }
        });

        itemamounttf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemamounttf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemamounttf.setText("Amount");
        itemamounttf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemamounttfActionPerformed(evt);
            }
        });

        removeitemTextField4.setEditable(false);
        removeitemTextField4.setBackground(new java.awt.Color(255, 51, 51));
        removeitemTextField4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        removeitemTextField4.setForeground(new java.awt.Color(255, 255, 255));
        removeitemTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        removeitemTextField4.setText("Remove-Amount");
        removeitemTextField4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeitemTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeitemTextField4MouseClicked(evt);
            }
        });
        removeitemTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeitemTextField4ActionPerformed(evt);
            }
        });

        putitemTextField5.setEditable(false);
        putitemTextField5.setBackground(new java.awt.Color(102, 0, 255));
        putitemTextField5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        putitemTextField5.setForeground(new java.awt.Color(255, 255, 255));
        putitemTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        putitemTextField5.setText("Put-Items-Quentity");
        putitemTextField5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        putitemTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                putitemTextField5MouseClicked(evt);
            }
        });
        putitemTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                putitemTextField5ActionPerformed(evt);
            }
        });

        Stored.setEditable(false);
        Stored.setBackground(new java.awt.Color(0, 0, 0));
        Stored.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Stored.setForeground(new java.awt.Color(255, 255, 255));
        Stored.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Stored.setText("STORED");
        Stored.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Stored.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StoredMouseClicked(evt);
            }
        });
        Stored.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StoredActionPerformed(evt);
            }
        });

        hideRadioButton4.setBackground(new java.awt.Color(255, 255, 255));
        hideRadioButton4.setText("Hide");
        hideRadioButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hideRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideRadioButton4ActionPerformed(evt);
            }
        });

        showRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
        showRadioButton3.setText("Show");
        showRadioButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRadioButton3ActionPerformed(evt);
            }
        });

        deleteitemTextField5.setEditable(false);
        deleteitemTextField5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteitemTextField5.setForeground(new java.awt.Color(51, 51, 51));
        deleteitemTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        deleteitemTextField5.setText("Delete-Item");
        deleteitemTextField5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteitemTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteitemTextField5MouseClicked(evt);
            }
        });
        deleteitemTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteitemTextField5ActionPerformed(evt);
            }
        });

        addnewitemTextField4.setEditable(false);
        addnewitemTextField4.setBackground(new java.awt.Color(0, 0, 0));
        addnewitemTextField4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addnewitemTextField4.setForeground(new java.awt.Color(255, 255, 255));
        addnewitemTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        addnewitemTextField4.setText("Add -New-Item");
        addnewitemTextField4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addnewitemTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addnewitemTextField4MouseClicked(evt);
            }
        });
        addnewitemTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnewitemTextField4ActionPerformed(evt);
            }
        });

        showRadioButtonyes.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(showRadioButtonyes);
        showRadioButtonyes.setText("YES");
        showRadioButtonyes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showRadioButtonyes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRadioButtonyesActionPerformed(evt);
            }
        });

        showRadioButtonno.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(showRadioButtonno);
        showRadioButtonno.setText("NO");
        showRadioButtonno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showRadioButtonno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRadioButtonnoActionPerformed(evt);
            }
        });

        itemidstore.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemidstore.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemidstore.setText("Id");
        itemidstore.setToolTipText("");
        itemidstore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemidstoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemamounttf)
                    .addComponent(itemnametf))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(addnewitemTextField4)
                        .addGap(23, 23, 23)
                        .addComponent(putitemTextField5)
                        .addGap(18, 18, 18)
                        .addComponent(removeitemTextField4)
                        .addGap(18, 18, 18)
                        .addComponent(deleteitemTextField5)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(showRadioButton3)
                        .addGap(18, 18, 18)
                        .addComponent(hideRadioButton4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemidtf, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(itemidstore, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(showRadioButtonno)
                        .addGap(18, 18, 18)
                        .addComponent(showRadioButtonyes)
                        .addGap(34, 34, 34)
                        .addComponent(Stored, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(itemnametf, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteitemTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeitemTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(putitemTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addnewitemTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemidtf, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemamounttf, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hideRadioButton4)
                    .addComponent(showRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Stored, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(showRadioButtonyes)
                        .addComponent(showRadioButtonno)
                        .addComponent(itemidstore, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(319, 319, 319)
                .addComponent(jLabel1)
                .addGap(75, 75, 75)
                .addComponent(jLabel3)
                .addGap(46, 46, 46))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseMoved

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel Df=(DefaultTableModel) jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();// table row click catch the row data pass to textboxes again view
        //jtable eke colum thin index tik  0,1,2...14 piliwelt
        itemidtf.setText(Df.getValueAt(selectedIndex, 0).toString());
        itemnametf.setText(Df.getValueAt(selectedIndex, 1).toString());
        itemamounttf.setText(Df.getValueAt(selectedIndex, 2).toString());
        priviousamount=itemamounttf.getText();//table eke colum eke agaya gatta click ekedi othant
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseMoved
    
         jPanel1.setBackground(Color.decode("#5d5967"));
    }//GEN-LAST:event_jLabel2MouseMoved

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setVisible(false);
        new Storemanager().setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
           jPanel1.setBackground(Color.BLACK);
    }//GEN-LAST:event_jPanel1MouseMoved

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseDragged

    private void itemidtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemidtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemidtfActionPerformed

    private void itemnametfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemnametfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemnametfActionPerformed

    private void itemamounttfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemamounttfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemamounttfActionPerformed

    private void removeitemTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeitemTextField4MouseClicked
       try{
        stcobj.itemid=itemidtf.getText(); 
        stcobj.itemname=itemnametf.getText();
        int p=Integer.parseInt(priviousamount);
        int n=Integer.parseInt(itemamounttf.getText());
        int t=p-n;
        String fullamount=Integer.toString(t);
        stcobj.itemamount=fullamount; 
        stcobj.update();
        }catch(NumberFormatException e){JOptionPane.showMessageDialog(this, e);}finally{cleartxt();}
    }//GEN-LAST:event_removeitemTextField4MouseClicked

    private void removeitemTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeitemTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeitemTextField4ActionPerformed

    private void putitemTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_putitemTextField5MouseClicked
        try{
        stcobj.itemid=itemidtf.getText(); 
        stcobj.itemname=itemnametf.getText();
        int p=Integer.parseInt(priviousamount);
        int n=Integer.parseInt(itemamounttf.getText());
        int t=p+n;
        String fullamount=Integer.toString(t);
        stcobj.itemamount=fullamount; 
        stcobj.update();
        }catch(NumberFormatException e){JOptionPane.showMessageDialog(this, e);}finally{cleartxt();}
    }//GEN-LAST:event_putitemTextField5MouseClicked

    private void putitemTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_putitemTextField5ActionPerformed

    }//GEN-LAST:event_putitemTextField5ActionPerformed

    private void StoredMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StoredMouseClicked
        try{
        int id = Integer.parseInt(itemidstore.getText());
        String isStored = null;
        if(showRadioButtonyes.isSelected()){ isStored="Yes";}else if(showRadioButtonno.isEnabled()){ isStored="No";}
      //request order class object = ro
        ro.doStored(isStored,id);
        JOptionPane.showMessageDialog(this,"ID "+id+" Stored Now as a '"+isStored+"'" );
        }catch(NumberFormatException e){JOptionPane.showMessageDialog(this, e);}finally{cleartxt();}
       
               
    }//GEN-LAST:event_StoredMouseClicked

    private void StoredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StoredActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StoredActionPerformed

    private void hideRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hideRadioButton4ActionPerformed
        cleartxt();
        jTable1.setBackground(Color.white);
        jTable2.setBackground(Color.black);        
    }//GEN-LAST:event_hideRadioButton4ActionPerformed

    private void showRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRadioButton3ActionPerformed
        try {
             jTable1.setModel(stcobj.getModelDataToJtTable());
             jTable2.setModel(ro.getModelDataToJtTableViewStored());
             } catch (SQLException ex) {
              Logger.getLogger(Storemanager.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_showRadioButton3ActionPerformed

    private void deleteitemTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteitemTextField5MouseClicked
       try{
       //okedi kale Cashier ge delete query ek pass krl Supplier object ekt ethnin Cashier purchase order ek execute kala
       SupplierClass s=new SupplierClass();
       s.s_id=itemidtf.getText(); 
       s.dq="DELETE FROM store  WHERE id=?";
      // int storedid = Integer.parseInt(itemidtf.getText());
       s.delete();
       }catch(NumberFormatException e){ JOptionPane.showMessageDialog(this, e); }finally{cleartxt();}
    }//GEN-LAST:event_deleteitemTextField5MouseClicked

    private void deleteitemTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteitemTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteitemTextField5ActionPerformed

    private void itemidstoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemidstoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemidstoreActionPerformed

    private void addnewitemTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addnewitemTextField4MouseClicked
            stcobj.itemid=itemidtf.getText(); 
            stcobj.itemname=itemnametf.getText();
            stcobj.itemamount=itemamounttf.getText();
            stcobj.add();
            cleartxt();
    }//GEN-LAST:event_addnewitemTextField4MouseClicked

    private void addnewitemTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnewitemTextField4ActionPerformed
       
    }//GEN-LAST:event_addnewitemTextField4ActionPerformed

    private void showRadioButtonyesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRadioButtonyesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showRadioButtonyesActionPerformed

    private void showRadioButtonnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRadioButtonnoActionPerformed
      //  scobj.
    }//GEN-LAST:event_showRadioButtonnoActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
         DefaultTableModel Df=(DefaultTableModel) jTable2.getModel();
        int selectedIndex = jTable2.getSelectedRow();// table row click catch the row data pass to textboxes again view
        //jtable eke colum thin index tik  0,1,2...14 piliwelt
        itemidstore.setText(Df.getValueAt(selectedIndex, 0).toString());
        
    }//GEN-LAST:event_jTable2MouseClicked

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
            java.util.logging.Logger.getLogger(Storemanager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Storemanager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Storemanager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Storemanager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Storemanager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Stored;
    private javax.swing.JTextField addnewitemTextField4;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField deleteitemTextField5;
    private javax.swing.JRadioButton hideRadioButton4;
    private javax.swing.JTextField itemamounttf;
    private javax.swing.JTextField itemidstore;
    private javax.swing.JTextField itemidtf;
    private javax.swing.JTextField itemnametf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField putitemTextField5;
    private javax.swing.JTextField removeitemTextField4;
    private javax.swing.JRadioButton showRadioButton3;
    private javax.swing.JRadioButton showRadioButtonno;
    private javax.swing.JRadioButton showRadioButtonyes;
    // End of variables declaration//GEN-END:variables
}
