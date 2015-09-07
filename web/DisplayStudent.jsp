

<%@page import="java.util.List"%>
<%@page import="student.Student"%>
<%@page import="data.DataIO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of students</title>
    </head>
    
        <h1>Sucessfully login</h1>
        <p> All Students passwords and Student Name</p>
        
        <% DataIO dataIo = new DataIO();%>
        
        <% List<Student> listAllStudents = dataIo.Select();%>
        <table>
            
          <tr>  
            <% for(Student stude:listAllStudents) { %>
                   <td> STUDENT NAME:<%=stude.getStudentName()%></td>
                   <td>PASSWORD: <%=stude.getPassword() %></td>
                    <% } %>
          </tr>
        </table>
        
        <form action="student.html" method="post">
            <p>To logout click the below button</p> 
            <input type="submit" value="logout">
        </form>
        
    

