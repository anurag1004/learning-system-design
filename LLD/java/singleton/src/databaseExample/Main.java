package databaseExample;

import databaseExample.database.DatabaseConn;
import databaseExample.database.DbConfig;
import databaseExample.service.SomeService;

public class Main {
    public static void main(String[] args) {
        DbConfig dbConfig = new DbConfig("anurag","123");
        DatabaseConn dbConn = DatabaseConn.getInstance(dbConfig);
        System.out.println(dbConn.query("SELECT * from test"));
        SomeService service = new SomeService();
        System.out.println(service.getAllUsers());
    }
}
