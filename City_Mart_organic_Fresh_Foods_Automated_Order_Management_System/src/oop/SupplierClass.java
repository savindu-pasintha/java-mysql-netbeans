
package oop;


import com.mysql.jdbc.ResultSetMetaData;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




public class SupplierClass extends DatabaseConnect{
        public String s_id,s_name,s_food,s_add,s_contact;
        public String dq="DELETE FROM suplieraccounttable  WHERE s_id=?";
    public DefaultTableModel getModelDataToJtTable() throws SQLException{
              
              //   1-  connect database connection 
                super.DatabaseConnect();
                selectquery="SELECT *FROM suplieraccounttable";
              //   2-  sql query put preparestatement 
                super.view();  
                rs=insert.executeQuery();
                model=new DefaultTableModel();
                rss = (ResultSetMetaData) rs.getMetaData();
               
                model.addColumn("SUPPLIER ID");
                model.addColumn("SUPPLIER NAME");
                model.addColumn("CONTACT PERSON");
                model.addColumn("ADDRESS");
                model.addColumn("FOOD TYPE");
                
                model.setRowCount(0);
                int c=rss.getColumnCount();
                while(rs.next()){
                    Vector v=new Vector();
                    for(int a=1; a<=c; a++){
                        // database eke table wala colum piliwel oni ape table ek anuwa data retrive krnn
                        //database colum name
                        v.add(rs.getString("s_id"));
                        v.add(rs.getString("s_name"));
                        v.add(rs.getString("s_contact_no"));
                        v.add(rs.getString("s_add"));
                        v.add(rs.getString("s_food_type"));
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
            addquery="INSERT INTO suplieraccounttable(s_id,s_name,s_contact_no,s_add,s_food_type) VALUES(?,?,?,?,?)";
            super.add();  /*insert=(PreparedStatement) conn.prepareStatement(addquery);*/
           
            /* 2-  String variables in text feild values set
            1,2,..10 kiynne ud liypu query eke ? thin piliwelt value ek dann
            */
            insert.setString(1,s_id);
            insert.setString(2,s_name);
            insert.setString(3,s_contact);
            insert.setString(4,s_add);
            insert.setString(5,s_food);
           
            /* 3-  Executequery Now  */
            super.queryexeute();
        } catch (SQLException ex) {
            Logger.getLogger(Cashier.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("THis is ERROR -- "+ex);
        }finally{
          /* 4-  close the connection  */   
          super.Connectionclose();
         }
      
    } 
    public void update(int id,String s_name,String s_food,String s_add,String s_contact){
        this.s_name=s_name; this.s_food=s_food;  this.s_add=s_add; this.s_contact=s_contact;
               
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
            updatequery=" UPDATE suplieraccounttable SET s_name=? , s_contact_no=?, s_add=?,s_food_type=? Where s_id=?    ";
            super.update();  /*insert=(PreparedStatement) conn.prepareStatement(updatequery);*/
           
            /* 2-  String variables in text feild values set
            1,2,..10 kiynne ud liypu query eke ? thin piliwelt value ek dann
            */
            insert.setString(1,s_name);
            insert.setString(2,s_contact);
            insert.setString(3,s_add);
            insert.setString(4,s_food);
            insert.setInt(5,id);//last item
           
            /* 3-  Executequery Now  */
            super.queryexeute();
        }catch (SQLException ex) {
            Logger.getLogger(Cashier.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage()+"THis is ERROR -- ");
        }catch (Exception x){ 
            System.out.println("THis is ERROR -- "+x);
        }finally{
          /* 4-  close the connection  */   
          super.Connectionclose();
         } 
    }
   
        @Override
    public void delete(){
        
        try{
            int dialogBoxResult=JOptionPane.showConfirmDialog(null,"Do you want DELETE this Row-Record.. ?","Warning",JOptionPane.YES_NO_OPTION);
            if(dialogBoxResult == JOptionPane.YES_OPTION){
                /*  1-  connect database connection */
                super.DatabaseConnect();
                super.deletequery=dq;
               // deletequery="DELETE FROM suplieraccounttable  WHERE s_id=?";
                super.delete();  /*insert=(PreparedStatement) conn.prepareStatement(deletequery);*/
                int id = Integer.parseInt(s_id);
                insert.setInt(1,id);
                /* 3-  Executequery Now  */
                super.queryexeute();
                JOptionPane.showMessageDialog(null,"ID "+id+" Deleted" );
            } else {System.out.println("Thank you");}
        }catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,ex);
            Logger.getLogger(Cashier.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage()+"THis is ERROR -- ");
        }catch (HeadlessException x){ 
            JOptionPane.showMessageDialog(null,x);
            System.out.println("THis is ERROR -- "+x);
        }finally{
          /* 4-  close the connection  */   
          super.Connectionclose();
         } 
    }
    
    
    /*
    public static void main(String[] args) {
       SupplierClass s=new SupplierClass();
       
       //  s.add("5","supplier name","food name","Address","078787872");
      // s.update(1,"supplier name","food name","Address","078787872");
      // s.delete(int id=5);
      s.delete(1);
    }
*/
}

