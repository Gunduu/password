/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentServlet;

import data.DataIO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import student.Student;


public class servlet extends HttpServlet {

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       String studentName= request.getParameter("Student name");
       String password= request.getParameter("Password");
       
       DataIO dataIo = new DataIO();
       Student student=null;
        try {
            
            student= dataIo.getStudent(studentName, password);
            
       } 
        
      catch (IllegalArgumentException ex) {
          System.out.println("inside wrong"+ex.getMessage());
              String url ="/Wrong.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);  
      }
     

        
        System.out.println(student.getStudentName());
        System.out.println(studentName);
        System.out.println(student.getPassword());
        System.out.println(password);
        
            if((student.getPassword().equals(password)) && (student.getStudentName().equalsIgnoreCase(studentName))){
                System.out.println("inside correct");
        String url ="/DisplayStudent.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
            }
            else {
                System.out.println("inside wrong");
              String url ="/Wrong.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);  
            }
        
        
    }
}   
            
            
    

   


