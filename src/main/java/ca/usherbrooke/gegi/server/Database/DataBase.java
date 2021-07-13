package ca.usherbrooke.gegi.server.Database;
import java.sql.*;

public class DataBase {
    ConnectionDatabase conno;
    Statement statement = null;

    /**
     * Constructeur de la base de donnée
     */
    public DataBase() {
        this.conno = new ConnectionDatabase();
        this.statement = conno.createSte();
    }

    /**
     * La fonction responsable de toutes les insertions dans les databases
     * @param s La fonction à exécuter
     * @return Le succès ou non de la fonction 's'
     */
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

    /**
     * Fonction qui sert de hub à toutes fonction de sélection qui retourne un set de résultat
     * @param s La commande à exécuter
     * @return Le set de résultat
     */
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
