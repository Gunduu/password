/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;


public class Student {
    private String StudentName;
    private String Password;

    public Student() {
        StudentName="";
        Password="";
    }

    public Student(String StudentName, String Password) {
        this.StudentName = StudentName;
        this.Password = Password;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
    
    
}
