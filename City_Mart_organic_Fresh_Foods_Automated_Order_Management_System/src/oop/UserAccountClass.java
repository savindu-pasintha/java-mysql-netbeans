
package oop;

import com.mysql.jdbc.ResultSetMetaData;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




public class UserAccountClass extends DatabaseConnect{
    protected String id,firstname,lastname,addline1,addline2,cityname,nic,age,contactno,username,password,cpassword,gender,worktype,country;
    int ID=Integer.parseInt(this.id);
        
    public DefaultTableModel getModelDataToJtTable() throws SQLException{
              
              //   1-  connect database connection 
                super.DatabaseConnect();
                selectquery="SELECT *FROM user_accountstable";
              //   2-  sql query put preparestatement 
                super.view();  
                rs=insert.executeQuery();
                model=new DefaultTableModel();
                rss = (ResultSetMetaData) rs.getMetaData();
               
                model.addColumn("ID");
                model.addColumn("FIRST NAME");
                model.addColumn("LAST NAME");
                model.addColumn("LINE 1");
                model.addColumn("LINE 2");
                model.addColumn("CITY");
                model.addColumn("COUNTRY");
                model.addColumn("NIC");
                model.addColumn("AGE");
                model.addColumn("GENDER");
                model.addColumn("CONTACT");
                model.addColumn("WORK TYPE");
                model.addColumn("USER NAME");
                model.addColumn("PASSWORD");
                
                model.setRowCount(0);
                int c=rss.getColumnCount();
                while(rs.next()){
                    Vector v2=new Vector();
                    for(int a=1; a<=c; a++){
                        // database eke table wala colum piliwel oni ape table ek anuwa data retrive krnn
                        //database colum name
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
                    model.addRow(v2); 
                }
               //  4-  close the connection  
                super.Connectionclose();
             return model;  
    }
    
    @Override
        public void add(){
            //String id,String firstname,String lastname,String addline1,String addline2,String cityname,String nic,String age,String contactno,String username,String password,String cpassword,String gender,String worktype,String country){
        
            /* copy to design class
            if(r_maleRadioButton.isSelected()){gender="male";} else{gender="female"; }
                  String  worktype=r_worktypeComboBox.getSelectedItem().toString();
                 //int index = r_countryComboBox.getSelectedIndex();
              String  country=r_countryComboBox.getSelectedItem().toString();
            
             if(password.equals( cpassword)){new UserAccountClass().add()}else{JOptionPane.showMessageDialog(this,"..Please enter same password and comfrimpassword..");}
            */
            
            
         try {
            /*  1-  connect database connection */
            super.DatabaseConnect();
           addquery="INSERT INTO user_accountstable(id,firstname,lastname,addline1,addline2,cityname,country,nic,age,contactno,worktype,username,password,comfrimpassword,gender) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
           super.add();  /*insert=(PreparedStatement) conn.prepareStatement(addquery);*/
           
            /* 2-  String variables in text feild values set
            1,2,..10 kiynne ud liypu query eke ? thin piliwelt value ek dann
            */
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
           
            /* 3-  Executequery Now  */
            super.queryexeute();
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountClass.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("THis is ERROR -- "+ex);
        }finally{
          /* 4-  close the connection  */   
          super.Connectionclose();
         }
      
    } 
    
    @Override
    public void update(){
       //int id,String s_name,String s_food,String s_add,String s_contact
       //this.s_name=s_name; this.s_food=s_food;  this.s_add=s_add; this.s_contact=s_contact;
        int id=Integer.parseInt(this.id);
        /* 
        ok use karanne JTable 
        eke mouce click kalam clik karapu than row eke index value 
        ekt adata mul idex eke value ek gann
        ok JFrame ek liyala Value ek method ek ek athult pass kr gnn parameeter ekknin
        
        DefaultTableModel Df=(DefaultTableModel) jTable1.getModel();//table valus get
        int selectedIndex = jTable1.getSelectedRow();//seleted row index number catch
        int id = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());
        */
       
        try{
            
            /*  1-  connect database connection */
            super.DatabaseConnect();
            updatequery="UPDATE user_accountstable SET firstname=? , lastname=?, addline1=?,addline2=?,cityname=?,country=?,nic=?,age=?,contactno=?,worktype=?,username=?,password=?,comfrimpassword=?,gender=? Where id=?    ";
            super.update();  /*insert=(PreparedStatement) conn.prepareStatement(updatequery);*/
           
            /* 2-  String variables in text feild values set
            1,2,..10 kiynne ud liypu query eke ? thin piliwelt value ek dann
            */
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
            insert.setInt(15,ID);//last item
           
            /* 3-  Executequery Now  */
            super.queryexeute();
        }catch (SQLException ex) {
            Logger.getLogger(UserAccountClass.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage()+"THis is ERROR -- ");
        }catch (Exception x){ 
            System.out.println("THis is ERROR -- "+x);
        }finally{
          /* 4-  close the connection  */   
          super.Connectionclose();
         } 
    }
}  
//    @Override
//    public void delete(){
//         /* 
//        // This code copy to table action perform method Catch the row id num value get the id row data
//       
//        DefaultTableModel Df=(DefaultTableModel) jTable1.getModel();
//        int selectedIndex = jTable1.getSelectedRow();  
//        int ID = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());//table coloum o index value get
//         
//        UserAccountClass.ID=this.ID;
//        delete();
//        */
//        
//        try{
//            int dialogBoxResult=JOptionPane.showConfirmDialog(null,"Do you want DELETE this Row-Record.. ?","Warning",JOptionPane.YES_NO_OPTION);
//            if(dialogBoxResult == JOptionPane.YES_OPTION){
//                /*  1-  connect database connection */
//                super.DatabaseConnect();
//                deletequery="DELETE FROM user_accountstable  WHERE id=?";
//                super.delete();  /*insert=(PreparedStatement) conn.prepareStatement(deletequery);*/
//                insert.setInt(1,ID);
//                /* 3-  Executequery Now  */
//                super.queryexeute();
//            } else {System.out.println("Thank you");}
//        }catch (SQLException ex) {
//            Logger.getLogger(UserAccountClass.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println(ex.getMessage()+"THis is ERROR -- ");
//        }catch (HeadlessException x){ 
//            System.out.println("THis is ERROR -- "+x);
//        }finally{
//          /* 4-  close the connection  */   
//          super.Connectionclose();
//         } 
//    }
//    
    
    
//    public static void main(String[] args) {
//      
//      //okedi kale Cashier ge delete query ek pass krl Supplier object ekt ethnin Cashier purchase order ek execute kala
//       SupplierClass s=new SupplierClass();
//       s.dq="DELETE FROM user_accountstable  WHERE id=?";
//       s.delete(506);
//    }
    
    /*
    public static void main(String[] args) {
       SupplierClass s=new SupplierClass();
       
       //  s.add("5","supplier name","food name","Address","078787872");
      // s.update(1,"supplier name","food name","Address","078787872");
      // s.delete(int id=5);
      s.delete(1);
    }
*/


