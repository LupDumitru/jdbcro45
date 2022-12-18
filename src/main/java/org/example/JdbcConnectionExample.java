package org.example;

import java.sql.*;

public class JdbcConnectionExample {
    public static void main(String[] args) {
        try {
            System.out.println("trying to connect to database");
            Connection dbConnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/problem_number_one","root","root");
            System.out.println("Conection to database successfull");
            Statement statement=dbConnection.createStatement();
            ResultSet resultSet=statement.executeQuery("select *from cinema");
           while(resultSet.next()) {
             String name=  resultSet.getString(2);
             String oras= resultSet.getString(3);
             Integer capacity = resultSet.getInt(4);
               System.out.println("Cinematograful " + name + " din  orasul " + oras + " are  capacitate de  " + capacity);

           }
        } catch (SQLException e) {
            System.out.println("Wrong passs exception :D");
            throw new RuntimeException(e);
        }
    }

    //checker exception - vf la compile time
}
