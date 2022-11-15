package com.example.sundevilpizza;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBC {
    public static void main(String[] args) {
        try {
            Connection connections = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_video", "root", "VY60rqvy");
            Statement statement = connections.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from people");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("firstname")+" "+ resultSet.getString("id"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
