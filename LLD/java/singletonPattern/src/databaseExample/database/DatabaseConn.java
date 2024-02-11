package databaseExample.database;

public class DatabaseConn {
    private static DatabaseConn db;
    private static String url;
    private DatabaseConn(DbConfig dbConfig){
        url = String.format("mydb://%s:%s",dbConfig.username,dbConfig.pwd);
    }
    public static DatabaseConn getInstance(DbConfig dbConfig){ // lazy loading
        if(db==null){
            synchronized (DatabaseConn.class) { // double locking mechanism
                if(db==null) {
                    System.out.println("init db for the first time...");
                    db = new DatabaseConn(dbConfig);
                    db.connect(); // connect to db
                }
            }
        }
        return db;
    }
    private void connect(){
        System.out.println("connected to db");
    }
    public String query(String qry){
        System.out.println("running query: "+qry);
        return "SUCCESS";
    }
}
