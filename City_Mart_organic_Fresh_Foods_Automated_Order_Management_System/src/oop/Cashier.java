
package oop;

//import classes
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Cashier extends DatabaseConnect{
             /*null exeption error fixed*/
             private String  poid="1";
             private String  posuppliername="Pasintha";
             private String  podate="2020-11-11 9:17:47";
             private String  poitemname="savindu";
                                     
             private String  poquentity="20";
             private String  pounitprice="100";
             private String  podiscount="200"; 
             
             /*String concert to double*/
             double u=Double.parseDouble(pounitprice);
             double q=Double.parseDouble(poquentity);
             double d=Double.parseDouble(podiscount);
             double tp=(u*q)-d;
             
             private String tpo=Double.toString(tp);
             private String pototalprice=tpo;
    /*..override the DatabaseConnection Class mthods..*/
   
             
             
    // purchase order function
               @Override
    public void add(){
         try {
            /*  1-  connect database connection */
            super.DatabaseConnect();
            addquery="INSERT INTO perchaseorder(order_id,item_name,supplier_name,unite_price,quentity,discount,Totat_price,Date) VALUES(?,?,?,?,?,?,?,?)";
            super.add();  /*insert=(PreparedStatement) conn.prepareStatement(addquery);*/
           
            /* 2-  String variables in text feild values set
            1,2,..10 kiynne ud liypu query eke ? thin piliwelt value ek dann
            */
            insert.setString(1,poid); insert.setString(2,poitemname); insert.setString(3,posuppliername);
            insert.setString(4,pounitprice); insert.setString(5,poquentity); insert.setString(6,podiscount);
            insert.setString(7,pototalprice); insert.setString(8,podate);
           
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
   
    
     /*MAIn  Run program ysing check the How class work ?*/
    public static void main(String[] args) {
        
        /* instance or object create acces to class */
        Cashier pm=new Cashier();
        
        /* variable to values assign */
        pm.poid="15";
        pm.podate="2020-11-11 9:17:47";
        pm.poitemname="mango";
        pm.poquentity="300";
        pm.posuppliername="savindu";
        pm.pounitprice="100";
        pm.podiscount="50";
        
        /* Call the method */
        pm.add();
    }        
        
   
}
