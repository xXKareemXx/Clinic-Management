package com.example.clinc_mangement;
import java.sql.*;
import java.util.logging.*;

public class DBconnection {
    static String HOST = "jdbc:mysql://localhost:3306/clinic?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String USERNAME = "root";
    static String PASSWORD = "";
    static Connection connection ;

    public  DBconnection(){}

    public static Connection getConnect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(HOST,USERNAME, PASSWORD);
            System.out.println("Conn Success");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Conn Faild");
        }
        return connection;
    }

}
