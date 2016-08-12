/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appchamilo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class querysGenerales {

    public querysGenerales() {
    }
    
   public ArrayList<Integer> getAllCourses(){
       ArrayList<Integer> ids = new ArrayList<>();
       
         try {
            conect con= new conect();     
            ResultSet rs;
        
            String consulta="SELECT id FROM course";
            
            rs = con.a.executeQuery (consulta);
            
            while (rs.next())
                {
                   ids.add(rs.getInt("id"));
   
                }
            
            con.cerrarst();
            con.cerrarCon();
           
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(curso.class.getName()).log(Level.SEVERE, null, ex);
        }
       return (ids); 
   }
}
