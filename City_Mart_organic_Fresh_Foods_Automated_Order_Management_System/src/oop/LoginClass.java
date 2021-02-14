
package oop;


import All_Frames.HomePage;
import All_Frames.Loginpage;
import All_Frames.Managerhome;
import All_Frames.Storekeep;
import All_Frames.cashier;
import java.awt.HeadlessException;
import java.sql.SQLException;
public class LoginClass extends DatabaseConnect{
    private String uname, pswd,w; 

    //ENCAPSULATION - getters/setters create 
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getPswd() {
        return pswd;
    }
    public void setPswd(String pswd) {
        this.pswd = pswd;
    }
    public String getW() {
        return w;
    }
    public void setW(String w) {
        this.w = w;
    }
        
      
    public void ManagerCashierStoreLog(String logtype){
         w=logtype;
        try{
            /*  1-  connect database connection */
            super.DatabaseConnect();
            super.selectquery="SELECT username,password,worktype FROM user_accountstable WHERE worktype='"+w+"' AND username='"+uname+"' AND password ='"+pswd+"' ";
            //  2-  sql query put preparestatement 
            super.view();  
            rs = insert.executeQuery();
         //   ResultSetMetaData rss = (ResultSetMetaData) rs.getMetaData();
         //   int c=rss.getColumnCount();
            
           while(rs.next()){
               // for(int a=1; a<=c; a++){
                 String un = rs.getString("username");
                 String pd = rs.getString("password");
                 String wt = rs.getString("worktype");
                if(pswd.equals(pd) && uname.equals(un) && "Manager".equals(wt))
                {
                     new Loginpage().setVisible(false);
                     new Managerhome().setVisible(true);
                     break;
                     
                }else if(pswd.equals(pd) && uname.equals(un) && "Cashier".equals(wt))
                {
                     new Loginpage().setVisible(false);
                     new cashier().setVisible(true);
                     break;
                    
                }else if(pswd.equals(pd) && uname.equals(un) && "Stock-Keeper".equals(wt))
                {
                     new Loginpage().setVisible(false);
                     new Storekeep().setVisible(true);
                     break;
                     
                }else if(pswd.equalsIgnoreCase(pd) || uname.equalsIgnoreCase(un) || w.equalsIgnoreCase(wt)){
                    new Loginpage().setVisible(false);
                    new HomePage().setVisible(true);
                    break;
                }
                   
                System.out.println(un +"-"+pd+ "-" +wt);
               
            //}
           }
          
            //last close the connection
           super.Connectionclose();
           }
           
        catch (SQLException | HeadlessException ex) {
           System.out.println("Error.. is" + ex.getMessage());
        }  
    }   
    public void ManagerLogin(String logtype){
         w=logtype;
        try{
            /*  1-  connect database connection  */
            super.DatabaseConnect();
            super.selectquery="SELECT username,password FROM user_accountstable WHERE worktype='"+w+"' AND username='"+uname+"' AND password ='"+pswd+"' ";
        
            //   2-  sql query put preparestatement 
            super.view();  
            rs = insert.executeQuery();
           if(rs.next()){
                switch (w) {
                    case "Manager" -> {
                        new Loginpage().setVisible(false);
                        new Managerhome().setVisible(true);
                    }
                    default -> {
                         new Managerhome().setVisible(true);
                      //  new Loginpage().setVisible(true);
                       new HomePage().setVisible(false);
                    }    
                }
          }else{  new Loginpage().setVisible(false); 
                     //new HomePage().setVisible(true);
                      new Managerhome().setVisible(true);
           }

            //last close the connection
             super.Connectionclose();
        }catch (SQLException | HeadlessException ex) {
           System.out.println("Error.. is" + ex.getMessage());
        }   
    }
    public void CashierLogin(String logtype){
         w=logtype;
        try{
            /*  1-  connect database connection  */
            super.DatabaseConnect();
            super.selectquery="SELECT username,password FROM user_accountstable WHERE worktype='"+w+"' AND username='"+uname+"' AND password ='"+pswd+"' ";
        
            //   2-  sql query put preparestatement 
            super.view();  
            rs = insert.executeQuery();
           if(rs.next()){
                switch (w) {
                    case "Cashier" -> {
                        new Loginpage().setVisible(false);
                        new cashier().setVisible(true);
                    }
                    default -> {
                        new Loginpage().setVisible(false);
                        new HomePage().setVisible(true);
                    }    
                }
           }else{  new Loginpage().setVisible(false); 
                   new HomePage().setVisible(true);
           }

            //last close the connection
             super.Connectionclose();
        }catch (SQLException | HeadlessException ex) {
           System.out.println("Error.. is" + ex.getMessage());
        }   
    }
    public void StoreLogin(String logtype){
         w=logtype;
        try{
            /*  1-  connect database connection  */
            super.DatabaseConnect();
            super.selectquery="SELECT username,password FROM user_accountstable WHERE  username='"+uname+"' AND password ='"+pswd+"' ";
        
            //   2-  sql query put preparestatement 
            super.view();  
            rs = insert.executeQuery();
           if(rs.next()){
                switch (w) {
                    case "Stock-Keeper" -> {
                        //new Loginpage().setVisible(false);
                        new Storekeep().setVisible(true);
                    }
                    default -> {
                        new Loginpage().setVisible(false);
                        new HomePage().setVisible(true);
                    }    
                }
           }else{  new Loginpage().setVisible(false); 
                   new HomePage().setVisible(true);
           }

            //last close the connection
            super.Connectionclose();
        }catch (SQLException | HeadlessException ex) {
           System.out.println("Error.. is" + ex.getMessage());
        }   
    }
    
}


