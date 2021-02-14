

package override_with_overload_Method;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




public class CashierClass extends DatabaseConnect{

    public String poid;
    public String posuppliername,podate, poitemname,poquentity,pounitprice,podiscount,pototalprice,tpo;
//    double u=Double.parseDouble(pounitprice);
//    double q=Double.parseDouble(poquentity);
//    double d=Double.parseDouble(podiscount);
//    double tp=(u*q)-d;
//    public String tpo=Double.toString(tp);
    
   
     
      @Override//view purchsae all
    public DefaultTableModel getModelDataToJtTable() throws SQLException{
              
              //   1-  connect database connection 
                super.DatabaseConnect();
                selectquery="SELECT *FROM perchaseorder";
              //   2-  sql query put preparestatement 
                super.view();  
                rs=insert.executeQuery();
                model=new DefaultTableModel();
                rss = (ResultSetMetaData) rs.getMetaData();
               
                model.addColumn("ORDER ID");
                model.addColumn("ITEM NAME");
                model.addColumn("SUPPLIER NAME");
                model.addColumn("UNIT PRICE");
                model.addColumn("QUENTITY");
                model.addColumn("DISCOUNT");
                model.addColumn("TOTAL PRICE");
                model.addColumn("DATE");
                
                
                model.setRowCount(0);
                int c=rss.getColumnCount();
                while(rs.next()){
                    Vector v2=new Vector();
                    for(int a=1; a<=c; a++){
                        // database eke table wala colum piliwel oni ape table ek anuwa data retrive krnn
                                //database colum name
                    v2.add(rs.getString("order_id"));
                    v2.add(rs.getString("item_name"));
                    v2.add(rs.getString("lastname"));
                    v2.add(rs.getString("supplier_name"));
                    v2.add(rs.getString("unite_price"));
                    v2.add(rs.getString("quentity"));
                    v2.add(rs.getString("discount"));
                    v2.add(rs.getString("Totat_price"));
                    v2.add(rs.getString("Date"));
                    
                } 
                    model.addRow(v2); 
                }
               //  4-  close the connection  
                super.Connectionclose();
             return model;  
    }
    
    
    @Override //purchase order to add to database
public void add(){
         try {
            /*  1-  connect database connection */
            super.DatabaseConnect();
            addquery="INSERT INTO perchaseorder(order_id,item_name,supplier_name,unite_price,quentity,discount,Totat_price,Date) VALUES(?,?,?,?,?,?,?,?)";
            super.add();  /*insert=(PreparedStatement) conn.prepareStatement(addquery);*/
           
            /* 2-  String variables in text feild values set
            1,2,..10 kiynne ud liypu query eke ? thin piliwelt value ek dann
            */
            insert.setString(1,poid);
            insert.setString(2,poitemname);
            insert.setString(3,posuppliername);
            insert.setString(4,pounitprice);
            insert.setString(5,poquentity);
            insert.setString(6,podiscount);
            insert.setString(7,pototalprice);
            insert.setString(8,podate);
           
            /* 3-  Executequery Now  */
            super.queryexeute();
        } catch (SQLException ex) {
            Logger.getLogger(CashierClass.class.getName()).log(Level.SEVERE, null, ex);
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
             int ID=Integer.parseInt(this.poid);
            /*  1-  connect database connection */
            super.DatabaseConnect();
            updatequery="UPDATE perchaseorder SET item_name=?,supplier_name=?,unite_price=?,quentity=?,discount=?,Totat_price=?,Date=? Where order_id=?    ";
            super.update();  /*insert=(PreparedStatement) conn.prepareStatement(updatequery);*/
           
            /* 2-  String variables in text feild values set
            1,2,..10 kiynne ud liypu query eke ? thin piliwelt value ek dann
            */
            
            insert.setString(1,poitemname);
            insert.setString(2,posuppliername);
            insert.setString(3,pounitprice);
            insert.setString(4,poquentity);
            insert.setString(5,podiscount);
            insert.setString(6,pototalprice);
            insert.setString(7,podate);
            insert.setInt(8,ID);
           
            /* 3-  Executequery Now  */
            super.queryexeute();
        }catch (SQLException ex) {
            Logger.getLogger(CashierClass.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage()+"THis is ERROR -- ");
        }catch (Exception x){ 
            System.out.println("THis is ERROR -- "+x);
        }finally{
          /* 4-  close the connection  */   
          super.Connectionclose();
         } 
    }
      
//    @Override
// public void delete(){
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
//             int ID=Integer.parseInt(this.poid);
//            int dialogBoxResult=JOptionPane.showConfirmDialog(null,"Do you want DELETE this Row-Record.. ?","Warning",JOptionPane.YES_NO_OPTION);
//            if(dialogBoxResult == JOptionPane.YES_OPTION){
//                /*  1-  connect database connection */
//                super.DatabaseConnect();
//                deletequery="DELETE FROM perchaseorder  WHERE order_id=?";
//                super.delete();  /*insert=(PreparedStatement) conn.prepareStatement(deletequery);*/
//                insert.setInt(1,ID);
//                /* 3-  Executequery Now  */
//                super.queryexeute();
//            } else {System.out.println("Thank you");}
//        }catch (SQLException ex) {
//           // Logger.getLogger(CashierClass.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println(ex.getMessage()+"THis is ERROR -- ");
//        }catch (HeadlessException x){ 
//            System.out.println("THis is ERROR -- "+x);
//        }finally{
//          /* 4-  close the connection  */   
//          super.Connectionclose();
//         } 
//    }
//    
    
    /*
    public static void main(String[] args) {
       SupplierClass s=new SupplierClass();
       
       //  s.add("5","supplier name","food name","Address","078787872");
      // s.update(1,"supplier name","food name","Address","078787872");
      // s.delete(int id=5);
      s.delete(1);
    }
*/

       

public static void main(String[] args) {
      /*
      //okedi kale Cashier ge delete query ek pass krl Supplier object ekt ethnin Cashier purchase order ek execute kala
       SupplierClass s=new SupplierClass();
       s.dq="DELETE FROM perchaseorder  WHERE order_id=?";
       s.delete(506);
     */
       //okedi kale Cashier ge add query ek pass krl Supplier object ekt ethnin Cashier purchase order ek execute kala
        
          
     
       
       //  s.add("5","supplier name","food name","Address","078787872");
      // s.update(1,"supplier name","food name","Address","078787872");
     // s.delete(int id=5);
    // s.delete(507);
    }
}

