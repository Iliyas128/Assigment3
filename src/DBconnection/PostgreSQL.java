package DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;


public class PostgreSQL {
    private static final String url = "jdbc:postgresql://localhost:5432/telusko";
    private static final String name = "postgres";
    private static final String password = "500793Ii";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url,name,password);
    }

    public int add(int ilyas, int y){
        return ilyas+y;
    }
}


