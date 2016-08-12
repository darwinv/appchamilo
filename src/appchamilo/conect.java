/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appchamilo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author User
 */
public class conect {
    public final Statement a;
   private final Connection c; 
   
   public conect () throws SQLException, ClassNotFoundException{
         Class.forName("com.mysql.jdbc.Driver");
    Connection conect = DriverManager.getConnection ("jdbc:mysql://localhost/chamilo","root","");
Statement st = conect.createStatement();
a=st;
c=conect;
   }
   
     public void cerrarst() throws SQLException{
  a.close();
    }
  public void cerrarCon() throws SQLException{
  c.close();
  }
   
}
