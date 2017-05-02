package com.company;

import java.sql.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    static String url = "jdbc:postgres:Lexicon;";
    static String uri = "english-synonyms.txt";
    //static Map<String,String> words;


    public static void main(String[] args) {
        TextSplitter ts = new TextSplitter(uri);
        createDBTable(ts.getMap());
    }

    static void createDBTable(Map<String,String> words) {
        try(Connection con = DriverManager.getConnection(url)){
            try(Statement stat = con.createStatement()){

                String sql = "CREATE TABLE Lexicon(Id INTEGER, Word VARCHAR(30), Synonym VARCHAR(190))";
                stat.executeUpdate(sql);
                sql = "INSERT INTO Lexicon VALUES(?,?,?)";

                try (PreparedStatement pstat = con.prepareStatement(sql)){

                    Iterator it = words.entrySet().iterator();
                    while (it.hasNext()) {
                        int i = 1;
                        Map.Entry pair = (Map.Entry)it.next();
                        pstat.setInt(1, i++);
                        pstat.setString(2, (String) pair.getKey());
                        pstat.setString(3, (String) pair.getValue());

                        pstat.executeUpdate();
                        it.remove(); // avoids a ConcurrentModificationException
                    }
                    System.out.println("Table created");
                }
            }

        }catch (SQLException e){
            handleSQLException(e);
        }
    }

    static void handleSQLException(SQLException e){
        while (e != null)
        {
            System.err.println("SQL error : "+e.getMessage());
            System.err.println("SQL state : "+e.getSQLState());
            System.err.println("Error code: "+e.getErrorCode());
            System.err.println("Cause: "+e.getCause());
            e = e.getNextException();
        }
    }
}
