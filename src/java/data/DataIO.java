/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import student.Student;


public class DataIO {
    Connection connection = null;
    String url;
    
    public Connection getConnection() throws ClassNotFoundException , SQLException{
        
        
         Class.forName("oracle.jdbc.driver.OracleDriver");
        if(connection == null){
            url = "jdbc:oracle:thin:@//localhost:1521/xe";
        }
        //------ please keep your username and password-------------
        Connection connection = DriverManager.getConnection(url,"USER name","Password");
        return connection;
    }
    
    public Student getStudent(String byUser, String bypassword){
       
       Student stu = new Student();
        Statement statement = null;
        ResultSet resultset = null;
        try {
            statement = getConnection().createStatement();
            String select="SELECT * FROM Students where Password ="+"'"+bypassword+"'"+"AND"+" "+"Studentname="+"'"+byUser+"'";
        System.out.println(select);
       
        
             resultset = statement.executeQuery(select);
             if(!resultset.next()){
                throw new IllegalArgumentException("Login failed !!");
                
            }
             
             stu.setStudentName(resultset.getString("StudentName"));
          stu.setPassword(resultset.getString("password"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataIO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        finally {
       
            
           try {
               resultset.close();
               statement.close();
      
        closeConnection();
           } catch (SQLException ex) {
               Logger.getLogger(DataIO.class.getName()).log(Level.SEVERE, null, ex);
           }
    
        
    }
        return stu;
    }
    public List<Student> Select() throws SQLException, ClassNotFoundException {
       
         List<Student> student = new ArrayList<Student>();
        Statement statement = getConnection().createStatement();
        String select="SELECT studentname, password FROM Students";
        System.out.println(select);
        ResultSet resultset = statement.executeQuery(select);
        
        Student stu = null;
    
    while(resultset.next()){
            stu = new Student();
            stu.setStudentName(resultset.getString("StudentName"));
            stu.setPassword(resultset.getString("password"));
            student.add(stu);
       
    }
                 
    resultset.close();
    statement.close();
      
        closeConnection();
        return student;
        
    }
    
    public void closeConnection() throws SQLException{
       if(connection != null){
           connection.close();
       }
   }
}
