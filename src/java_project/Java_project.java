/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package java_project;
import java.sql.*;
/**
 *
 * @author HP
 */
public class Java_project {
    
    public static Connection Dbconnection()
    {
            Connection con=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_project","root","yassine123456789");
            if(con!=null){
            System.out.println("connected");
         }

        }catch(SQLException | ClassNotFoundException  e  ){
             System.out.println(e);
             System.out.println("not connected");
             
        }
        

        return con;
        }
    public static void main(String[] args) {
   
        Java_project.Dbconnection();
    }
}
    

