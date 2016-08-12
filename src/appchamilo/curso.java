/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appchamilo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class curso {
    private int id; //table course
    private String nombre; //table course
    private String categoria; //relacion course_category
    private String idioma;//table course
    private String code;//table course
    private String category_code;//table course
    
    
    public curso(int id){
      this.setDataCurso(id);
      
    }
        
    public final void setDataCurso(int id){
        try {
            conect con= new conect();     
            ResultSet rs;
        
            String consulta="SELECT title, category_code, course_language, code FROM"
                    + " course WHERE id ='"+id+"' ";
           
            rs = con.a.executeQuery (consulta);
            
            if (rs.next()){ 
           this.setNombre(rs.getString("title"));
           this.setIdioma(rs.getString("course_language"));
           this.setCategory_code(rs.getString("category_code"));
           this.setCode(rs.getString("code")); 
            }
            
            con.cerrarst();
            con.cerrarCon();
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(curso.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setCategoriaPorId(id);
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoriaPorId(int id){
    try {
            conect con= new conect();     
            ResultSet rs;
        
            String consulta="SELECT name FROM"
                    + " course_category Inner Join course ON course_category.code = course.category_code"
                    + " WHERE course.id ='"+id+"' ";
            
            rs = con.a.executeQuery (consulta);
            
            if (rs.next()){ 
           this.setCategoria(rs.getString("name"));
           
            }
            
            con.cerrarst();
            con.cerrarCon();
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(curso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        
        this.categoria = categoria;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategory_code() {
        return category_code;
    }

    public void setCategory_code(String category_code) {
        this.category_code = category_code;
    }
    
}
