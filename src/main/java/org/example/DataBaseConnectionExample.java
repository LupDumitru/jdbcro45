package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnectionExample {
    public static void main(String[] args) throws SQLException {
        Connection connection;
        try {
            connection=DatabaseConnection.getConnection();

        }catch (SQLException e){
            System.out.println("Error on retrieving connection");
            throw new RuntimeException();
        }
        createTableMarketinfCampaign(connection);
        initializeMarketingCampaign(connection);

    }
    //create a table
    public  static void createTableMarketinfCampaign(Connection connection) throws SQLException {
        Statement statement= connection.createStatement();
        statement.execute("create table if not exists marketing_campaign (" +
                "id int primary key auto_increment,"+
                "name varchar(200),"+
                "start_date date ,"+
                "budget double);");


    }
    //insert a row/multyple in a table if the table is empty
    public static void initializeMarketingCampaign(Connection connection){
        try {
            Statement statement=DatabaseConnection.getConnection().createStatement();

            ResultSet resultSet=statement.executeQuery("select count(*) from marketing_campaign;");
            if(resultSet.next()&& resultSet.getInt(1)==0){
                statement.execute("insert into marketing_campaign (name,start_date,budget) values "+
                        "('Name1' ,'2022-12-18','1000'),('Name2' ,'2022-10-15','3000'),('Name3' ,'2022-10-20','500')");
                System.out.println("The table marketing_campaign was initializer!");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    //display all values in a table
    // search for a row by a value
}
