package com.company;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:derby:employee;create=true";
        try (Connection con = DriverManager.getConnection(url))
        {
            try (Statement stmt = con.createStatement())
            {
                String sql = "CREATE TABLE EMPLOYEES(ID INTEGER, NAME VARCHAR(30))";
                //String sql = "TABLE EMPLOYEES(ID INTEGER, NAME VARCHAR(30))";
                //stmt.executeUpdate(sql);
                Scanner sc = new Scanner(System.in);
                String name1 = sc.nextLine();
                String name2 = sc.nextLine();
                sql = "INSERT INTO EMPLOYEES VALUES(1, '"+name1+"')";
                stmt.executeUpdate(sql);
                sql = "INSERT INTO EMPLOYEES VALUES(2, '"+name2+"')";
                stmt.executeUpdate(sql);
                ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");
                while (rs.next())
                    System.out.println(rs.getInt("ID")+" "+rs.getString("NAME"));
                //sql = "DROP TABLE EMPLOYEES";
                //stmt.executeUpdate(sql);
            }
        }
        catch (SQLException sqlex)
        {
            while (sqlex != null)
            {
                System.err.println("SQL error : "+sqlex.getMessage());
                System.err.println("SQL state : "+sqlex.getSQLState());
                System.err.println("Error code: "+sqlex.getErrorCode());
                System.err.println("Cause: "+sqlex.getCause());
                sqlex = sqlex.getNextException();
            }
        }
    }
}
