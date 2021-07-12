package Database;

import java.sql.*;
import Database.ConnectionDatabase;
public class DataBase {
    ConnectionDatabase conno;
    Statement statement = null;



    public DataBase() {
        this.conno = new ConnectionDatabase();
        this.statement = conno.createSte();
    }

    public boolean insertStatement(String s){
        try {
            boolean result = false;
            result = statement.execute(s);
            if (s.contains("insert")) result=true;
            return result;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public ResultSet selectStatement(String s){
        try {
            ResultSet rs;
            rs = statement.executeQuery(s);
            return rs;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
