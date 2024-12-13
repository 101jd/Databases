package org.example.test;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector implements Closeable {
    private String password;
    private final String URL = "jdbc:mysql://148.251.158.171:3306";
    private String user;
    private Connection connection;



    public Connector(String user, String pwdFilename) throws IOException {
         password = new BufferedReader(new FileReader(pwdFilename)).readLine();
         this.user = user;
    }

    public Statement connect() {

        try{
            connection = DriverManager.getConnection(URL, user, password);
            System.out.println("Connected!");
            return connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
