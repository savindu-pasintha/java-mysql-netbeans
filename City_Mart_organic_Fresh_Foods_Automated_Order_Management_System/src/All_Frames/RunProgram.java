
package All_Frames;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;




public class RunProgram {

   

    /*  Encapsulation  getTdstring() method call in manger-cashier-store main pages*/
        DateFormat dfor = new SimpleDateFormat("dd/MM/yy   HH:mm:ss");
        Date obj = new Date();
        //System.out.println(dfor.format(obj));
    private String tdstring = (dfor.format(obj));
    public String getTdstring() {
        return tdstring;
    }
     
     
    public static void main(String[] args) {
        new HomePage().setVisible(true);//instant object call
      
    }
    
}
