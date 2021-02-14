/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

import All_Frames.Storemanager;
import com.mysql.jdbc.ResultSetMetaData;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HACKER PERSON
 */
public class RequestOrderClass extends DatabaseConnect{
    public String orid,orfullname,ordate,orbirthdate,oradd,oremail,orcontact,oritem,orquentity,oryourprice,ordiscription;
  
  
        public DefaultTableModel getModelDataToJtTable() throws SQLException{
              
              //   1-  connect database connection 
                super.DatabaseConnect();
                selectquery="SELECT *FROM request_order";
              //   2-  sql query put preparestatement 
                super.view();  
                rs=insert.executeQuery();
                model=new DefaultTableModel();
                rss = (ResultSetMetaData) rs.getMetaData();
               
                model.addColumn("ORDER ID");
                model.addColumn("FUll NAME");
                model.addColumn("BIRTHDAY PERSON");
                model.addColumn("ADDRESS");
                model.addColumn("EMAIL");
                model.addColumn("CONTACT");
                model.addColumn("ITEM");
                model.addColumn("QUT");
                model.addColumn("THEIR PRICE");
                model.addColumn("DESCRIPTION");
                model.addColumn("DATE");
                model.addColumn("APPROVED");
                
                
                model.setRowCount(0);
                int c=rss.getColumnCount();
                while(rs.next()){
                    Vector v2=new Vector();
                    for(int a=1; a<=c; a++){
                        // database eke table wala colum piliwel oni ape table ek anuwa data retrive krnn
                        //database colum name
                    v2.add(rs.getString("ro_id"));
                    v2.add(rs.getString("ro_full_name"));
                    v2.add(rs.getString("ro_birthdate"));
                    v2.add(rs.getString("ro_add"));
                    v2.add(rs.getString("ro_email"));
                    v2.add(rs.getString("ro_contact"));
                    v2.add(rs.getString("ro_item"));
                    v2.add(rs.getString("ro_quentity"));
                    v2.add(rs.getString("ro_yourprice"));
                    v2.add(rs.getString("ro_description"));
                    v2.add(rs.getString("ro_date"));
                    v2.add(rs.getString("Approve"));
                    //v2.add(rs.getString("Stored_type"));
                    }
                    model.addRow(v2); 
                }
               //  4-  close the connection  
                super.Connectionclose();
             return model;  
    }
    
    //view appvored Manager
    public DefaultTableModel getModelDataToJtTableViewApproved() throws SQLException{
              
              //   1-  connect database connection 
                super.DatabaseConnect();
                selectquery="SELECT *FROM request_order where Approve='YES'  ";
              //   2-  sql query put preparestatement 
                super.view();  
                rs=insert.executeQuery();
                model=new DefaultTableModel();
                rss = (ResultSetMetaData) rs.getMetaData();
               
                model.addColumn("ORDER ID");
                model.addColumn("FUll NAME");
                model.addColumn("ITEM");
                model.addColumn("QUT");
                model.addColumn("THEIR PRICE");
                model.addColumn("DATE");
                model.addColumn("APPROVED");
                
                
                model.setRowCount(0);
                int c=rss.getColumnCount();
                while(rs.next()){
                    Vector v2=new Vector();
                    for(int a=1; a<=c; a++){
                        // database eke table wala colum piliwel oni ape table ek anuwa data retrive krnn
                        //database colum name
                    v2.add(rs.getString("ro_id"));
                    v2.add(rs.getString("ro_full_name"));
                    v2.add(rs.getString("ro_item"));
                    v2.add(rs.getString("ro_quentity"));
                    v2.add(rs.getString("ro_yourprice"));
                    v2.add(rs.getString("Approve"));
                    v2.add(rs.getString("Stored_type"));
                    
                    }
                    model.addRow(v2); 
                }
               //  4-  close the connection  
                super.Connectionclose();
             return model;  
    }
    //VIEW SroreManager
    public DefaultTableModel getModelDataToJtTableViewStored() throws SQLException{
              
              //   1-  connect database connection 
                super.DatabaseConnect();
                selectquery="SELECT *FROM request_order where Approve='YES'  ";
              //   2-  sql query put preparestatement 
                super.view();  
                rs=insert.executeQuery();
                model=new DefaultTableModel();
                rss = (ResultSetMetaData) rs.getMetaData();
               
                model.addColumn("ORDER ID");
                model.addColumn("ITEM");
                model.addColumn("QUT");
                model.addColumn("APPROVED");
                model.addColumn("STORED");
                
                
                model.setRowCount(0);
                int c=rss.getColumnCount();
                while(rs.next()){
                    Vector v2=new Vector();
                    for(int a=1; a<=c; a++){
                        // database eke table wala colum piliwel oni ape table ek anuwa data retrive krnn
                        //database colum name
                    v2.add(rs.getString("ro_id"));
                    v2.add(rs.getString("ro_item"));
                    v2.add(rs.getString("ro_quentity"));
                    v2.add(rs.getString("Approve"));
                    v2.add(rs.getString("Stored_type"));
                    
                    }
                    model.addRow(v2); 
                }
               //  4-  close the connection  
                super.Connectionclose();
             return model;  
    }
        @Override //submit request
    public void add(){
        // String s_id,String s_name,String s_food,String s_add,String s_contact
       // this.s_name=s_name; this.s_food=s_food;  this.s_add=s_add; this.s_contact=s_contact;
         try {
            /*  1-  connect database connection */
            super.DatabaseConnect();
            addquery="INSERT INTO request_order(ro_full_name,ro_date,ro_birthdate,ro_add,ro_email,ro_contact,ro_item,ro_quentity,ro_yourprice,ro_description) VALUES(?,?,?,?,?,?,?,?,?,?)";
            super.add();  /*insert=(PreparedStatement) conn.prepareStatement(addquery);*/
           
            /* 2-  String variables in text feild values set
            1,2,..10 kiynne ud liypu query eke ? thin piliwelt value ek dann
            */
            insert.setString(1,orfullname);
            insert.setString(2,ordate);
            insert.setString(3,orbirthdate);
            insert.setString(4,oradd);
            insert.setString(5,oremail);
            insert.setString(6,orcontact);
            insert.setString(7,oritem);
            insert.setString(8,orquentity);
            insert.setString(9,oryourprice);
            insert.setString(10,ordiscription);
           
            /* 3-  Executequery Now  */
            super.queryexeute();
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,ex);
            Logger.getLogger(Cashier.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("THis is ERROR -- "+ex);
        }finally{
          /* 4-  close the connection  */   
          super.Connectionclose();
         }
      
    } 
   //StoreManager after store the order then yes-no enter to Store requestorder id remember the Approvedrequestoder stored or not ?
    public void doStored(String stored, int id){
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
            updatequery="UPDATE request_order SET Stored_type=?  Where ro_id=?    ";
            super.update();  /*insert=(PreparedStatement) conn.prepareStatement(updatequery);*/
           
            /* 2-  String variables in text feild values set
            1,2,..10 kiynne ud liypu query eke ? thin piliwelt value ek dann
            */
            insert.setString(1,stored);
            insert.setInt(2,id);
           
            /* 3-  Executequery Now  */
            super.queryexeute();
            JOptionPane.showMessageDialog(null,"ID "+id+ " stored "+stored);
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
    //yes-no enter Manager
    public void doApprove(String approve){
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
            updatequery="UPDATE request_order SET Approve=?  Where ro_id=?    ";
            super.update();  /*insert=(PreparedStatement) conn.prepareStatement(updatequery);*/
           
            /* 2-  String variables in text feild values set
            1,2,..10 kiynne ud liypu query eke ? thin piliwelt value ek dann
            */
            insert.setString(1,approve);//approve is a parameeter valuve get
            int id = Integer.parseInt(orid);
            insert.setInt(2,id);//database colum datatype is intiger
           
            /* 3-  Executequery Now  */
            super.queryexeute();
            JOptionPane.showMessageDialog(null,"ID "+id+" Approved '"+approve+"'");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
            Logger.getLogger(Cashier.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage()+"THis is ERROR -- ");
        }catch (HeadlessException | NumberFormatException x){ 
               JOptionPane.showMessageDialog(null,x);
            System.out.println("THis is ERROR -- "+x);
        }finally{
          /* 4-  close the connection  */   
          super.Connectionclose();
         } 
    } 
    
    
}
