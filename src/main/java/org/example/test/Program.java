package org.example.test;

import java.io.*;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
    public static void main(String[] args) throws IOException, SQLException {

        String db = "`test-db`";
        String table = "`test-table`";
        String idCol = "`id`";
        String nameCol = "`name`";
        String flagCol = "`flag`";

        try (Statement statement = new TestConnector("jd101", "pwd").connect()){
                        statement.execute("CREATE DATABASE IF NOT EXISTS " + db + ";");
            statement.execute("USE " + db + ";");
            statement.execute("DROP TABLE IF EXISTS " + table + ";");
            statement.execute(String.format(
                    "CREATE TABLE %s (%s INT NOT NULL, %s VARCHAR(42), %s BOOLEAN, PRIMARY KEY(%s));",
                    table, idCol, nameCol, flagCol, idCol));
            statement.execute(String.format("INSERT INTO %s (%s, %s, %s) VALUES (1, 'I am', true)", table, idCol, nameCol, flagCol));

        }
    }
}
