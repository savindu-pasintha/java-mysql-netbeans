
package oop;


import com.mysql.jdbc.ResultSetMetaData;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




public class StoreClass extends DatabaseConnect{
        public String  itemid ,itemname, itemamount;
        public int id;
    public DefaultTableModel getModelDataToJtTable() throws SQLException{
              
              //   1-  connect database connection 
                super.DatabaseConnect();
                selectquery="SELECT *FROM store";
              //   2-  sql query put preparestatement 
                super.view();  
                rs=insert.executeQuery();
                model=new DefaultTableModel();
                rss = (ResultSetMetaData) rs.getMetaData();
               
                model.addColumn("ITEM ID");
                model.addColumn("ITEM NAME");
                model.addColumn("QUENTITY");
               
                
                model.setRowCount(0);
                int c=rss.getColumnCount();
                while(rs.next()){
                    Vector v=new Vector();
                    for(int a=1; a<=c; a++){
                        // database eke table wala colum piliwel oni ape table ek anuwa data retrive krnn
                        //database colum name
                         v.add(rs.getString("id"));
                         v.add(rs.getString("item_name"));
                         v.add(rs.getString("amount")  );
                    }
                    model.addRow(v); 
                }
               //  4-  close the connection  
                super.Connectionclose();
             return model;  
    }
    
        @Override
    public void add(){
        // String s_id,String s_name,String s_food,String s_add,String s_contact
       // this.s_name=s_name; this.s_food=s_food;  this.s_add=s_add; this.s_contact=s_contact;
         try {
            /*  1-  connect database connection */
            super.DatabaseConnect();
            addquery="INSERT INTO store(id,item_name,amount) VALUES(?,?,?)";
            super.add();  /*insert=(PreparedStatement) conn.prepareStatement(addquery);*/
           
            /* 2-  String variables in text feild values set
            1,2,..10 kiynne ud liypu query eke ? thin piliwelt value ek dann
            */
            insert.setString(1,itemid);
            insert.setString(2,itemname);
            insert.setString(3,itemamount);
           
           
            /* 3-  Executequery Now  */
            super.queryexeute();
            JOptionPane.showMessageDialog(null,"ID "+itemid+" to ADD "+itemname+" "+itemamount);
        } catch (SQLException ex) {
            Logger.getLogger(StoreClass.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("THis is ERROR -- "+ex);
        }finally{
          /* 4-  close the connection  */   
          super.Connectionclose();
         }
      
    } 
    
        @Override//this method use to pu amount and removeamount and update this method call to Storemanager.java design page
    public void update(){
        //int id,String s_name,String s_food,String s_add,String s_contact
       // this.s_name=s_name; this.s_food=s_food;  this.s_add=s_add; this.s_contact=s_contact;
               
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
            updatequery="UPDATE store SET item_name=? , amount=?  Where id=?";
            super.update();  /*insert=(PreparedStatement) conn.prepareStatement(updatequery);*/
           
            /* 2-  String variables in text feild values set
            1,2,..10 kiynne ud liypu query eke ? thin piliwelt value ek dann
            */
           // String newamount=Integer.toString(x);
            
            insert.setString(1,itemname); 
            insert.setString(2,itemamount);
            id = Integer.parseInt(itemid);
            insert.setInt(3,id);//last item
            
            /* 3-  Executequery Now  */
            super.queryexeute();
            JOptionPane.showMessageDialog(null,"ID "+itemid+" "+itemname+" Updated.");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
            Logger.getLogger(Cashier.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage()+"THis is ERROR -- ");
        }catch (NumberFormatException xx){ 
            JOptionPane.showMessageDialog(null,xx);
            System.out.println("THis is ERROR -- "+xx);
        }finally{
          /* 4-  close the connection  */   
          super.Connectionclose();
         } 
    }
 //oy method ek wenuwat supplier class eke de;et eke de;etquery eky aluten valewe ek assign kala   
//    public void delete(int id){
//
//         /* 
//        // This code copy to table action perform method Catch the row id num value get the id row data
//       
//        DefaultTableModel Df=(DefaultTableModel) jTable1.getModel();
//        int selectedIndex = jTable1.getSelectedRow();  
//        int id = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());//table coloum o index value get
//           
//        */
//        
//        try{
//            int dialogBoxResult=JOptionPane.showConfirmDialog(null,"Do you want DELETE this Row-Record.. ?","Warning",JOptionPane.YES_NO_OPTION);
//            if(dialogBoxResult == JOptionPane.YES_OPTION){
//                /*  1-  connect database connection */
//                super.DatabaseConnect();
//                deletequery="DELETE FROM store  WHERE id=?";
//                super.delete();  /*insert=(PreparedStatement) conn.prepareStatement(deletequery);*/
//                insert.setInt(1,id);
//                /* 3-  Executequery Now  */
//                super.queryexeute();
//            } else {System.out.println("Thank you");}
//        }catch (SQLException ex) {
//            Logger.getLogger(Cashier.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println(ex.getMessage()+"THis is ERROR -- ");
//        }catch (HeadlessException x){ 
//            System.out.println("THis is ERROR -- "+x);
//        }finally{
//          /* 4-  close the connection  */   
//          super.Connectionclose();
//         } 
//    }
//  
    
//   // public static void main(String[] args) {
//      /* 
//      //okedi kale Cashier ge delete query ek pass krl Supplier object ekt ethnin Cashier purchase order ek execute kala
//       SupplierClass s=new SupplierClass();
//       s.dq="DELETE FROM store  WHERE s_id=?";
//       s.delete(506);
//    }
//    /*
//    public static void main(String[] args) {
//       SupplierClass s=new SupplierClass();
//       
//       //  s.add("5","supplier name","food name","Address","078787872");
//      // s.update(1,"supplier name","food name","Address","078787872");
//      // s.delete(int id=5);
//      s.delete(1);
//    }
//*/
}


