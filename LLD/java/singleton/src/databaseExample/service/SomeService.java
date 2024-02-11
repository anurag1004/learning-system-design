package databaseExample.service;

import databaseExample.database.DatabaseConn;
import databaseExample.database.DbConfig;

public class SomeService{
    DatabaseConn dbConn;
    public SomeService(){
        dbConn = DatabaseConn.getInstance(new DbConfig("anurag","123"));
    }
    public String getAllUsers(){
        return dbConn.query("SELECT * FROM mydb.users;");
    }
}
