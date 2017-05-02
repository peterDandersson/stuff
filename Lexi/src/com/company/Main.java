package com.company;

/**
 * Created by Peter
 */

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static String infoString = "Skriv in ett ord för att få synonymer. skriv \"q\" för att avsluta";
    static String noSynonymString = "Det finns tyvärr inga synonymer i databasen till: ";

    public static void main(String[] args) {
        if(!lexicon()){
            DomParser dp = new DomParser();
            createTable(dp.getWords());
        }
        search();
        //dropTable();
        //searchMap();
    }

    static void searchMap() {
        Scanner sc = new Scanner(System.in);
        TextSplitter ts = new TextSplitter();
        Map<String,List<String>> map = ts.getMap();

        System.out.println(infoString);
        String input;
        while (true) {

            if (null != map.get(input = sc.nextLine().toLowerCase())){
                for (String syn: map.get(input)){
                    System.out.println(syn);
                }
            } else if(input.equals("q")){
                break;
            } else {
                System.out.println(noSynonymString + "\"" + input + "\"");
            }
        }
    }

    static void search(){
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:derby:lexicon;create=true";
        System.out.println(infoString);
            try (Connection con = DriverManager.getConnection(url)){
                try (Statement stat = con.createStatement()){
                    String input;
                    do {
                        input = sc.nextLine().toLowerCase();
                        String sql = "SELECT Synonym FROM Lexicon WHERE Word = '" + input + "' ORDER BY Level DESC";
                        stat.execute(sql);
                        ResultSet resultSet = stat.getResultSet();
                        if(!resultPrinter(resultSet) && !input.equals("q") && !input.equals("drop table")){
                            System.out.println(noSynonymString + "\"" + input + "\"");
                        }
                    } while (!input.equals("q") && !input.equals("drop table"));
                    if (input.equals("drop table")){
                        dropTable();
                    }
                }
            } catch (SQLException e){
                handleSQLException(e);
            }
    }

    static boolean resultPrinter(ResultSet resultSet) throws SQLException {
        boolean b = false;
        if(resultSet.next()){
            b = true;
            do{
                System.out.println(resultSet.getString("Synonym"));
            }while (resultSet.next());
        }
        return b;
    }

    static boolean lexicon() {

        String url = "jdbc:derby:lexicon;create=true";
        try(Connection con = DriverManager.getConnection(url)){
            DatabaseMetaData dbm = con.getMetaData();
            ResultSet tables = dbm.getTables(null, "APP", "LEXICON", null);
            if (tables.next()) {
                return true;
            } else {
                return false;
            }
        }catch (SQLException e){
            handleSQLException(e);
            return false;
        }
    }

    static void dropTable(){
        String url = "jdbc:derby:lexicon;create=true";
        try(Connection con = DriverManager.getConnection(url)){
            try(Statement stat = con.createStatement()){
                stat.executeUpdate("DROP TABLE Lexicon");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Table dropped");
    }

    static void createTable(List<Word> words){
        String url = "jdbc:derby:lexicon;create=true";
        try(Connection con = DriverManager.getConnection(url)){
            try(Statement stat = con.createStatement()){

                String sql = "CREATE TABLE Lexicon(Id INTEGER, Word VARCHAR(30), Synonym VARCHAR(30), Level DOUBLE)";
                stat.executeUpdate(sql);
                sql = "INSERT INTO Lexicon VALUES(?,?,?,?)";

                try (PreparedStatement pstat = con.prepareStatement(sql)){

                    for (int i = 0; i < words.size(); i++){
                        Word w = words.get(i);
                        pstat.setInt(1, w.getId());
                        pstat.setString(2, w.getWord());
                        pstat.setString(3, w.getSynonym());
                        pstat.setDouble(4, w.getLevel());

                        pstat.executeUpdate();
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