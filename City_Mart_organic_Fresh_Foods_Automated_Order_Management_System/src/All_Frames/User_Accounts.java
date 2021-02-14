package All_Frames;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import java.awt.Color;
import java.awt.Component;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;//used to tble row data ctch as  a vietor
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import oop.SupplierClass;


public class User_Accounts extends javax.swing.JFrame {
    
            public int c;
                                                //database name=linda
            public String urldb="jdbc:mysql://localhost:3306/city_mart";
            public String usernamedb="root";
            public String passworddb="";
            public String stringerrorvariabl;
            public String selectquery="SELECT *FROM user_accountstable";
            
            
            
   //r_add function create
    public void r_add(){
        //variables to pass textfeileed values
    String  id = r_idTextField.getText();
    String  firstname =r_first_nameTextField.getText();
    String  lastname =r_lastname_TextField.getText();
    String  addline1=r_addline1TextField.getText();
    String  addline2=r_addline2TextField.getText();
    String  cityname=r_cityTextField.getText();
    String  nic=r_nicTextField.getText();
    String  age=r_ageTextField.getText();
    String  contactno=r_contactnoTextField.getText();
    String  username=r_usernameTextField.getText();
    String  password=r_PasswordField.getText();
    String  cpassword=r_cPasswordField.getText();
    String  gender;
    if(r_maleRadioButton.isSelected()){gender="male";} else{gender="female"; }
    String  worktype=r_worktypeComboBox.getSelectedItem().toString();
    
    //combobox items
    //int index = r_countryComboBox.getSelectedIndex();
    String  country=r_countryComboBox.getSelectedItem().toString();
    
    if(password.equals( cpassword)){
             //create dbconnection with mysql
        try {                        //2 create a connection
            Connection conn = (Connection) DriverManager.getConnection(urldb, usernamedb, passworddb);
            System.out.println("...CONNECTED...");
                                                                                                                                                                                        //1,2,3,4,5,6,7,8,9,10,11,12,13,14,15
            String addquery="INSERT INTO user_accountstable(id,firstname,lastname,addline1,addline2,cityname,country,nic,age,contactno,worktype,username,password,comfrimpassword,gender) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement insert =(PreparedStatement) conn.prepareStatement(addquery);
            
            //String variables in text feild values
            insert.setString(1,id);
            insert.setString(2,firstname);
            insert.setString(3,lastname);
            insert.setString(4,addline1);
            insert.setString(5,addline2);
            insert.setString(6,cityname);
            insert.setString(7,country);
            insert.setString(8,nic);
            insert.setString(9,age);
            insert.setString(10,contactno);
            insert.setString(11,worktype);
            insert.setString(12,username);
            insert.setString(13,password);
            insert.setString(14,cpassword);
            insert.setString(15,gender);
            //save tge data database table array[][]={0=id,1=name,2=mobile,3=course}
            
            //now should execute the query
          //  insert.executeUpdate(); ok vithr use klt wad
          //  JOptionPane.showMessageDialog(this,"ADDED SUCCESSFULL..!");
            
             if(insert.executeUpdate()== 1 ){
             System.out.println("Inserted..!"); 
              JOptionPane.showMessageDialog(this,"...ADDED SUCCESSFULL..");
             }else{
                JOptionPane.showMessageDialog(this,"..Error IN Add..!");
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
        
    }//end if
    else{
         JOptionPane.showMessageDialog(this,"..Please enter same password and comfrimpassword..");
    }
    
    
    } //end r_add
    
    
    //create r_showtable function
    public void r_showtable(){
        try {
                        
            //2 create a connection
            Connection conn = (Connection) DriverManager.getConnection(urldb, usernamedb, passworddb);
            System.out.println("CONNECTEDD..!");
            
            PreparedStatement insert =(PreparedStatement) conn.prepareStatement(selectquery);
            ResultSet rs = insert.executeQuery();
            ResultSetMetaData rss = (ResultSetMetaData) rs.getMetaData();
            
            c=rss.getColumnCount();// int c to get how much index numbers in the database
            
            DefaultTableModel Df=(DefaultTableModel) jTable1.getModel();
            Df.setRowCount(0);
            while(rs.next()){
                Vector v2=new Vector();
                for(int a=1; a<=c; a++){
                   // database eke table wala colum piliwel oni ape table ek anuwa data retrive krnn
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("firstname"));
                    v2.add(rs.getString("lastname"));
                    v2.add(rs.getString("addline1"));
                    v2.add(rs.getString("addline2"));
                    v2.add(rs.getString("cityname"));
                    v2.add(rs.getString("country"));
                    v2.add(rs.getString("nic"));
                    v2.add(rs.getString("age"));
                    v2.add(rs.getString("gender"));
                    v2.add(rs.getString("contactno"));
                    v2.add(rs.getString("worktype"));
                    v2.add(rs.getString("username"));
                    v2.add(rs.getString("password"));
                    v2.add(rs.getString("comfrimpassword"));
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
   
    
    
    //create r_update()
  public void r_update(){  
    
      
        DefaultTableModel Df=(DefaultTableModel) jTable1.getModel();//table valus get
        int selectedIndex = jTable1.getSelectedRow();//seleted row index number catch
        
        
        try {
            
            int id = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());
            
    //variables to pass values in textfeild
          
    String  firstname =r_first_nameTextField.getText();
    String  lastname =r_lastname_TextField.getText();
    String  addline1=r_addline1TextField.getText();
    String  addline2=r_addline2TextField.getText();
    String  cityname=r_cityTextField.getText();
    String  country=r_countryComboBox.getSelectedItem().toString();
    String  nic=r_nicTextField.getText();
    String  age=r_ageTextField.getText();
    String  contactno=r_contactnoTextField.getText();
    String  username=r_usernameTextField.getText();
    String  password=r_PasswordField.getText();
    String  cpassword=r_cPasswordField.getText();
   // String  gender;
  //if(r_maleRadioButton.isSelected())       {gender="male";} else{gender="female"; }
    String gender=(r_maleRadioButton.isSelected()) ? "male" : "female";
    
      String  worktype=r_worktypeComboBox.getSelectedItem().toString();
   
            //create dbconnection with mysql
           
            //2 create a connection
            Connection conn = (Connection) DriverManager.getConnection(urldb, usernamedb, passworddb);
            System.out.println("CONNECTEDD..!");
                                                               //1          //2         //3           //4
            String updatequery="UPDATE user_accountstable SET firstname=? , lastname=?, addline1=?,addline2=?,cityname=?,country=?,nic=?,age=?,contactno=?,worktype=?,username=?,password=?,comfrimpassword=?,gender=? Where id=?    ";
            PreparedStatement insert =(PreparedStatement) conn.prepareStatement(updatequery);
            
            
           
            insert.setString(1,firstname);
            insert.setString(2,lastname);
            insert.setString(3,addline1);
            insert.setString(4,addline2);
            insert.setString(5,cityname);
            insert.setString(6,country);
            insert.setString(7,nic);
            insert.setString(8,age);
            insert.setString(9,contactno);
            insert.setString(10,worktype);
            insert.setString(11,username);
            insert.setString(12,password);
            insert.setString(13,cpassword);
            insert.setString(14,gender);
            insert.setInt(15,id);//last item
            
            //save tge data database table array[][]={0=id,1=name,2=mobile,3=course}
            
           //now should execute the query
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
           clearedText();
            
            
        }
        catch (SQLException ex) {
           System.out.println("Error.. is " + ex.getMessage());
           
           //catch the error type and pass to dialogbox
           String stringerrorvariable=ex.getMessage();
           
           JOptionPane.showMessageDialog(this,stringerrorvariable);
        }
  }//end r_update function        
            
  
  
 //create r_delete()
   public void r_delete(){
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
     
            String deletequery="DELETE FROM user_accountstable  WHERE id=?";
            PreparedStatement insert =(PreparedStatement) conn.prepareStatement(deletequery);
            insert.setInt(1,id); 
            
             if(insert.executeUpdate()== 1 ){
              JOptionPane.showMessageDialog(this,"...DELETE SUCCESSFULL..!");
             }else{
                JOptionPane.showMessageDialog(this,"...Error IN DELETE ?..");
            }
            
             
            //last close the connection
            conn.close();
            }
            clearedText();
            //set empty fields
            
            
        }
        catch (SQLException ex) {
           System.out.println("Error.. is " + ex.getMessage());
           
           //catch the error type and pass to dialogbox
           String stringerrorvariable=ex.getMessage();
           
           JOptionPane.showMessageDialog(this,stringerrorvariable);
        }
   }   //end delete function      
   
  private  void clearedText(){
            r_first_nameTextField.setText("");
            r_addline1TextField.setText("");
            r_addline2TextField.setText("");
            r_ageTextField.setText("");
            r_cityTextField.setText("");
            r_cPasswordField.setText("");
            r_usernameTextField.setText("");
            r_nicTextField.setText("");
            r_PasswordField.setText("");
            r_contactnoTextField.setText("");
            r_first_nameTextField.requestFocus();
  }
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
    public User_Accounts() {
        initComponents();
         setExtendedState(JFrame.MAXIMIZED_BOTH);//full screen krnn
        jPanel1.setBackground( Color.decode("#280F4D") );//change bgcolor hexa
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        r_addline1TextField = new javax.swing.JTextField();
        r_nicTextField = new javax.swing.JTextField();
        r_ageTextField = new javax.swing.JTextField();
        r_maleRadioButton = new javax.swing.JRadioButton();
        r_femaleRadioButton = new javax.swing.JRadioButton();
        r_worktypeComboBox = new javax.swing.JComboBox<>();
        r_lastname_TextField = new javax.swing.JTextField();
        r_contactnoTextField = new javax.swing.JTextField();
        r_idTextField = new javax.swing.JTextField();
        r_cityTextField = new javax.swing.JTextField();
        r_addline2TextField = new javax.swing.JTextField();
        r_countryComboBox = new javax.swing.JComboBox<>();
        r_first_nameTextField = new javax.swing.JTextField();
        r_PasswordField = new javax.swing.JPasswordField();
        r_usernameTextField = new javax.swing.JTextField();
        r_okCheckBox = new javax.swing.JCheckBox();
        r_cPasswordField = new javax.swing.JPasswordField();
        r_addButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        r_updateButton = new javax.swing.JButton();
        r_deleteButton = new javax.swing.JButton();
        r_showtableRadioButton = new javax.swing.JRadioButton();
        r_hidetableRadioButton = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        managerpage = new javax.swing.JLabel();
        Homemanager = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 488));

        jLabel3.setFont(new java.awt.Font("Quicksand Light", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("User-Accounts");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registration", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24), new java.awt.Color(51, 51, 255))); // NOI18N

        r_addline1TextField.setText("Address-Line  1");
        r_addline1TextField.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        r_addline1TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_addline1TextFieldActionPerformed(evt);
            }
        });

        r_nicTextField.setText("NIC - Number");
        r_nicTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_nicTextFieldActionPerformed(evt);
            }
        });

        r_ageTextField.setText("Age");
        r_ageTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_ageTextFieldActionPerformed(evt);
            }
        });

        buttonGroup1.add(r_maleRadioButton);
        r_maleRadioButton.setForeground(new java.awt.Color(51, 51, 51));
        r_maleRadioButton.setText("Male");
        r_maleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_maleRadioButtonActionPerformed(evt);
            }
        });

        r_femaleRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(r_femaleRadioButton);
        r_femaleRadioButton.setForeground(new java.awt.Color(51, 51, 51));
        r_femaleRadioButton.setText("Female");
        r_femaleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_femaleRadioButtonActionPerformed(evt);
            }
        });

        r_worktypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Cashier", "Stock-Keeper" }));

        r_lastname_TextField.setText("Last - Name");
        r_lastname_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_lastname_TextFieldActionPerformed(evt);
            }
        });

        r_contactnoTextField.setText("Contact-No");
        r_contactnoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_contactnoTextFieldActionPerformed(evt);
            }
        });

        r_idTextField.setText("ID");
        r_idTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_idTextFieldActionPerformed(evt);
            }
        });

        r_cityTextField.setText(" City - Name");
        r_cityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_cityTextFieldActionPerformed(evt);
            }
        });

        r_addline2TextField.setText("Address-Line  2");
        r_addline2TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_addline2TextFieldActionPerformed(evt);
            }
        });

        r_countryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sri Lanka", "India", "Malasiya", "Japan", "USA", "Canada" }));
        r_countryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_countryComboBoxActionPerformed(evt);
            }
        });

        r_first_nameTextField.setText("First - Name");
        r_first_nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_first_nameTextFieldActionPerformed(evt);
            }
        });

        r_PasswordField.setText("Password");
        r_PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_PasswordFieldActionPerformed(evt);
            }
        });

        r_usernameTextField.setText("USER-NAME");
        r_usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_usernameTextFieldActionPerformed(evt);
            }
        });

        r_okCheckBox.setText("show");
        r_okCheckBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        r_okCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_okCheckBoxActionPerformed(evt);
            }
        });

        r_cPasswordField.setText("Comfirm-Password");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r_addline2TextField)
                    .addComponent(r_first_nameTextField)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(r_cPasswordField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                .addComponent(r_PasswordField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(r_usernameTextField, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(r_lastname_TextField)
                                .addComponent(r_addline1TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(r_worktypeComboBox, 0, 112, Short.MAX_VALUE)
                                .addComponent(r_contactnoTextField))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(r_cityTextField)
                                    .addComponent(r_nicTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(r_ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(r_maleRadioButton)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(r_femaleRadioButton))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(r_countryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(r_okCheckBox))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(r_idTextField))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(r_idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(r_first_nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(r_lastname_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(r_addline1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(r_addline2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r_cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r_countryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(r_nicTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r_ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r_maleRadioButton)
                    .addComponent(r_femaleRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(r_contactnoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(r_worktypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(r_usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(r_PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(r_cPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(r_okCheckBox))
        );

        r_addButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        r_addButton.setText("Add");
        r_addButton.setBorder(null);
        r_addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        r_addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_addButtonActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(0, 0, 0));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FIRST-NAME", "LAST-NAME", "LINE-1", "LINE-2", "CITY", "COUNTRY", "NIC", "AGE", "GENDER", "CONTACT", "WORKED TYPE", "USER-NAME", "PASSWORD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(jTable1);
        jTable1.getAccessibleContext().setAccessibleName("");

        r_updateButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        r_updateButton.setText("Update");
        r_updateButton.setBorder(null);
        r_updateButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        r_updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_updateButtonActionPerformed(evt);
            }
        });

        r_deleteButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        r_deleteButton.setText("Delete");
        r_deleteButton.setBorder(null);
        r_deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        r_deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_deleteButtonActionPerformed(evt);
            }
        });

        r_showtableRadioButton.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup2.add(r_showtableRadioButton);
        r_showtableRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        r_showtableRadioButton.setText("Show-Table");
        r_showtableRadioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        r_showtableRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_showtableRadioButtonActionPerformed(evt);
            }
        });

        r_hidetableRadioButton.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup2.add(r_hidetableRadioButton);
        r_hidetableRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        r_hidetableRadioButton.setText("Hide-Table");
        r_hidetableRadioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        r_hidetableRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_hidetableRadioButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Source Code Pro Light", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Log-Out");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        managerpage.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        managerpage.setForeground(new java.awt.Color(255, 255, 255));
        managerpage.setText("Manager");
        managerpage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        managerpage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                managerpageMouseClicked(evt);
            }
        });

        Homemanager.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Homemanager.setForeground(new java.awt.Color(255, 255, 0));
        Homemanager.setText("Home");
        Homemanager.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Homemanager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomemanagerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(managerpage)
                        .addGap(268, 268, 268))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(r_addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(r_showtableRadioButton))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(r_updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(r_deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(r_hidetableRadioButton)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 985, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(773, Short.MAX_VALUE)
                    .addComponent(Homemanager)
                    .addGap(475, 475, 475)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(managerpage)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(r_hidetableRadioButton)
                            .addComponent(r_showtableRadioButton, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(r_addButton)
                            .addComponent(r_updateButton)
                            .addComponent(r_deleteButton)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addComponent(Homemanager)
                    .addContainerGap(491, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1310, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void r_idTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_idTextFieldActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_r_idTextFieldActionPerformed

    private void r_lastname_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_lastname_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_lastname_TextFieldActionPerformed

    private void r_contactnoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_contactnoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_contactnoTextFieldActionPerformed

    private void r_nicTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_nicTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_nicTextFieldActionPerformed

    private void r_ageTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_ageTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_ageTextFieldActionPerformed

    private void r_addline1TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_addline1TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_addline1TextFieldActionPerformed

    private void r_cityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_cityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_cityTextFieldActionPerformed

    private void r_addline2TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_addline2TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_addline2TextFieldActionPerformed

    private void r_countryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_countryComboBoxActionPerformed
        
    }//GEN-LAST:event_r_countryComboBoxActionPerformed

    private void r_first_nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_first_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_first_nameTextFieldActionPerformed

    private void r_usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_usernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_usernameTextFieldActionPerformed

    
    
    
    
    private void r_addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_addButtonActionPerformed
          r_add();
    }//GEN-LAST:event_r_addButtonActionPerformed

    
    
    private void r_PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_PasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_PasswordFieldActionPerformed

    
    
    
    private void r_showtableRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_showtableRadioButtonActionPerformed
          r_showtable();
          jTable1.setForeground(Color.white);
    }//GEN-LAST:event_r_showtableRadioButtonActionPerformed

    private void r_hidetableRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_hidetableRadioButtonActionPerformed
          jTable1.setForeground(Color.black);
    }//GEN-LAST:event_r_hidetableRadioButtonActionPerformed

    private void r_updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_updateButtonActionPerformed
        r_update();//call update
    }//GEN-LAST:event_r_updateButtonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        DefaultTableModel Df=(DefaultTableModel) jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();// table row click catch the row data pass to textboxes again view
        //jtable eke colum thin index tik  0,1,2...14 piliwelt
            r_idTextField.setText(Df.getValueAt(selectedIndex, 0).toString());
            r_first_nameTextField.setText(Df.getValueAt(selectedIndex, 1).toString());
            r_lastname_TextField.setText(Df.getValueAt(selectedIndex, 2).toString());
            r_addline1TextField.setText(Df.getValueAt(selectedIndex, 3).toString());
            r_addline2TextField.setText(Df.getValueAt(selectedIndex, 4).toString());
            r_cityTextField.setText(Df.getValueAt(selectedIndex, 5).toString());
            r_nicTextField.setText(Df.getValueAt(selectedIndex, 7).toString());
            r_ageTextField.setText(Df.getValueAt(selectedIndex, 8).toString());
            //9
            //10
            r_contactnoTextField.setText(Df.getValueAt(selectedIndex, 10).toString());
            //11
            r_usernameTextField.setText(Df.getValueAt(selectedIndex, 12).toString());
            r_PasswordField.setText(Df.getValueAt(selectedIndex, 13).toString());
            r_cPasswordField.setText(Df.getValueAt(selectedIndex, 14).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    
    
    
    //r_delere();
    private void r_deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_deleteButtonActionPerformed
       try{
       //okedi kale Cashier ge delete query ek pass krl Supplier object ekt ethnin Cashier purchase order ek execute kala
       SupplierClass s=new SupplierClass();
       s.s_id=r_idTextField.getText(); 
       s.dq="DELETE FROM user_accountstable  WHERE id=?";
      // int storedid = Integer.parseInt(itemidtf.getText());
       s.delete();
       }catch(NumberFormatException e){ JOptionPane.showMessageDialog(this, e); 
       }finally{clearedText();}
  
    }//GEN-LAST:event_r_deleteButtonActionPerformed

    private void HomemanagerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomemanagerMouseClicked
       
        new HomePage().setVisible(true);//call
    }//GEN-LAST:event_HomemanagerMouseClicked

    private void managerpageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_managerpageMouseClicked
        
        new Managerhome().setVisible(true);//call 
    }//GEN-LAST:event_managerpageMouseClicked

    private void r_okCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_okCheckBoxActionPerformed
        
        //checkbox action check
         if( r_okCheckBox.isSelected()){
            r_PasswordField.setEchoChar((char) 0);
            r_cPasswordField.setEchoChar((char) 0);
        }
        else{
           r_cPasswordField.setEchoChar('*');
            r_PasswordField.setEchoChar('*'); 
        }
    }//GEN-LAST:event_r_okCheckBoxActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.setVisible(false);
        new Loginpage().setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void r_maleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_maleRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_maleRadioButtonActionPerformed

    private void r_femaleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_femaleRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_femaleRadioButtonActionPerformed
 
    
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
            java.util.logging.Logger.getLogger(User_Accounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Accounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Accounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Accounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Accounts().setVisible(true);
            }
        });
        
        
        
        
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Homemanager;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel managerpage;
    private javax.swing.JPasswordField r_PasswordField;
    private javax.swing.JButton r_addButton;
    private javax.swing.JTextField r_addline1TextField;
    private javax.swing.JTextField r_addline2TextField;
    private javax.swing.JTextField r_ageTextField;
    private javax.swing.JPasswordField r_cPasswordField;
    private javax.swing.JTextField r_cityTextField;
    private javax.swing.JTextField r_contactnoTextField;
    private javax.swing.JComboBox<String> r_countryComboBox;
    private javax.swing.JButton r_deleteButton;
    private javax.swing.JRadioButton r_femaleRadioButton;
    private javax.swing.JTextField r_first_nameTextField;
    private javax.swing.JRadioButton r_hidetableRadioButton;
    private javax.swing.JTextField r_idTextField;
    private javax.swing.JTextField r_lastname_TextField;
    private javax.swing.JRadioButton r_maleRadioButton;
    private javax.swing.JTextField r_nicTextField;
    private javax.swing.JCheckBox r_okCheckBox;
    private javax.swing.JRadioButton r_showtableRadioButton;
    private javax.swing.JButton r_updateButton;
    private javax.swing.JTextField r_usernameTextField;
    private javax.swing.JComboBox<String> r_worktypeComboBox;
    // End of variables declaration//GEN-END:variables

    
   // public JTable jTable2=this.jTable1;

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }
    
    /**
     *
     */
    

}