
package oop;

//import classes
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class DatabaseConnect {
          
    
    
    
    //DB Connection path/username/password
    private static final String urldb="jdbc:mysql://localhost:3306/city_mart";
    private static final String usernamedb="root";
    private static final String passworddb="";
    //DB Connection classes
    public Connection conn=null;
    public PreparedStatement insert;
    public ResultSet rs= null;
    public DefaultTableModel model;
    public ResultSetMetaData rss;
     //sql query variables
    public String selectquery;
    public String deletequery;
    public String updatequery;
    public String addquery;
    
    
    /*
    ...DatabaseConnect class Constructor method create...
    constructor work all the first in the when calling 
    any class any abjects/instance
    */
    
         //constructor method same class name
    public void DatabaseConnect() throws SQLException{
        try {
            conn = (Connection) DriverManager.getConnection(urldb, usernamedb, passworddb);
            System.out.println(" XAMPP SERVER MYSQL DATABASE CONNCTED. ");
       
        }catch (SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public void view(){
        System.out.println(" View() ");
        try {
            insert = (PreparedStatement) conn.prepareStatement(selectquery);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void add(){
        System.out.println(" add() ");
        try {
            insert =(PreparedStatement) conn.prepareStatement(addquery);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    public void update(){
        System.out.println(" update() ");
        try {
            insert = (PreparedStatement) conn.prepareStatement(updatequery);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delete(){
        System.out.println(" delete() ");
        try {
            insert = (PreparedStatement) conn.prepareStatement(deletequery);
        } catch (SQLException ex) {
            
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void queryexeute(){
        try {
            if( insert.executeUpdate()== 1 ){ System.out.println("EXECUTED QUERY"); }
            else{  System.out.println("Opps Errors Execute Query.........?");  }
        } catch (SQLException ex) {
            System.out.println("Opps Errors"+ ex);
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Connectionclose(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("Connection closed");
    }
//   public DefaultTableModel getModelDataToJtTable() throws SQLException{
//              
//               /*  1-  connect database connection */
//                DatabaseConnect();
//                selectquery="SELECT *FROM suplieraccounttable";
//                /*  2-  sql query put preparestatement */
//                view();  
//                rs=insert.executeQuery();
//                model=new DefaultTableModel();
//                rss = (ResultSetMetaData) rs.getMetaData();
//               
//                model.addColumn("SUPPLIER ID");
//                model.addColumn("SUPPLIER NAME");
//                model.addColumn("CONTACT PERSON");
//                model.addColumn("ADDRESS");
//                model.addColumn("FOOD TYPE");
//                
//                model.setRowCount(0);
//                int c=rss.getColumnCount();
//                while(rs.next()){
//                    Vector v=new Vector();
//                    for(int a=1; a<=c; a++){
//                        // database eke table wala colum piliwel oni ape table ek anuwa data retrive krnn
//                        //database colum name
//                        v.add(rs.getString("s_id"));
//                        v.add(rs.getString("s_name"));
//                        v.add(rs.getString("s_contact_no"));
//                        v.add(rs.getString("s_add"));
//                        v.add(rs.getString("s_food_type"));
//                    }
//                    model.addRow(v); 
//                }
//                 /* 4-  close the connection  */
//                Connectionclose();
//                return model;  
//    }
// 
    
   /* 
    // checked connection after running
    public static void main(String[] args) {
   //class object/instance create     
   DatabaseConnect db=new DatabaseConnect();
        try {
            db.DatabaseConnect();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    */
}
